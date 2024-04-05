package LLD.Fundamentals.FactoryDesign;

import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the vehicle type (Car/Bike): ");
        String vehicleType = scanner.nextLine();

        // directly call the static function
        Vehicle vehicle = Vehicle_Factory.getVehicle(vehicleType);

        if (vehicle != null) {
            // Use the vehicle object
            vehicle.createVehicle();
        } else {
            System.out.println("Invalid vehicle type.");
        }

        scanner.close(); // Close the scanner when done
    }

    /*
     * Now it is a part of Vehicle_Factory class
     * public static Vehicle createVehicle(String vehicleType) {
     * if (vehicleType.equalsIgnoreCase("Car")) {
     * return new Car();
     * } else if (vehicleType.equalsIgnoreCase("Bike")) {
     * return new Bike();
     * } else {
     * return null;
     * }
     * }
     */
}
