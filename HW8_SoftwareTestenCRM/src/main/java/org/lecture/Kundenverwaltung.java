package org.lecture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kundenverwaltung {
    private final List<Kunde> kundenListe;

    public Kundenverwaltung() {
        this.kundenListe = new ArrayList<>();
    }

    public void kundeHinzufuegen(Kunde kunde) {
        if (kunde == null) {
            throw new IllegalArgumentException("Kunde darf nicht null sein.");
        }
        kundenListe.add(kunde);
    }

    public Kunde kundeEntfernen(int id) {
        Kunde zuEntfernen = null;
        for (Kunde kunde : kundenListe) {
            if (kunde.getId() == id) {
                zuEntfernen = kunde;
                break;
            }
        }
        if (zuEntfernen != null) {
            kundenListe.remove(zuEntfernen);
        }
        return zuEntfernen;
    }

    public Kunde kundeMitId(int id) {
        for (Kunde kunde : kundenListe) {
            if (kunde.getId() == id) {
                return kunde;
            }
        }
        return null;
    }

    public List<Kunde> alleKunden() {
        return new ArrayList<>(kundenListe);
    }

    public int kundenAnzahl() {
        return kundenListe.size();
    }
}

