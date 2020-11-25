import java.awt.*;

public abstract class MotorVehicle implements Movable, getAndSet, Engine{

    private int nrDoors;
    private double enginePower;
    private double currentSpeed;
    private Color color;
    private String modelName;
    private int weight;

    private int direction;  // 1 = North, 2 = East, 3 = South, 4 = West
    private Location position;

    /**
     * Constructor sets number of doors, engine power, colour and model name based on parameters
     * Also sets the direction to north and the location to 0,0
     * @param nrDoors number of doors
     * @param enginePower engine power
     * @param color colour
     * @param modelName model name
     */

    public MotorVehicle(int nrDoors, double enginePower,
               Color color, String modelName, int weight){

        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.weight = weight;
        direction = 1;
        position = new Location(0,0);
        startEngine();

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
     * Returns the colour of the motorvehicle
     * @return the colour of the motorvehicle
     */

    public Color getColor(){
        return color;
    }

    /**
     * Sets the colour of the motorvehicle using the Color parameter clr
     * @param clr the desired colour for the motorvehicle
     */

    public void setColor(Color clr){
        color = clr;
    }

    /**
     * returns the name of the model
     * @return modelName
     */
    public String getModelName(){

        return modelName;

    }

    /**
     * returns the weight of the vehicle
     * @return weight
     */
    public int getWeight(){

        return weight;

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
     * returns how fast the speed is increasing
     * @returns speedFactor
     */
    public double speedFactor(){

        return getEnginePower() * 0.01;

    }

    /**
     * Gas by a certain amount to increase the speed
     * @param amount how much you gas
     */

    public void gas(double amount){
        if (amount >= 0 && amount <= 1)
            incrementSpeed(amount);
        else
            System.out.println("Must be between 0 and 1!");
    }

    /**
     * Brake to decrease the speed
     * @param amount how much you brake
     */

    public void brake(double amount){
        if (amount >= 0 && amount <= 1)
            decrementSpeed(amount);
        else
            System.out.println("Must be between 0 and 1!");
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
     * Reverses the motorvehicle, moving it in the reverse  direction
     * it is facing
     */

    public void reverse(){
        if (direction == 1 || direction == 3)
            position.addY((2-direction) * getCurrentSpeed());
        else
            position.addX(-1*(3-direction) * getCurrentSpeed());
    }
    /**
     * Moves the motorvehicle forward in the direction it is facing
     */
    public void move(){
        if (direction == 1 || direction == 3)
            position.addY(-1*(2-direction) * getCurrentSpeed());
        else
            position.addX((3-direction) * getCurrentSpeed());
    }


    /**
     * Turns the motor vehicle left
     */

    public void turnLeft(){
        if (1 < direction)
            direction += -1;
        else
            direction = 4;
    }

    /**
     * Turns the motor vehicle right
     */

    public void turnRight(){
        if (direction < 4)
            direction += 1;
        else
            direction = 1;
    }

    /**
     * Returns what direction the motor vehicle is facing in the form of a string
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
     * Returns the position of the motor vehicle in the form of a string
     * @return position
     */

    public Location getLocation(){

        return position;

    }

    /**
     * Sets location of the vehicle in a coordinate system
     * @param position a (x,y) location on a grid
     */
    public void setLocation(Location position){

        this.position = position;

    }

    /**
     * Sets location of the vehicle in a coordinate system
     * @param x position of the car on the x-axis
     * @param y position of the car on the y-axis
     */
    public void setLocation(double x, double y){

        position.setLocation(x, y);

    }

}