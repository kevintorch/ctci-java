package ood.parking_lot;

public class Level {
    private static final int SPOTS_PER_ROW = 10;
    private int floor;
    private ParkingSpot[] spots;
    private int availableSpots = 0; // number of free spots

    public Level(int floor, int numberSpots) {
    }

    public int getAvailableSpots() {
        return availableSpots;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
        }
        return true;
    }

    private boolean parkStartingAtSpot(int num, Vehicle v) {
        return false;
    }

    private int findAvailableSpots(Vehicle vehicle) {
        return 0;
    }

    public void spotFreed() {
        availableSpots++;
    }
}
