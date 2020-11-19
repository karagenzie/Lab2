import java.awt.*;

public class Scania extends MotorVehicle implements Engine, getAndSet, Movable, TruckBed {

    private Ramp truckBed;

    public Scania(double enginePower) {

        super(2, enginePower, Color.white, "Scania", 13000);
        truckBed = new Ramp();
    }

    private boolean roadReady() {
        return (truckBed.isDown());
    }

    public void startEngine() {
        if (roadReady())
            super.startEngine();
        else
            System.out.println("The bed can't be raised if you want to start the engine");
    }

    public void gas(double amount) {

        if (roadReady())
            super.gas(amount);
        else
            System.out.println("The bed can't be raised if you want to gas");
    }

    public void reverse() {

        if (roadReady()) {
            super.reverse();
        } else {
            System.out.println("Truck can't move while bed is raised");
        }
    }

    public void move() {

        if (roadReady()) {
            super.move();
        } else {
            System.out.println("Truck can't move while bed is raised");
        }
    }

    public void raiseBed(int angle) {

        if (getCurrentSpeed() == 0)
            truckBed.raiseRamp(angle);

        else
            System.out.println("You can't raise the bed when the truck is moving.");
    }

    public void lowerBed(int angle) {
        truckBed.lowerRamp(angle);
    }

    public int getBedAngle() {
        return truckBed.getAngle();
    }

}

