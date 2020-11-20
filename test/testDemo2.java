
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testDemo2 {

    CarTransport lastbilen = new CarTransport(4, 5000);
    @Test
    public void testRamp(){
    lastbilen.raiseRamp();
    assertTrue(!lastbilen.rampIsDown());
    }

    @Test
    public void testCarTransportMovement(){
        lastbilen.raiseRamp();
        lastbilen.lowerRamp();
        lastbilen.startEngine();
        lastbilen.move();
        lastbilen.move();

        assertEquals(lastbilen.getLocation().getY(), 0, 0.01);

    }
    @Test
    public void testCarsOnCarTransportMovement(){
        Car saaben = new Saab95();
        lastbilen.loadOn(saaben);
        lastbilen.raiseRamp();
        lastbilen.startEngine();
        lastbilen.move();
        lastbilen.move();
        System.out.println(lastbilen.getLocation());
        assertEquals(lastbilen.getLocation(), lastbilen.carList().get(0).getLocation());
    }
    @Test
    public void testLoadingCarFarAway(){
        Car volvon = new Volvo240();
        volvon.startEngine();
        volvon.gas(1);
        volvon.gas(1);
        volvon.move();
        volvon.move();
        lastbilen.loadOn(volvon);
        assertEquals(lastbilen.carList().size(), 0);

    }

}
