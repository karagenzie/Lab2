import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testDemo3 {
    Volvo240 a1 = new Volvo240();

    /**
     * Test if the enginePower is the correct amount
     */
    @Test
    public void testEnginePower(){
        assertEquals(a1.getEnginePower(), 100.0, 0.1);
    }

    /**
     * Test if the currentSpeed is the correct one given in the constructor
     */
    @Test
    public void testCurrentSpeed(){
        assertEquals(a1.getCurrentSpeed(), 0, 0.01);
    }

    /**
     * Tests if the getColor and setColor methods work
     * does this via setting the color to a different color and then checking if it worked with getColor
     */
    @Test
    public void testColor(){

        a1.setColor(Color.red);
        assertTrue(a1.getColor() == Color.red);
    }

    /**
     * Tests if the method for starting the engine works
     * does this via using the method getCurrentSpeed to
     * see if the speed equals what it should when the engine starts
     */
    @Test
    public void testStartEngine(){
        a1.startEngine();
        System.out.print(a1.getCurrentSpeed());
        assertTrue(a1.getCurrentSpeed() == 0.1);
    }

    /**
     * Tests if the method for stopping the engine works
     * does this by starting the engine, checking the speed and then
     * stopping the engine to see if the speed is reduced to 0
     */
    @Test
    public void testStopEngine(){
        a1.startEngine();
        System.out.println(a1.getCurrentSpeed());
        a1.stopEngine();
        System.out.println(a1.getCurrentSpeed());
        assertTrue(a1.getCurrentSpeed() == 0);
    }

    /**
     * Tests if the speedFactor method works correctly
     * does this by seeing if it equals the equation that it should
     */
    @Test
    public void testSpeedFactor(){
        System.out.print(a1.speedFactor());
        assertEquals(a1.speedFactor(), (100*0.01*1.25), 0.01);

    }

}
