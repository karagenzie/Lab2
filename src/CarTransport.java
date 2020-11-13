import java.awt.*;
import java.util.ArrayList;

public class CarTransport implements Engine, getAndSet, Movable, Ramp{

    private Scania truck;
    private ArrayList<Car> cars;

    public CarTransport(double enginePower){

        truck = new Scania(2, enginePower, Color.BLACK, "Car Transport");

        cars = new ArrayList<Car>();

    }

    public int getNrDoors() {
        return truck.getNrDoors();
    }


    public double getEnginePower(){
        return truck.getEnginePower();
    }


    public double getCurrentSpeed() {
        return truck.getCurrentSpeed();
    }


    public Color getColor() {
        return truck.getColor();
    }


    public void setColor(Color clr) {
        truck.setColor(clr);
    }

    public void startEngine() {
        truck.startEngine();

    }


    public void stopEngine() {
        truck.stopEngine();
    }


    public void move() {
        truck.move();
    }

    public void turnLeft() {
        truck.turnLeft();
    }

    public void turnRight() {
        truck.turnRight();
    }

    public String getDirection() {
        return truck.getDirection();
    }

    public Location getPosition() {
        return truck.getPosition();
    }

    public void gas(double amount){

        truck.gas(amount);

    }

    public void brake(double amount){

        truck.brake(amount);

    }

    public void raiseRamp(){

        truck.raiseBed(70);

    }

    public void lowerRamp(){

        truck.lowerBed(70);

    }

    private boolean rampIsDown(){
        return (truck.getBedAngle() == 0);
    }

    public void loadOn(){


    }
    public void loadOff(){

    }



}

