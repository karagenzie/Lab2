package Vehicles;

import java.awt.*;

public class Ferry extends TransportVehicle{

    /**
     * Constructs a ferry with a given
     * maximum amount of cars
     * and maximum weight of cars
     * @param maxCap maximum amount of cars
     * @param maxWeight maximum weight of cars
     */

    public Ferry(int maxCap, int maxWeight) {

        super(20, 200, Color.darkGray, "Stena Line",
                500000, maxCap, maxWeight, false);

    }

}
