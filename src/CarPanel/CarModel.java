package CarPanel;

import Vehicles.MotorVehicle;
import Vehicles.Saab95;
import Vehicles.Scania;

import java.util.ArrayList;

public class CarModel {

    private ArrayList<MotorVehicle> cars;
    private ArrayList<CarObserver> observers;


    public CarModel() {
        cars = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public ArrayList<MotorVehicle> getCars() {
        return cars;
    }

    public void addObserver(CarObserver observer) {
        observers.add(observer);
    }

    public void addCar(MotorVehicle car){

        cars.add(car);

    }


    public void update() {

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

        if (carX > 600 || carX < 0 || carY > 500 || carY < 0)
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
}
