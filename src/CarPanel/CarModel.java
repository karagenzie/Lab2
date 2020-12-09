package CarPanel;

import Vehicles.MotorVehicle;
import Vehicles.Saab95;
import Vehicles.Scania;

import java.util.ArrayList;

public class CarModel {

    private static final int WIDTH = 700;
    private static final int HEIGHT = 500;

    private ArrayList<MotorVehicle> cars;
    private ArrayList<CarObserver> observers;

    public CarModel() {
        cars = new ArrayList<>();
        observers = new ArrayList<>();
    }

    /**
     *
     * @return arraylist of motorvehicles
     */
    public ArrayList<MotorVehicle> getCars() {
        return cars;
    }

    protected void addObserver(CarObserver observer) {
        observers.add(observer);
    }

    /**
     * adds a car
     * @param car chosen car to add
     */

    public void addCar(MotorVehicle car){

        cars.add(car);

    }


    protected void update() {

        for (MotorVehicle car : cars) {
            getInside(car);
            car.move();
        }

        for (CarObserver observer : observers) {
            observer.carsMoved();
        }


    }

    private void getInside(MotorVehicle car){
        if (!isInside(car)) {

            car.turnLeft();
            car.turnLeft();

            while (!isInside(car)) {
                car.move();
            }

        }
    }

    private boolean isInside(MotorVehicle car){

        double carX = car.getLocation().getX();
        double carY = car.getLocation().getY();

        if (carX > WIDTH || carX < 0 || carY > HEIGHT || carY < 0)
            return false;
        else
            return true;
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (MotorVehicle car : cars
        ) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (MotorVehicle car : cars
        ) {
            car.brake(brake);
        }
    }

    void turboOff(){
        for (MotorVehicle saab : cars)
            if (saab.getClass() == Saab95.class)
                ((Saab95) saab).setTurboOff();
    }

    void turboOn(){
        for (MotorVehicle saab : cars)
            if (saab.getClass() == Saab95.class)
                ((Saab95) saab).setTurboOn();
    }

    void liftBed(){
        for (MotorVehicle scan : cars)
            if (scan.getClass() == Scania.class)
                ((Scania) scan).raiseBed(70);
    }
    void lowerBed(){
        for (MotorVehicle scan : cars)
            if (scan.getClass() == Scania.class)
                ((Scania) scan).lowerBed(70);
    }

    void start(){
        for (MotorVehicle car : cars)
            car.startEngine();
    }

    void stop(){
        for (MotorVehicle car : cars)
            car.stopEngine();
    }

    void addRandomCar(){

        if (cars.size() < 10)
            cars.add(CarFactory.createRandomCar(WIDTH, HEIGHT));

    }

    void removeRandomCar(){

        int carIndex = (int) Math.random() * cars.size();
        cars.remove(carIndex);

    }

}
