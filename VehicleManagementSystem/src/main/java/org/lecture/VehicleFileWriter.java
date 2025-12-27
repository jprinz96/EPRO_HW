package org.lecture;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class VehicleFileWriter {

    public boolean writeVehiclesToCsv(String filePath, List<Vehicle> vehicles) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Vehicle vehicle : vehicles) {
                bw.write(vehicle.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing vehicles to CSV file" + filePath);
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}
