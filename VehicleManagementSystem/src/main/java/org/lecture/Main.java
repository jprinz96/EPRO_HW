package org.lecture;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    static void main() {

        VehicleFileReader vehicleFileReader = new VehicleFileReader();
        Path inputFilePath = Paths.get("src", "main", "resources", "fahrzeuge.csv");

        List<Vehicle> vehicles = vehicleFileReader.readVehiclesFromCsv(inputFilePath.toString());
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }



    }
}
