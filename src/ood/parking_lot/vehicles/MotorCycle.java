package ood.parking_lot.vehicles;

import ood.parking_lot.ParkingSpot;
import ood.parking_lot.Vehicle;
import ood.parking_lot.VehicleSize;

public class MotorCycle extends Vehicle {
    public MotorCycle() {
        spotsNeeded = 1;
        size = VehicleSize.Motorcycle;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.canFitVehicle(this);
    }
}
