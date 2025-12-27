package org.lecture;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scan = new Scanner(System.in);
        //1. File einlesen
        VehicleFileReader vehicleFileReader = new VehicleFileReader();
        Path inputFilePath = Paths.get("src", "main", "resources", "fahrzeuge.csv");

        List<Vehicle> vehicles = vehicleFileReader.readVehiclesFromCsv(inputFilePath.toString());
        List<Vehicle> filteredVehicles;
        //Vehicle Filter
        VehicleFilter vehicleFilter = new VehicleFilter();

        //2. Benutzermenü anzeigen
        boolean temp = true;
        while (temp == true) {
            VehicleProgramManager.menu();
            int choice = scan.nextInt();
            switch (choice) {
                case 1 -> VehicleProgramManager.printVehicles(vehicles);
                //Filter vehicles by type
                case 2 -> {
                    VehicleType selectedType = VehicleProgramManager.readVehicleType();
                    filteredVehicles = vehicleFilter.filterByType(vehicles, selectedType);
                    VehicleProgramManager.printVehicles(filteredVehicles);

                }
                //Filter vehicles by price
                case 3 -> {
                    System.out.println("Enter the starting price: ");
                    int startPrice = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter the ending price: ");
                    int endPrice = scan.nextInt();
                    scan.nextLine();
                    if (startPrice > endPrice) {
                        int temp2 = startPrice;
                        startPrice = endPrice;
                        endPrice = temp2;

                    }
                    filteredVehicles = vehicleFilter.filterByPrice(vehicles, startPrice, endPrice);
                    VehicleProgramManager.printVehicles(filteredVehicles);

                }
                //Filter vehicles by year
                case 4 -> {
                    System.out.println("Enter the year of manufacture from which the search should start: ");
                    int year = scan.nextInt();
                    scan.nextLine();

                    filteredVehicles = vehicleFilter.filterByYear(vehicles, year);
                    VehicleProgramManager.printVehicles(filteredVehicles);

                }
                //increase all vehicle prices
                case 5 -> {
                    System.out.println("Price increase by how much %: ");
                    double percent = scan.nextInt();
                    scan.nextLine();

                    for (Vehicle vehicle : vehicles) {
                        vehicle.setPrice(vehicle.getPrice() + ((percent / 100) * vehicle.getPrice()));
                        System.out.println(vehicle);
                    }


                }
                //reduce  all vehicle prices
                case 6 -> {
                    System.out.println("Price decrease by how much %: ");
                    double percent = scan.nextInt();
                    scan.nextLine();

                    for (Vehicle vehicle : vehicles) {
                        vehicle.setPrice(vehicle.getPrice() - ((percent / 100) * vehicle.getPrice()));
                        System.out.println(vehicle);

                    }

                }
                //Average of all vehicle prices
                case 7 -> {
                    double avgPrice = VehicleProgramManager.calcAvgPrice(vehicles);
                    System.out.println("Average: " + avgPrice);

                }
                //Number of vehicles per type
                case 8 -> {
                    VehicleProgramManager.countVehicleTypes(vehicles);


                }
                //Speichern in neue CSV-Datei
                case 9 -> {
                    VehicleFileWriter vehicleFileWriter = new VehicleFileWriter();
                    Path outputFilePath = Paths.get("src", "main", "resources", "fahrzeuge_new.csv");
                    boolean success = false;
                    try{
                        success = vehicleFileWriter.writeVehiclesToCsv(outputFilePath.toString(), vehicles);
                    }catch (Exception e){
                        throw new RuntimeException(e);
                    }
                    if (success) {
                        System.out.println("Produkte erfolgreich in die Datei geschrieben: " + outputFilePath);
                    } else {
                        System.out.println("Fehler beim Schreiben der Produkte in die Datei: " + outputFilePath);
                    }

                }
                case 0 -> {
                    temp = false;
                }
                default -> {
                    System.out.println("Invalid choice");
                }
            }

        }


    }
}
