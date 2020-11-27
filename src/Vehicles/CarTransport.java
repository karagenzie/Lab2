package Vehicles;

import java.awt.*;

public class CarTransport extends TransportVehicle{

    /**
     * Constructs a car transport with a given
     * maximum capacity of cars
     * and maximum weight of cars
     * @param maxCap maximum amount of cars
     * @param maxWeight maximum weight of cars
     */

    public CarTransport(int maxCap, int maxWeight) {

        super(2, 800, Color.BLACK, "Vehicles.Car Transport",
                20000, maxCap, maxWeight, true);

    }

}


