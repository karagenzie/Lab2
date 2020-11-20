public class Ramp {

    private int angle;
    private int maxAngle;

    /**
     * Constructs a ramp with an angle of 0 degrees
     * and a maximum angle of 70 degrees
     */

    public Ramp(){

        angle = 0;
        maxAngle = 70;

    }

    /**
     * Constructor with a maximum angle as parameter
     * @param maxAngle the maximum angle
     */

    public Ramp(int maxAngle){

        angle = 0;
        this.maxAngle = maxAngle;

    }

    /**
     * raises the ramp by a given angle
     * cannot exceed the maximum angle
     * @param angle
     */

    public void raiseRamp(int angle){
        this.angle = Math.min(maxAngle, this.angle + angle);
    }

    /**
     * Lowers the ramp by a given angle
     * cannot go lower than 0 degrees
     * @param angle
     */

    public void lowerRamp(int angle){

        this.angle = Math.max(0, this.angle - angle);

    }

    /**
     * raises the ramp completely
     */

    public void raiseRamp(){

        this.angle = maxAngle;

    }

    /**
     * lowers the ramp completely
     */

    public void lowerRamp(){

        this.angle = 0;

    }

    /**
     * returns what angle the ramp is on
     * @return the angle of the ramp
     */

    public int getAngle(){

        return angle;

    }

    /**
     * says if the ramp is lowered
     * @return if the ramp is lowered
     */

    public boolean isDown(){

        return (angle == 0);

    }

}
