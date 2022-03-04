package ood.parking_lot.vehicles;

import ood.parking_lot.ParkingSpot;
import ood.parking_lot.Vehicle;
import ood.parking_lot.VehicleSize;

public class Car extends Vehicle {
    public Car() {
        spotsNeeded = 1;
        size = VehicleSize.Compact;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.canFitVehicle(this);
    }
}
