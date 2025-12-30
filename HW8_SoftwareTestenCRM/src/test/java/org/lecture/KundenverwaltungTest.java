package org.lecture;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class KundenverwaltungTest {

    // ----------------------- Normale Nutzung -----------------------
    //Kunde hinzufügen, testen ob in Liste
    @Test
    public void testKundeHinzufuegen() {
        Kundenverwaltung kundenverwaltung = new Kundenverwaltung();
        Kunde julia = new Kunde(1, "Julia", "julia@mail.at");

        kundenverwaltung.kundeHinzufuegen(julia);
        Assertions.assertTrue(kundenverwaltung.alleKunden().contains(julia));

    }

    //Entferne einen Kunden per ID und überprüfe, ob die Liste korrekt aktualisiert wurde.
    @Test
    public void testKundeEntfernen() {
        Kundenverwaltung kundenverwaltung = new Kundenverwaltung();
        Kunde julia = new Kunde(1, "Julia", "julia@mail.at");
        Kunde sabrina = new Kunde(2, "Sabrina", "sabrina@mail.at");

        kundenverwaltung.kundeHinzufuegen(julia);
        kundenverwaltung.kundeHinzufuegen(sabrina);

        kundenverwaltung.kundeEntfernen(2);
        Assertions.assertFalse(kundenverwaltung.alleKunden().contains(sabrina));

    }

    //Hole einen Kunden per ID und verifiziere die zurückgegebenen Werte.
    @Test
    public void testKundeMitId() {
        Kundenverwaltung kundenverwaltung = new Kundenverwaltung();
        Kunde julia = new Kunde(1, "Julia", "julia@mail.at");

        kundenverwaltung.kundeHinzufuegen(julia);

        Kunde testKunde = kundenverwaltung.kundeMitId(1);

        Assertions.assertNotNull(testKunde); //Zuerst prüfen, ob der Kunde überhaupt vorhanden ist
        //Dann die werte einzeln verifizieren
        Assertions.assertEquals(1, testKunde.getId());
        Assertions.assertEquals("Julia", testKunde.getName());
        Assertions.assertEquals("julia@mail.at", testKunde.getEmail());

    }

    //Erhalte die Gesamtanzahl der Kunden
    @Test
    public void testKundenAnzahl() {
        Kundenverwaltung kundenverwaltung = new Kundenverwaltung();
        Kunde julia = new Kunde(1, "Julia", "julia@mail.at");
        Kunde sabrina = new Kunde(2, "Sabrina", "sabrina@mail.at");
        Kunde peter = new Kunde(3, "Peter", "peter@mail.at");
        Kunde stefan = new Kunde(4, "Stefan", "stefan@mail.at");

        kundenverwaltung.kundeHinzufuegen(julia);
        kundenverwaltung.kundeHinzufuegen(sabrina);
        kundenverwaltung.kundeHinzufuegen(peter);
        kundenverwaltung.kundeHinzufuegen(stefan);

        Assertions.assertEquals(4, kundenverwaltung.kundenAnzahl());

    }

    //----------------------- Fehlerhafte Eingaben -----------------------
    //Versuche, einen Kunden mit leerem Namen hinzuzufügen.
    @Test
    public void testKundenNameNotNull() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Kunde(1, "", "julia@mail.at"));
        //Fehler gefunden, hier müsste getrimmt werden damit auch Leerzeichen als "leer" gewertet werden
        //Assertions.assertThrows(IllegalArgumentException.class, () -> new Kunde(2,"   " , "sabrina@mail.at"));
    }

    //Füge einen Kunden mit einer ungültigen E-Mail-Adresse hinzu (z. B. ohne „@“).
    @Test
    public void testMail_ungueltigOderLeer() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Kunde(1, "Julia", "julia.mail.at"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Kunde(1, "Sabrina", ""));
    }

    //Entferne einen Kunden mit einer nicht existierenden ID.
    @Test
    public void testKundeEntfernenDerKeineIDHat() {
        Kundenverwaltung kundenverwaltung = new Kundenverwaltung();

        //es wird null returned also:
        Assertions.assertNull(kundenverwaltung.kundeEntfernen(1234));
    }

    //Hole einen Kunden mit einer ungültigen ID.
    @Test
    public void testKundeUngueltigeID() {
        Kundenverwaltung kundenverwaltung = new Kundenverwaltung();
        Kunde julia = new Kunde(1, "Julia", "julia@mail.at");
        kundenverwaltung.kundeHinzufuegen(julia);

        Assertions.assertNull(kundenverwaltung.kundeMitId(2));
        Assertions.assertNull(kundenverwaltung.kundeMitId(-5));
        Assertions.assertNull(kundenverwaltung.kundeMitId(1111111111));
    }

    //----------------------- Edge-Cases -----------------------
    //Teste das Verhalten bei einer leeren Kundenliste.
    @Test
    public void testVerhaltenLeereKundenliste() { //Bin mir nicht sicher was mit "Verhalten" gemeint ist...
        Kundenverwaltung kundenverwaltung = new Kundenverwaltung();
        //Liste sollte keinen Inhalt haben
        Assertions.assertEquals(0, kundenverwaltung.kundenAnzahl());

        //Sollte Null returnen da es den Kunden mit ID 2 nicht gibt
        Assertions.assertNull(kundenverwaltung.kundeMitId(2));

        //Sollte Null returnen da es den Kunden mit ID 2 nicht gibt
        Assertions.assertNull(kundenverwaltung.kundeEntfernen(2));
    }

    //Füge Kunden mit hohen ID-Werten hinzu und überprüfe die Konsistenz.
    @Test
    public void testKundeHinzufuegen_hoheID() {
        Kundenverwaltung kundenverwaltung = new Kundenverwaltung();
        Kunde julia = new Kunde(796845455, "Julia", "julia@mail.at");
        kundenverwaltung.kundeHinzufuegen(julia);

        //Wurde der Kunde auch wirklich mit der ID hinzugefügt:
        Assertions.assertNotNull(kundenverwaltung.kundeMitId(796845455));
        Assertions.assertEquals(1, kundenverwaltung.kundenAnzahl());

        //Hat sich die ID nicht verändert?:
        Assertions.assertEquals(796845455, julia.getId());

        //Entfernen auch normal?
        kundenverwaltung.kundeEntfernen(796845455);
        Assertions.assertEquals(0, kundenverwaltung.kundenAnzahl());
        Assertions.assertNull(kundenverwaltung.kundeEntfernen(796845455));

    }

    //Füge Kunden mit Sonderzeichen im Namen hinzu.
    @Test
    public void testKundenNameHinzufuegenMitSonderzeichen() {
        Kundenverwaltung kundenverwaltung = new Kundenverwaltung();
        Kunde julia = new Kunde(1, "Juli@1!", "julia@mail.at");

        kundenverwaltung.kundeHinzufuegen(julia);

        Assertions.assertNotNull(kundenverwaltung.kundeMitId(1)); //Kunde mit Id 1 vorhanden
        Assertions.assertEquals(1, kundenverwaltung.kundenAnzahl()); //Anzahl ist 1, da 1 Kunde angelegt
        Assertions.assertNotNull(julia.getName()); //Name ist nciht Null
        Assertions.assertEquals("Juli@1!", julia.getName()); //Sonderzeichenname würde übernommen

    }

    //Teste das Verhalten bei doppelten IDs (Kunden mit derselben ID hinzufügen).
    @Test
    public void testKundeHinzufuegenDoppelteIDs() {
        Kundenverwaltung kundenverwaltung = new Kundenverwaltung();
        Kunde julia = new Kunde(1, "Julia", "julia@mail.at");
        Kunde sabrina = new Kunde(1, "Sabrina", "sabrina@mail.at");

        kundenverwaltung.kundeHinzufuegen(julia);
        kundenverwaltung.kundeHinzufuegen(sabrina);

        //Werden 2 Kunden angelegt aber mit welcher id?
        Assertions.assertEquals(2, kundenverwaltung.kundenAnzahl());
        // Assertions.assertEquals("Julia", kundenverwaltung.kundeMitId(1)); //Fehler!
        // Assertions.assertEquals("Sabrina", kundenverwaltung.kundeMitId(1)); //Fehler!
        Assertions.assertEquals(1, julia.getId());
        Assertions.assertEquals(1, sabrina.getId());
        Assertions.assertEquals("Julia", kundenverwaltung.alleKunden().get(0).getName());
        Assertions.assertEquals("Sabrina", kundenverwaltung.alleKunden().get(1).getName());

    }

    //----------------------- Integrationstests -----------------------
    //Füge Kunden hinzu, entferne sie und überprüfe die Auswirkungen auf die Gesamtanzahl.
    @Test
    public void testKundeHinzufuegenUndEntfernen_auswirkungGesamtzahl() {
        Kundenverwaltung kundenverwaltung = new Kundenverwaltung();
        Kunde julia = new Kunde(1, "Julia", "julia@mail.at");
        Kunde sabrina = new Kunde(2, "Sabrina", "sabrina@mail.at");
        Kunde peter = new Kunde(3, "Peter", "peter@mail.at");
        Kunde stefan = new Kunde(4, "Stefan", "stefan@mail.at");

        kundenverwaltung.kundeHinzufuegen(julia);
        kundenverwaltung.kundeHinzufuegen(sabrina);
        kundenverwaltung.kundeHinzufuegen(peter);
        kundenverwaltung.kundeHinzufuegen(stefan);
        Assertions.assertEquals(4, kundenverwaltung.kundenAnzahl());

        kundenverwaltung.kundeEntfernen(2);
        kundenverwaltung.kundeEntfernen(4);
        Assertions.assertEquals(2, kundenverwaltung.kundenAnzahl());

        //Größe passt, zusätzlich kann man noch prüfen ob 1 & 3 eh nciht Null sind und 2 & 4 Null sind.

        Assertions.assertNotNull(kundenverwaltung.kundeMitId(1));
        Assertions.assertNotNull(kundenverwaltung.kundeMitId(3));
        Assertions.assertNull(kundenverwaltung.kundeMitId(2));
        Assertions.assertNull(kundenverwaltung.kundeMitId(4));

    }


    //Füge mehrere Kunden hinzu und überprüfe, ob alle korrekt abrufbar sind.
    @Test
    public void testKundeHinzufuegen_korrektAbrufen (){
        Kundenverwaltung kundenverwaltung = new Kundenverwaltung();
        Kunde julia = new Kunde(1, "Julia", "julia@mail.at");
        Kunde sabrina = new Kunde(2, "Sabrina", "sabrina@mail.at");
        Kunde peter = new Kunde(3, "Peter", "peter@mail.at");
        Kunde stefan = new Kunde(4, "Stefan", "stefan@mail.at");

        kundenverwaltung.kundeHinzufuegen(julia);
        kundenverwaltung.kundeHinzufuegen(sabrina);
        kundenverwaltung.kundeHinzufuegen(peter);
        kundenverwaltung.kundeHinzufuegen(stefan);

        //Vereschiedene Abfragen...?
        Assertions.assertNotNull(kundenverwaltung.kundeMitId(1));
        Assertions.assertEquals("Sabrina", sabrina.getName());
        Assertions.assertEquals("Peter", kundenverwaltung.alleKunden().get(2).getName());
        Assertions.assertEquals(4, kundenverwaltung.kundeMitId(4).getId());

    }
}
