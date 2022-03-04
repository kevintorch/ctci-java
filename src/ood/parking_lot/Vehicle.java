package ood.parking_lot;

import java.util.ArrayList;

public abstract class Vehicle {
    protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();
    protected String licensePlate;
    protected int spotsNeeded;
    protected VehicleSize size;

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public VehicleSize getSize() {
        return size;
    }

    public void parkInSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
    }

    public void clearSpots() {
        parkingSpots.clear();
    }

    public abstract boolean canFitInSpot(ParkingSpot spot);
}
