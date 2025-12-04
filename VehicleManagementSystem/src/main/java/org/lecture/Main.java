package org.lecture;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scan = new Scanner(System.in);

        VehicleFileReader vehicleFileReader = new VehicleFileReader();
        Path inputFilePath = Paths.get("src", "main", "resources", "fahrzeuge.csv");

        List<Vehicle> allVehicles = vehicleFileReader.readVehiclesFromCsv(inputFilePath.toString());

/*
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    */

        //Filterungen
        VehicleFilter vehicleFilter = new VehicleFilter();

        //nach Typ
        //System.out.println("Which type of vehicle would you like to filter? (PKW,TRANSPORTER, MOTORRAD): ");

       // VehicleType selectedVehicleType = VehicleType.valueOf(scan.nextLine().toUpperCase());
        List<Vehicle> filteredVehicles;
        //filteredVehicles = vehicleFilter.filterByType(allVehicles,selectedVehicleType);
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
        filteredVehicles = vehicleFilter.filterByPrice(allVehicles, startprice, endprice);
        for (Vehicle vehicle : filteredVehicles) {
            System.out.println(vehicle);
        }
*/
        //ab Baujahr ...
        System.out.println("Enter the year of manufacture from which the search should start: ");
        int year = scan.nextInt();
        scan.nextLine();

        filteredVehicles = vehicleFilter.filterByYear(allVehicles,year);
        for (Vehicle vehicle : filteredVehicles) {
            System.out.println(vehicle);
        }







    }
}
