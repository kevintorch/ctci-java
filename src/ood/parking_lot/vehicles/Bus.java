package ood.parking_lot.vehicles;

import ood.parking_lot.ParkingSpot;
import ood.parking_lot.Vehicle;
import ood.parking_lot.VehicleSize;

public class Bus extends Vehicle {
    public Bus() {
        spotsNeeded = 5;
        size = VehicleSize.Large;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.canFitVehicle(this);
    }
}
