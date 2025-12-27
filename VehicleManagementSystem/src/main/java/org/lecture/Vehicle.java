package org.lecture;

import java.util.List;

public class Vehicle {

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
