package org.lecture;

import java.util.List;

public class Vehicle {


    /*
    4.	Fahrzeuge nach bestimmten Kriterien filtern
o	Implementiere Funktionen, um Fahrzeuge nach Kriterien zu filtern:
	Nach Fahrzeugtyp (z. B. alle PKWs).
	Nach Preisbereich (z. B. 10.000–20.000 Euro).
	Nach Baujahr (z. B. Fahrzeuge ab 2018).
	Nach maximalem Kilometerstand (z. B. bis zu 50.000 Kilometer).

5.	Preisänderung auf Basis von Fahrzeugtypen
o	Erstelle eine Funktion, die für einen bestimmten Fahrzeugtyp den Preis um einen einstellbaren Prozentsatz erhöht oder senkt.
o	Beispiel: Reduzierung des Preises aller Motorräder um 10 %.

8.	Statistische Auswertung
o	Durchschnittspreis: Implementiere eine Funktion, die den Durchschnittspreis aller Fahrzeuge oder eines bestimmten Typs berechnet.
o	Anzahl Fahrzeuge pro Typ: Berechne die Anzahl der Fahrzeuge pro Fahrzeugtyp und gib diese aus.

     */


    private int id;
    private String brand;
    private String model;
    VehicleType type;
    private int year;
    private int mileage;
    private double price;

    public Vehicle(int id, String brand, String model, VehicleType type, int year, int mileage, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("Vehilce: %d. Brand: %s, Model: %s, Type: %s, Year: %d, Mileage: %d, Price: %.2f ", id, brand, model, type, year, mileage, price);
    }
}
