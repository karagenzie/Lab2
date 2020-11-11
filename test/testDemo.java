import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testDemo{

    Saab95 s = new Saab95();
    Volvo240 v = new Volvo240();

    /**
     * Tests if the doors are of the right amount
     */

    @Test
    public void testDoors(){

        assertEquals(s.getNrDoors() + 2, v.getNrDoors());

    }

    /**
     * Tests if the turn methods work
     * Does this via testing a direction method
     */

    @Test
    public void testDirection(){

        s.turnLeft();
        s.turnLeft();
        s.turnRight();

        assertEquals(s.getDirection(), "West");

    }

    /**
     * Tests if the Movable methods work
     * Does this via testing a position method
     */

    @Test
    public void testMovable(){

        v.gas(0.5);
        v.move();
        v.turnRight();
        v.move();
        v.turnLeft();
        v.move();

        System.out.println(v.getPosition());

        assertEquals(v.getPosition(), "Position: (0.625,1.25)");

    }

    /**
     * Tests if the brake method works
     */

    @Test
    public void testBrake(){

        s.startEngine();
        s.setTurboOn();

       // for(int a = 1; a < 60; a++) {
            s.gas(0.8);
        //}

        double a = s.getCurrentSpeed();

        s.brake(1);

        double b = s.getCurrentSpeed();

        assertTrue(b < a);

    }


    /**
     * Tests if the car's speed can exceed the engine power
     */

    @Test
    public void testMaxSpeed() {
        s.stopEngine();

        for(int a = 1; a < 150; a++) {
            s.gas(1);
        }

        assertEquals(s.getCurrentSpeed(), s.getEnginePower(), 0);

    }
    @Test
    public void testTurboOff(){
        s.setTurboOn();
        System.out.println(s.speedFactor());
        s.setTurboOff();
        System.out.println(s.speedFactor());
        assertEquals(s.speedFactor(), 1.25, 0.01);
    }


}
