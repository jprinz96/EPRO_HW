package org.lecture;

import java.util.ArrayList;
import java.util.List;

public class VehicleFilter {
    //menü?


    //Filter nach Fahrzeugtyp (Enum VehicleType)
    public List<Vehicle> filterByType(List<Vehicle> vehicles, VehicleType vehicleType) {

            List<Vehicle> filteredVehiclesByType = new ArrayList<>();
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getType() == vehicleType) {
                    filteredVehiclesByType.add(vehicle);
                }
            }
            if (filteredVehiclesByType.isEmpty()) {
                System.out.println("No vehicles found for type " + vehicleType);
            }
            return filteredVehiclesByType;

    }

    public List<Vehicle> filterByPrice(List<Vehicle> vehicles, int startPrice, int endPrice) {
        List<Vehicle> filteredVehiclesByPrice = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPrice() >= startPrice && vehicle.getPrice() <= endPrice) {
                filteredVehiclesByPrice.add(vehicle);
            }

        }
        if (filteredVehiclesByPrice.isEmpty()) {
            System.out.println("No vehicles found for price " + startPrice + " and " + endPrice);
        }
        return filteredVehiclesByPrice;
    }

    public List<Vehicle> filterByYear(List<Vehicle> vehicles,int year) {
        List<Vehicle> filteredVehiclesByYear = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getYear() >= year) {
                filteredVehiclesByYear.add(vehicle);
            }
        }
        if (filteredVehiclesByYear.isEmpty()) {
            System.out.println("No vehicles found for year " + year);
        }

        return filteredVehiclesByYear;
    }

}
