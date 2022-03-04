package ood.parking_lot;

public class ParkingSpot {
    private final Vehicle vehicle;
    private final VehicleSize spotSize;
    private final int row;
    private final int spotNumber;
    private Level level;

    public ParkingSpot(Vehicle vehicle, VehicleSize spotSize, int row, int spotNumber) {
        this.vehicle = vehicle;
        this.spotSize = spotSize;
        this.row = row;
        this.spotNumber = spotNumber;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle.size == spotSize;
    }

    public boolean park(Vehicle v) {
        return false;
    }

    public int getRow() {
        return row;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void removeVehicle() {
    }

    public VehicleSize getSpotSize() {
        return spotSize;
    }
}
