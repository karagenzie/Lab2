import java.awt.*;

public abstract class Car implements Movable{

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    private int direction;  // 1 = North, 2 = East, 3 = South, 4 = West
    private int x; // x-position
    private int y; // y-position

    /**
     * Empty constructor because it is an abstract class
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
     * @param clr
     */

    public void setColor(Color clr){
        color = clr;
    }

    /**
     * Starts the engine
     */

    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Stops the engine
     */

    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Increases the speed by a certain amount that is between 0 and 1
     * @param amount
     */

    public void gas(double amount){
        if (amount >= 0 && amount <= 1)
            incrementSpeed(amount);
        else
            throw new ArrayIndexOutOfBoundsException("Must be between 0 and 1!");
    }

    /**
     * Decreases the speed by a certain amount that is between 0 and 1
     * @param amount
     */

    public void brake(double amount){
        if (amount >= 0 && amount <= 1)
            decrementSpeed(amount);
        else
            throw new ArrayIndexOutOfBoundsException("Must be between 0 and 1!");
    }

    /**
     * Increases the speed by a certain amount multiplied by a speedfactor,
     * unless it exceeds the engine power
     * @param amount
     */

    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    /**
     * Decreases the speed by a certain amount multiplied by the speed factor,
     * unless it goes below 0
     * @param amount
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
        if (1 < direction && direction < 5)
            direction += -1;
        else
            direction = 4;
    }

    /**
     * Turns the car right
     */

    public void turnRight(){
        if (0 < direction && direction < 4)
            direction += 1;
        else
            direction = 1;
    }

}


// private och public (protected), svårt när private inte ärvs och då blir getters inte så relevanta
// om statiska typen måste kunna vara car (angående turbometoden)