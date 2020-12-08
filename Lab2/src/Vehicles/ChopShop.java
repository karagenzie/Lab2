package Vehicles;

import java.util.ArrayList;

public class ChopShop<Model extends Car> implements Load<Model> {

    private Garage<Model> garage;
    private Location position;

    /**
     * Constructs a chop shop with a given maximum amount of cars
     * @param maxCap maximum amount of cars
     */

    public ChopShop(int maxCap){

        garage = new Garage<>(maxCap, 0, true);
        position = new Location(0,0);

    }

    /**
     * Loads on a car if there is space and it is close by
     * @param car
     */

    public void loadOn(Model car){


        if (garage.canLoad(car, getLocation()))
            garage.loadOn(car, getLocation());

    }

    /**
     * Loads off a car
     */

    public void loadOff(){

        garage.loadOff();


    }

    /**
     * Returns the cars in the chop shop
     * @return the list of cars
     */

    public ArrayList<Model> carList(){

        return garage.carList();

    }

    /**
     * Returns the location of the chop shop
     * @return the location of the chop shop
     */

    public Location getLocation(){

        return position;

    }

    /**
     * Lets the user set a location for the chop shop
     * @param l the given location
     */

    public void setLocation(Location l){

        position = l;
        garage.setLocation(l);

    }

    /**
     * Lets the user set the location for the chop shop
     * @param x the x-value
     * @param y the y-value
     */

    public void setLocation(double x, double y){

        position.setLocation(x, y);
        garage.setLocation(x, y);

    }

}
