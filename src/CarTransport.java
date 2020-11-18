import java.awt.*;
import java.util.ArrayList;

public class CarTransport implements Engine, getAndSet, Movable, Ramp {

    private static double close = 1;

    private Scania truck;
    private ArrayList<Car> cars;
    private int maxCap = 5;

    public CarTransport(double enginePower, int maxCap) {

        truck = new Scania(2, enginePower, Color.BLACK, "Car Transport");

        cars = new ArrayList<Car>();
        this.maxCap = maxCap;

    }


    public int getNrDoors() {
        return truck.getNrDoors();
    }


    public double getEnginePower() {
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

    public String getModelName(){

        return truck.getModelName();

    }

    public void startEngine() {
        truck.startEngine();

    }

    public void stopEngine() {
        truck.stopEngine();
    }

    public void reverse() {
        truck.reverse();

        for (Car i : cars)
            i.setLocation(getLocation());
    }

    public void move() {
        truck.move();

        for (Car i : cars)
            i.setLocation(getLocation());
    }

    public void turnLeft() {
        truck.turnLeft();

        for (Car i : cars)
            i.turnLeft();
    }

    public void turnRight() {
        truck.turnRight();

        for (Car i : cars)
            i.turnRight();

    }

    public String getDirection() {
        return truck.getDirection();
    }

    public Location getLocation() {
        return truck.getLocation();
    }

    public void gas(double amount) {

        truck.gas(amount);

    }

    public void brake(double amount) {

        truck.brake(amount);

    }

    public void raiseRamp() {

        truck.raiseBed(70);

    }

    public void lowerRamp() {

        truck.lowerBed(70);

    }

    private boolean rampIsDown() {
        return (truck.getBedAngle() == 0);
    }

    private boolean canLoad(Car car) {
        if (cars.size() < maxCap) {
            if (rampIsDown())
                if ((Math.abs(getLocation().getX() - car.getLocation().getX()) < close
                        && Math.abs(getLocation().getY() - car.getLocation().getY()) < close))
                    return true;
        }
        return false;
    }

    public void loadOff() {
        if (rampIsDown()) {

            Car car = cars.get(cars.size() - 1);
            car.reverse();
            cars.remove(cars.size() - 1);


        }
    }

    public void loadOn(Car car) {

        if (canLoad(car)) {

            cars.add(car);

            while (!car.getDirection().equals(getDirection()))
                car.turnLeft();

            car.setLocation(getLocation());
            car.stopEngine();
        }
        else
            System.out.println("There is a problem with the loading");

    }

    public Car lastCar(){

        return cars.get(cars.size()-1);

    }

}


