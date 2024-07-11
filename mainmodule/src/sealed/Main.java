package src.sealed;

public class Main {

    public static void main(String[] args) {
        Car car = new Car(4, "HA1234BAE");
        int carMaxServiceIntervalInMonths = car.getMaxServiceIntervalInMonths();
        int maxDistanceBetweenServicesInKilometers = car.getMaxDistanceBetweenServicesInKilometers();

        Truck truck = new Truck(12, "TR4321WAG");
        int truckMaxServiceIntervalInMonths = truck.getMaxServiceIntervalInMonths();
        int truckMaxDistanceBetweenServicesInKilometers = truck.getMaxDistanceBetweenServicesInKilometers();

        System.out.println("carMaxServiceIntervalInMonths: " + carMaxServiceIntervalInMonths);
        System.out.println("truckMaxServiceIntervalInMonths: " + truckMaxServiceIntervalInMonths);
        System.out.println("maxDistanceBetweenServicesInKilometers: " + maxDistanceBetweenServicesInKilometers);
        System.out.println("truckMaxDistanceBetweenServicesInKilometers: " + truckMaxDistanceBetweenServicesInKilometers);

        Vehicle carVehicle = getVehicle(new Car(6, "VE6789HIC"));
        Vehicle truckVehicle = getVehicle(new Truck(6, "VE6789HIC"));

        if (truckVehicle instanceof Car car1) {
            System.out.println("vehicle is an instance of car");
        } else {
            System.out.println("vehicle is an instance of truck");
        }
    }

    static Vehicle getVehicle(Vehicle vehicle) {
        System.out.println(vehicle.getRegistrationNumber());
        return vehicle;
    }
}
