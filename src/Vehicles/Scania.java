package Vehicles;

import java.awt.*;

public class Scania extends MotorVehicle implements TruckBed {

    private Ramp truckBed;

    /**
     * The constructor for the Vehicles.Scania truck
     */

    public Scania() {

        super(2, 600, Color.white, "Scania", 13000);
        truckBed = new Ramp();
    }

    /**
     * Raises the truck bed by a given angle
     * Cannot exceed 70 degrees
     * @param angle the truck bed angle
     */

    public void raiseBed(int angle) {

        if (getCurrentSpeed() == 0)
            truckBed.raiseRamp(angle);
        else
            System.out.println("You can't raise the bed when the truck is moving.");
    }

    /**
     * Lowers the truck bed by a given angle
     * Cannot go lower than 0
     * @param angle the truck bed angle
     */

    public void lowerBed(int angle) {
        truckBed.lowerRamp(angle);
    }

    /**
     * Returns the truck bed angle
     * @return the truck bed angle
     */

    public int getBedAngle() {
        return truckBed.getAngle();
    }

    @Override
    public void startEngine(){
        if (getBedAngle() == 0)
            super.startEngine();
    }

    @Override
    public void gas(double amount){
        if (getBedAngle() == 0)
            super.gas(amount);
    }

}

