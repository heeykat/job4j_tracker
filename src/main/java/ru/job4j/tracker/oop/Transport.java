package ru.job4j.tracker.oop;

public class Transport {
    public static void main(String[] args) {
        Vehicle passengerPlane = new Airplane("passengerPlane", 100);
        Vehicle cargoPlane = new Airplane("cargoPlane", 0);
        Vehicle intercityBus = new Bus("intercityBus", 30);
        Vehicle minibus = new Bus("minibus", 12);
        Vehicle electricTrain = new Train("electricTrain", 2400);
        Vehicle passengerTrain = new Train("passengerTrain", 540);

        Vehicle[] vehicles = new Vehicle[]{passengerPlane, cargoPlane, intercityBus,
                minibus, electricTrain, passengerTrain};
        for (Vehicle vehicle :vehicles) {
            vehicle.move();
        }

        for (Vehicle vehicle :vehicles) {
            vehicle.passengers();
        }

    }
}
