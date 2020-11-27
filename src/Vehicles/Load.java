package Vehicles;

import Vehicles.Car;

import java.util.ArrayList;

public interface Load<Model extends Car> {

    void loadOn(Model car);
    void loadOff();
    ArrayList<Model> carList();

}
