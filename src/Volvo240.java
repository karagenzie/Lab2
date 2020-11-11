import java.awt.*;

public class Volvo240 extends Car implements Movable{

    private final static double trimFactor = 1.25;

    /**
     * Constructor for the car, setting
     * number of doors, colour, engine power and model name,
     * as well as setting the current speed to zero.
     */

    public Volvo240(){

        super(4, 100, Color.black, "Volvo240");

    }

    /**
     * Returns the speed factor
     * Overrides the super class's abstract speed factor class
     * It is now equal to the engine power multiplied by the trim factor,
     * multiplied by 0.01.
     * @return the speed factor
     */

    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }


}
