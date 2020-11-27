package Vehicles;

import java.awt.*;

public class Car extends MotorVehicle{

    /**
     * Constructs a car with a given number of doors,
     * engine power, colour, model name and weight
     * @param nrDoors
     * @param enginePower
     * @param color
     * @param modelName
     * @param weight
     */

    public Car(int nrDoors, double enginePower,
               Color color, String modelName, int weight){

        super(nrDoors, enginePower, color, modelName, weight);

    }

}