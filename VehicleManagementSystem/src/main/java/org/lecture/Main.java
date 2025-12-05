package org.lecture;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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

                }
                case 0 -> {
                    temp = false;
                }
                default -> {
                    System.out.println("Invalid choice");
                }
            }

        }



/*
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    */
/*
        //Filterungen
        VehicleFilter vehicleFilter = new VehicleFilter();

        //nach Typ
        //System.out.println("Which type of vehicle would you like to filter? (PKW,TRANSPORTER, MOTORRAD): ");

       // VehicleType selectedVehicleType = VehicleType.valueOf(scan.nextLine().toUpperCase());
        List<Vehicle> filteredVehicles;
        //filteredVehicles = vehicleFilter.filterByType(vehicles,selectedVehicleType);
      /*  for (Vehicle vehicle : filteredVehicles) {
            System.out.println(vehicle);
        }
*/
        //Preis von bis
       /* System.out.println("Enter the startprice: ");
        int startprice = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter the endprice: ");
        int endprice = scan.nextInt();
        scan.nextLine();
        filteredVehicles = vehicleFilter.filterByPrice(vehicles, startprice, endprice);
        for (Vehicle vehicle : filteredVehicles) {
            System.out.println(vehicle);
        }
*/
        /*
        //ab Baujahr ...
        System.out.println("Enter the year of manufacture from which the search should start: ");
        int year = scan.nextInt();
        scan.nextLine();

        filteredVehicles = vehicleFilter.filterByYear(vehicles,year);
        for (Vehicle vehicle : filteredVehicles) {
            System.out.println(vehicle);
        }
*/

/*
        System.out.println("Price increase by how much %: ");
        double percent = scan.nextInt();
        scan.nextLine();

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
            vehicle.setPrice(vehicle.getPrice() + ((percent / 100) * vehicle.getPrice()));
            System.out.println(vehicle);
            System.out.println("_______________________________________");
        }

        System.out.println("Price decrease by how much %: ");
        double percent = scan.nextInt();
        scan.nextLine();

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
            vehicle.setPrice(vehicle.getPrice() - ((percent / 100) * vehicle.getPrice()));
            System.out.println(vehicle);
            System.out.println("_______________________________________");
        }

*/


    }
}
