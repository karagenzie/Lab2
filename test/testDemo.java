import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class testDemo{

    @Test
    public void testDoors(){

        Car v = new Saab95();

        assertEquals(v.getNrDoors(), 2);

    }

    @Test
    public void testDirection(){

        Saab95 b = new Saab95();

        

    }


}
