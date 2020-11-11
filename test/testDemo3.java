import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testDemo3 {
    Volvo240 a1 = new Volvo240();

    @Test
    public void testDoors() {
        assertEquals(a1.getNrDoors(), 4);
    }
    @Test
    public void testEnginePower(){
        assertEquals(a1.getEnginePower(), 100.0, 0.1);
    }
    @Test
    public void testCurrentSpeed(){
        assertEquals(a1.getCurrentSpeed(), 0, 0.01);
    }
    @Test
    public void testColor(){

        a1.setColor(Color.red);
        assertTrue(a1.getColor() == Color.red);
    }
    @Test
    public void testStartEngine(){
        a1.startEngine();
        System.out.print(a1.getCurrentSpeed());
        assertTrue(a1.getCurrentSpeed() == 0.1);
    }
    @Test
    public void testStopEngine(){
        a1.startEngine();
        System.out.println(a1.getCurrentSpeed());
        a1.stopEngine();
        System.out.println(a1.getCurrentSpeed());
        assertTrue(a1.getCurrentSpeed() == 0);
    }
    @Test
    public void testSpeedFactor(){
        System.out.print(a1.speedFactor());
        assertEquals(a1.speedFactor(), (100*0.01*1.25), 0.01);

    }

}
