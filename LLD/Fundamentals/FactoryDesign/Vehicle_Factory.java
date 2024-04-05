package LLD.Fundamentals.FactoryDesign;

public class Vehicle_Factory {
    public static Vehicle getVehicle(String vehicleType) {
        if (vehicleType.equalsIgnoreCase("Car")) {
            return new Car();
        } else if (vehicleType.equalsIgnoreCase("Bike")) {
            return new Bike();
        } else {
            return null;
        }
    }
}
