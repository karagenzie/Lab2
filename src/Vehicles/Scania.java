package Vehicles;

import java.awt.*;

public class Scania extends MotorVehicle implements TruckBed {

    private Ramp truckBed;

    /**
     * The constructor for the Vehicles.Scania truck
     */

    public Scania() {

        super(2, 600, Color.white, "Vehicles.Scania", 13000);
        truckBed = new Ramp();
    }

    private boolean roadReady() {
        return (truckBed.getAngle() == 0);
    }

    /**
     * Moves the Vehicles.Scania truck
     */

    @Override
    public void move() {

        if (roadReady())
            super.move();
        else
            System.out.println("Truck can't move while bed is raised");
    }

    /**
     * Reverses the Vehicles.Scania truck
     */

    @Override
    public void reverse() {

        if (roadReady())
            super.reverse();
        else
            System.out.println("Truck can't move while bed is raised");

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

}

