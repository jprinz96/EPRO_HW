package org.lecture;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VehicleFileReader {
    //1 Fahrzeug aus Datei lesen
    //Die Datei enthält Informationen zu Fahrzeugen (z. B. ID = int, Marke = String, Modell = String, Fahrzeugtyp=Enum Vehicle, Baujahr= int, Kilometerstand= int, Preis=int).

    public List<Vehicle> readVehiclesFromCsv(String filePath) {
        List<Vehicle> vehicles = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int lineNumber = 1;
            String line;
            br.readLine(); //1. Zeile überspringen

            //ID;Marke;Modell;Fahrzeugtyp;Baujahr;Kilometerstand;Preis
            while ((line = br.readLine()) != null) {
                lineNumber++;
                String[] values = line.split(";");
                int expectetColumns = 7;

                //leere Zeilen werden ignoriert. Web: https://stackoverflow.com/questions/14721397/checking-if-a-string-is-empty-or-null-in-java
                if (line == null || line.trim().isEmpty()) {
                    System.out.printf("Row %d is empty and will be ignored%n", lineNumber);
                    continue;
                }
                //Zeile hat nicht genug Spalten (keine leeren Werte)
                else if (values.length < expectetColumns) {
                    System.out.printf("Row %d has not enough columns/values (&d) and will be ignored%n", lineNumber, values.length);
                    continue;
                }

                int id = Integer.parseInt(values[0]);
                String brand = values[1];
                String model = values[2];
                VehicleType type = VehicleType.valueOf(values[3].toUpperCase());
                int year = Integer.parseInt(values[4]);
                //Baujahr muss zwischen 1900 und aktuellem Jahr liegen
                if ((year < 1900) || (year > java.time.Year.now().getValue())) { //https://www.geeksforgeeks.org/java/java-time-year-class-in-java/
                    System.out.printf("Row %d has invalid year (%d) and will be ignored%n", lineNumber, year);
                    continue;
                }
                int mileage = Integer.parseInt(values[5]);
                int price = Integer.parseInt(values[6]);
                //Km und Preis dürfen nicht negativ sein
                if (mileage < 0) {
                    System.out.printf("Row %d has negative mileage (%d) and will be ignored%n", lineNumber, mileage);
                    continue;
                } else if (price < 0) {
                    System.out.printf("Row %d has negative price (%d) and will be ignored%n", lineNumber, price);
                    continue;

                }
                Vehicle vehicle = new Vehicle(id, brand, model, type, year, mileage, price);
                vehicles.add(vehicle);
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file. " + filePath);
            System.out.println(e.getMessage());
        }
        return vehicles;
    }

}
