import com.sun.jdi.connect.Transport;

import java.awt.*;
import java.util.ArrayList;

public abstract class TransportVehicle extends MotorVehicle implements RampControl, Load {

    private Ramp ramp;
    private Garage<Car> cars;

    /**
     * Constructor sets number of doors, engine power, colour and model name based on parameters
     * Also sets the direction to north and the location to 0,0
     * @param nrDoors number of doors
     * @param enginePower engine power
     * @param color color
     * @param modelName model name
     * @param weight weight of the vehicle
     * @param maxCap maximum amount of cars that can be loaded
     * @param maxWeight maximum weight of the loaded cars
     * @param firstLast decides order for loading off cars
     */
    public TransportVehicle(int nrDoors, double enginePower, Color color, String modelName, int weight,
                            int maxCap, int maxWeight, boolean firstLast){

        super(nrDoors, enginePower, color, modelName, weight);
        cars = new Garage<>(maxCap, maxWeight, firstLast);
        ramp = new Ramp();

    }

    /**
     * moves the transport vehicle if the ramp is up
     */
    @Override
    public void move() {

        if(!rampIsDown()) {
            super.move();
            cars.setLocation(getLocation());
        }
        else
            System.out.println("You can't move when the ramp is down!");

    }

    /**
     * moves the transport vehicle backwards if the ramp is up
     */
    @Override
    public void reverse() {

        if (!rampIsDown()) {
            super.reverse();
            cars.setLocation(getLocation());
        }
        else
            System.out.println("You can't move when the ramp is down!");
    }

    /**
     * turns Transportvehicle and all the cars loaded on it left
     */
    @Override
    public void turnLeft() {

        super.turnLeft();
        cars.turnLeft();
    }
    /**
     * turns Transportvehicle and all the cars loaded on it right
     */
    @Override
    public void turnRight() {

        super.turnRight();
        cars.turnRight();

    }

    /**
     * if allowed, loads off one car
     */
    public void loadOff() {
        if (rampIsDown())
            cars.loadOff();
        else
            System.out.println("The ramp has to be down to load off cars!");

    }

    /**
     * if possible, loads on param car
     * @param car
     */
    public void loadOn(Car car) {

        if (rampIsDown() && cars.canLoad(car, getLocation())) {

            while (!car.getDirection().equals(getDirection()))
                car.turnLeft();

            cars.loadOn(car, getLocation());

        }
        else
            System.out.println("There is a problem with the loading");
    }

    /**
     *
     * @return arrayList cars
     */
    public ArrayList<Car> carList(){
        return cars.carList();
    }

    public void lowerRamp() {
        ramp.lowerRamp();
    }

    /**
     * raises the ramp completely
     */
    public void raiseRamp() {
        ramp.raiseRamp();
    }

    /**
     * Checks if the ramp is down
     * @return if the ramp is down
     */
    public boolean rampIsDown(){
        return ramp.isDown();
    }

}
