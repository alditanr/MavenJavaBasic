package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

// Custom exception class for invalid year
class InvalidYearException extends Exception {
    public InvalidYearException(String message) {
        super(message);
    }
}

// Base class Vehicle
class Vehicle {
    // Properties
    protected String brand;
    protected String model;
    protected int year;

    // Constructor
    public Vehicle(String brand, String model, int year) throws InvalidYearException {
        if (year > 2024) { // Assuming current year is 2024
            throw new InvalidYearException("Invalid year: " + year);
        }
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
}

// Subclass Car
class Car extends Vehicle {
    // Unique property
    private int numOfDoors;

    // Constructor
    public Car(String brand, String model, int year, int numOfDoors) throws InvalidYearException {
        super(brand, model, year);
        this.numOfDoors = numOfDoors;
    }
}

// Subclass Motorcycle
class Motorcycle extends Vehicle {
    // Unique property
    private boolean hasSidecar;

    // Constructor
    public Motorcycle(String brand, String model, int year, boolean hasSidecar) throws InvalidYearException {
        super(brand, model, year);
        this.hasSidecar = hasSidecar;
    }
}

public class Assessment3 {
    Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("Selamat datang di Program Kendaraan!");
        System.out.println("Pilih jenis kendaraan:");
        System.out.println("1. Car");
        System.out.println("2. Motorcycle");
        System.out.println("3. Exit");
    }

    public void createVehicle(int choice) {
        try {
            switch (choice) {
                case 1:
                    System.out.println("Masukkan brand mobil:");
                    String carBrand = scanner.next();
                    System.out.println("Masukkan model mobil:");
                    String carModel = scanner.next();
                    System.out.println("Masukkan tahun mobil:");
                    int carYear = scanner.nextInt();
                    System.out.println("Masukkan jumlah pintu mobil:");
                    int carDoors = scanner.nextInt();
                    new Car(carBrand, carModel, carYear, carDoors);
                    System.out.println("Car created successfully.");
                    break;
                case 2:
                    System.out.println("Masukkan brand motor:");
                    String motorBrand = scanner.next();
                    System.out.println("Masukkan model motor:");
                    String motorModel = scanner.next();
                    System.out.println("Masukkan tahun motor:");
                    int motorYear = scanner.nextInt();
                    System.out.println("Apakah motor memiliki sidecar? (true/false):");
                    boolean hasSidecar = scanner.nextBoolean();
                    new Motorcycle(motorBrand, motorModel, motorYear, hasSidecar);
                    System.out.println("Motorcycle created successfully.");
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        } catch (InvalidYearException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException ime) {
            System.out.println("Please enter valid input.");
            scanner.next(); // to consume the invalid token
        }
    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.println("Masukkan pilihan anda: ");
            try {
                int choice = scanner.nextInt();
                createVehicle(choice);
                System.out.println();
            } catch (InputMismatchException ime) {
                System.out.println("Please enter a valid integer.");
                scanner.next(); // to consume the invalid token
            }
        }
    }

    public static void main(String[] args) {
        Assessment3 drawer = new Assessment3();
        drawer.run();
    }
}