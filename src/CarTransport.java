import java.awt.*;
import java.util.ArrayList;

public class CarTransport extends MotorVehicle implements Engine, getAndSet, Movable, Load {

    private static double close = 1;
    private ArrayList<Car> cars;
    private int maxCap;
    private int maxWeight;
    private Ramp ramp;

    public CarTransport(double enginePower, int maxCap, int maxWeight) {

        super(2, enginePower, Color.BLACK, "Car Transport", 20000);

        cars = new ArrayList<>();
        this.maxCap = maxCap;
        this.maxWeight = maxWeight;

    }

    private boolean roadReady(){return !ramp.isDown();}

    public void startEngine() {
        if (roadReady())
            super.startEngine();
        else
            System.out.println("The bed can't be raised if you want to start the engine");
    }

    public void reverse() {

       if (roadReady()) {
           super.reverse();
           for (Car i : cars)
               i.setLocation(getLocation());
       }
    }

    public void move() {
        if(roadReady()) {
            super.move();
            for (Car i : cars)
            i.setLocation(getLocation());
        }
    }

    public void turnLeft() {
        super.turnLeft();

        for (Car i : cars)
            i.turnLeft();
    }

    public void turnRight() {
        super.turnRight();

        for (Car i : cars)
            i.turnRight();

    }

    public void gas(double amount) {

        if (roadReady())
            super.gas(amount);
        else
            System.out.println("You can't gas if the ramp is raised!");
    }


    private int carsWeight(){

        int weight = 0;

        for (Car i : cars){
            weight += i.getWeight();
        }

        return weight;

    }

    private boolean canLoad(Car car) {
        if (cars.size() < maxCap && carsWeight() + car.getWeight() < maxWeight) {
            if (!roadReady())
                if (Math.sqrt(Math.pow(getLocation().getX() - car.getLocation().getX(),2)
                        + Math.pow(getLocation().getY() - car.getLocation().getY(), 2)) < close)
                    return true;
        }
        return false;
    }

    public void loadOff() {
        if (!roadReady()) {

            Car car = cars.get(cars.size() - 1);
            car.startEngine();
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

    public ArrayList<Car> carList(){

        return cars;

    }

}


