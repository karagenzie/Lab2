import java.awt.*;

public class Volvo240 implements getAndSet, Engine, Movable{

    private final static double trimFactor = 1.25;

    private Car car;

    public Volvo240(){

        car = new Car(4, 100, Color.black, "Volvo240");

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

    public Location getPosition() {
        return car.getPosition();
    }

    public void gas(double amount){

        car.gas(amount, speedFactor());

    }

    public void brake(double amount){

        car.brake(amount, speedFactor());

    }


}
