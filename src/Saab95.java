import java.awt.*;

public class Saab95 implements getAndSet, Engine, Movable{

    private boolean turboOn;
    private Car car;

    /**
     * Calls the Car constructor with certain parameters
     * Also sets the turbo to off
     */

    public Saab95(){

        car = new Car(2, 125, Color.red, "Saab95");
        turboOn = false;

    }

    /**
     * Sets the turbo to on
     */

    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Sets the turbo to off
     */

    public void setTurboOff(){
	    turboOn = false;
    }

    private double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
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

    public String getPosition() {
        return car.getPosition();
    }

    public void gas(double amount){

        car.gas(amount, speedFactor());

    }

    public void brake(double amount){

        car.brake(amount, speedFactor());

    }

}
