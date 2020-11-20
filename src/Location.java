public class Location {

    private double x;
    private double y;

    /**
     * Constructs a location
     * @param x position on x-axis
     * @param y positon on y-axis
     */
    public Location(double x, double y){

        this.x = x;
        this.y = y;

    }

    /**
     * Returns the x-value of a location
     * @return position on x-axis of a Location
     */

    public double getX(){

        return x;

    }

    /**
     * Returns the y-value of a location
     * @return position on y-axis of a Location
     */

    public double getY(){

        return y;

    }

    /**
     * Sets position on the x-axis
     * @param value point on the x-axis
     */

    public void setX(double value){

        x = value;

    }
    /**
     * Sets position on the y-axis
     * @param value point on the y-axis
     */

    public void setY(double value){

        y = value;

    }

    /**
     * Changes position on the y-axis
     * @param value number which is added to y
     */

    public void addY(double value){

        y += value;

    }

    /**
     * Changes positon on the x-axis
     * @param value number which is added to x
     */
    public void addX(double value){

        x += value;

    }

    /**
     * Lets the user change the x and y-values
     * @param x the desired x-value
     * @param y the desired y-value
     */

    public void setLocation(double x, double y){

        this.x = x;
        this.y = y;

    }
}
