import java.awt.*;

public abstract class Car implements Movable{

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    private int direction;  // 1 = North, 2 = East, 3 = South, 4 = West
    private double x; // x-position
    private double y; // y-position

    /**
     * Constructor sets number of doors, engine power, colour and model name based on parameters
     * Also sets the direction to north and the location to 0,0
     * @param nrDoors number of doors
     * @param enginePower engine power
     * @param color colour
     * @param modelName model name
     */

    public Car(int nrDoors, double enginePower,
               Color color, String modelName){

        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        direction = 1;
        x = 0;
        y = 0;
        stopEngine();

    }

    /**
     * Returns the number of doors
     * @return number of doors
     */

    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * Returns the engine power
     * @return the engine power
     */

    public double getEnginePower(){
        return enginePower;
    }

    /**
     * Returns the current speed
     * @return the current speed
     */

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Returns the colour of the car
     * @return the colour of the car
     */

    public Color getColor(){
        return color;
    }

    /**
     * Sets the colour of the car using the Color parameter clr
     * @param clr the desired colour for the car
     */

    public void setColor(Color clr){
        color = clr;
    }

    /**
     * Starts the engine
     * Current speed gets set to 0.1
     */

    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Stops the engine
     * Current speed gets set to 0
     */

    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Gas by a certain amount to increase the speed
     * @param amount how much you gas
     */

    public void gas(double amount){
        if (amount >= 0 && amount <= 1)
            incrementSpeed(amount);
        else
            throw new ArrayIndexOutOfBoundsException("Must be between 0 and 1!");
    }

    /**
     * Brake to decrease the speed
     * @param amount how much you brake
     */

    public void brake(double amount){
        if (amount >= 0 && amount <= 1)
            decrementSpeed(amount);
        else
            throw new ArrayIndexOutOfBoundsException("Must be between 0 and 1!");
    }

    /**
     * Increases the speed by a certain amount multiplied by the speed factor,
     * unless it exceeds the engine power
     * @param amount how much the speed will increase divided by the speed factor
     */

    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    /**
     * Decreases the speed by a certain amount multiplied by the speed factor,
     * unless it goes below 0
     * @param amount how much the speed will decrease divided by the speed factor
     */

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    /**
     * Returns the speed factor
     * Speed factor is defined differently in subclasses
     * so here it is abstract
     * @return the speed factor
     */

    protected abstract double speedFactor();

    /**
     * Moves the car forward in the direction it is facing
     */

    public void move(){
        if (direction == 1 || direction == 3)
            y += (2-direction) * getCurrentSpeed();
        else
            x += (3-direction) * getCurrentSpeed();
    }

    /**
     * Turns the car left
     */

    public void turnLeft(){
        if (1 < direction)
            direction += -1;
        else
            direction = 4;
    }

    /**
     * Turns the car right
     */

    public void turnRight(){
        if (direction < 4)
            direction += 1;
        else
            direction = 1;
    }

    /**
     * Returns what direction the car is facing in the form of a string
     * @return the direction
     */

    public String getDirection(){

        if (direction == 1)
            return "North";
        else if (direction == 2)
            return "East";
        else if (direction == 3)
            return "South";
        else
            return "West";

    }

    /**
     * Returns the position of the car in the form of a string
     * @return the position of the car
     */

    public String getPosition(){

        return ("Position: (" + x + "," + y + ")");

    }

}