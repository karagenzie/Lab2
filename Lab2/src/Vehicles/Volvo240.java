package Vehicles;

import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    /**
     * Calls the superclass constructor with certain parameters
     */

    public Volvo240(){

        super(4, 100, Color.black, "Volvo240", 1300);

    }


    /**
     * Returns the speed factor
     * Overrides the super class's abstract speed factor class
     * It is now equal to the engine power multiplied by the trim factor,
     * multiplied by 0.01.
     * @return the speed factor
     */

    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}




































/*
public class Vehicles.Volvo240 implements getAndSet, Engine, Movable{

    private final static double trimFactor = 1.25;

    private Vehicles.Car car;

    public Vehicles.Volvo240(){

        car = new Vehicles.Car(4, 100, Color.black, "Vehicles.Volvo240");

    }

    private double speedFactor(){
        return car.getEnginePower() * 0.01 * trimFactor;
    }


    public int getNrDoors() {
        return car.getNrDoors();
    }


    public double getEnginePower() {
        return car.getEnginePower();
    }


    public double getCurrentSpeed() {
        return car.getCurrentSpeed();
    }


    public Color getColor() {
        return car.getColor();
    }


    public void setColor(Color clr) {
        car.setColor(clr);
    }


    public void startEngine() {
        car.startEngine();

    }


    public void stopEngine() {
        car.stopEngine();
    }


    public void move() {
        car.move();
    }

    public void turnLeft() {
        car.turnLeft();
    }

    public void turnRight() {
        car.turnRight();
    }

    public String getDirection() {
        return car.getDirection();
    }

    public Vehicles.Location getPosition() {
        return car.getPosition();
    }

    public void gas(double amount){

        car.gas(amount, speedFactor());

    }

    public void brake(double amount){

        car.brake(amount, speedFactor());

    }


}
*/