package org.lecture;

import java.util.List;
import java.util.Scanner;

public class VehicleProgramManager {
    // List <Vehicle> vehicleList = new ArrayList<>();
    private static Scanner scan = new Scanner(System.in);


    public static void menu() {

        System.out.printf("""
                ----- Vehicle Management System-----
                1 - List all vehicles
                2 - Filter vehicles by type
                3 - Filter vehicles by price
                4 - Filter vehicles by year
                5 - Increase all vehicle prices
                6 - Reduce  all vehicle prices
                7 - Average of all vehicle prices
                8 - Number of vehicles per type
                9 - List all validation errors
                0 - Beenden
                """);
    }

    public static void printVehicles(List<Vehicle> vehicles) {
        System.out.println("----- Vehicles -----");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }

    }

    public static VehicleType readVehicleType() {
        while (true) {
            System.out.println("Which type of vehicle would you like to filter? (PKW,TRANSPORTER, MOTORRAD): ");
            String selectedVehicleType = scan.nextLine().toUpperCase();
            try {
                return VehicleType.valueOf(selectedVehicleType);

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input: " + e.getMessage());
            }
        }
    }

    public static double calcAvgPrice(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Vehicle vehicle : vehicles) {
            sum += vehicle.getPrice();
        }
        return sum / vehicles.size();
    }

    public static void countVehicleTypes(List<Vehicle> vehicles) {
        int countPKW =0;
        int countTransporter =0;
        int countMotorrad =0;

        for (Vehicle vehicle : vehicles){
            if (vehicle.getType().equals(VehicleType.PKW)){
                countPKW++;
            }
            if (vehicle.getType().equals(VehicleType.TRANSPORTER)){
                countTransporter++;
            }
            if (vehicle.getType().equals(VehicleType.MOTORRAD)){
                countMotorrad++;
            }

        }
        System.out.printf("PKW: %d\nTransporter %d\nMotorrad: %d\n",countPKW,countTransporter,countMotorrad);
    }

}
