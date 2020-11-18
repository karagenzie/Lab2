import java.awt.*;

public class Scania implements Engine, getAndSet, Movable, TruckBed{

    private Car car;
    private int bedAngle;


    public Scania(double enginePower){

        car = new Car(2, enginePower, Color.white, "Scania");
        bedAngle = 0;

    }

    public Scania(int nrDoors, double enginePower,
                  Color color, String modelName){

        car = new Car(2, enginePower, color, modelName);
        bedAngle = 0;

    }

    private boolean roadReady(){
        return (bedAngle == 0);
    }

    @Override
    public void startEngine() {
        if (roadReady())
            car.startEngine();
        else
            System.out.println("The bed can't be raised if you want to start the engine");
    }

    @Override
    public void stopEngine() {
        car.stopEngine();
    }

    @Override
    public void gas(double amount) {

        if (roadReady())
           car.gas(amount);
        else
            System.out.println("The bed can't be raised if you want to gas");
    }

    @Override
    public void brake(double amount) {
        car.brake(amount);
    }

    @Override
    public void reverse() {
        if (roadReady()) {
            car.reverse();
        } else {
            System.out.println("Truck can't move while bed is raised");
        }
    }
    @Override
    public void move() {
        if(roadReady()){
            car.move();}
        else{
            System.out.println("Truck can't move while bed is raised");
        }

    }

    @Override
    public void turnLeft(){
        car.turnLeft();
    }

    @Override
    public void turnRight() {
        car.turnRight();
    }

    @Override
    public String getDirection() {
        return car.getDirection();
    }

    @Override
    public Location getLocation() {
        return car.getLocation();
    }

    @Override
    public int getNrDoors() {
        return getNrDoors();
    }

    @Override
    public double getEnginePower() {
        return getEnginePower();
    }

    @Override
    public double getCurrentSpeed() {
        return getCurrentSpeed();
    }

    @Override
    public Color getColor() {
        return getColor();
    }

    @Override
    public void setColor(Color clr) {
        car.setColor(clr);
    }

    @Override
    public void raiseBed(int angle) {

        if (roadReady())
        bedAngle = Math.min(bedAngle + angle, 70);

        else
            System.out.println("You can't raise the bed when the truck is moving.");
    }

    @Override
    public void lowerBed(int angle) {
        bedAngle = Math.max(bedAngle - angle, 0);
    }

    @Override
    public int getBedAngle() {
        return bedAngle;
    }
}
