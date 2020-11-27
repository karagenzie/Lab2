package Vehicles;

import java.util.ArrayList;

public class Garage<model extends Car>{

    private static double close = 1;
    private ArrayList<model> cars;
    private int maxCap;
    private int maxWeight;
    private boolean firstLast;

    /**
     * Constructs a garage with a given maximum amount of cars,
     * a maximum weight of the cars, and a given order of loading off
     * @param maxCap maximum amount of cars
     * @param maxWeight maximum weight of cars
     * @param firstLast the order of loading off cars
     */

    public Garage(int maxCap, int maxWeight, boolean firstLast){

        this.maxCap = maxCap;
        this.maxWeight = maxWeight;
        this.firstLast = firstLast;
        cars = new ArrayList<>();

    }

    /**
     * Lets the user decide what distance a car can be from a garage
     * before being loaded on
     * @param distance the acceptable distance
     */

    public static void setClose(double distance){

        close = distance;

    }

    /**
     * Applies a location to the cars in the garage
     * @param l the desired location
     */

    public void setLocation(Location l){

        for (model i : cars)
            i.setLocation(l);

    }

    /**
     * Applies a location to all cars
     * @param x the desired x-coordinate
     * @param y the desired y-coordinate
     */

    public void setLocation(double x, double y){

        for (model i : cars)
            i.setLocation(x, y);

    }

    /**
     * Lets the user turn all the cars in the garage left
     */

    public void turnLeft(){

        for (model i : cars)
            i.turnLeft();

    }

    /**
     * Lets the user turn all the cars in the garage right
     */

    public void turnRight(){

        for (model i : cars)
            i.turnRight();

    }


    private boolean carFits(model car){
        if (cars.size() < maxCap) {
            if (maxWeight > 0) {
                int weight = 0;
                for (model i : cars) {
                    weight += i.getWeight();
                }
                return (car.getWeight() + weight < maxWeight);
            }
            else if (maxWeight == 0) {return true;}
        }
        return false;
    }

    private boolean carIsClose(model car, Location l){

        return (Math.sqrt(Math.pow(l.getX() - car.getLocation().getX(),2)
                + Math.pow(l.getY() - car.getLocation().getY(), 2)) < close);

    }

    /**
     * Checks if a car can be loaded to a garage based on where it is,
     * how heavy it is and how many cars the garage already has
     * @param car the car that is being loaded on
     * @param l the location of the place with the garage
     * @return if the car can be loaded
     */

    public boolean canLoad(model car, Location l){
        return (carIsClose(car, l) && carFits(car));
    }


    /**
     * Loads on a car and gives it the location of the place where the garage is
     * @param car the car that is being loaded on
     * @param l the location of the place with the garage
     */

    public void loadOn(model car, Location l) {

        cars.add(car);
        car.setLocation(l);
        car.stopEngine();

    }


    /**
     * Loads off a car based on the order specified in the constructor
     * The car also drives away a bit
     */

    public void loadOff(){

        int c;
        model car;

        if (carList().size() == 0){

            System.out.println("There are no cars");

        }

        else if (firstLast) {
            c = cars.size() - 1;
            car = cars.get(c);
            cars.remove(c);
            car.startEngine();
            car.reverse();

        }
        else {
            c = 0;
            car = cars.get(c);
            cars.remove(c);
            car.startEngine();
            car.move();
        }
    }

    /**
     * Returns the list of cars in the garage
     * @return the list of cars
     */

    public ArrayList<model> carList() {
        return cars;
    }


}
