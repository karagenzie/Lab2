import Vehicles.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class testDemo3 {

    @Test
    public void testScaniaAngle(){

        Scania scan = new Scania();

        scan.stopEngine();

        scan.raiseBed(80);

        assertEquals(scan.getBedAngle(), 70);

    }

    @Test
    public void testScaniaMovement(){

        Scania scan = new Scania();

        scan.stopEngine();

        scan.raiseBed(90);
        scan.lowerBed(100);

        scan.startEngine();
        scan.gas(1);
        scan.gas(1);
        scan.gas(1);

        double speed = scan.getCurrentSpeed();

        scan.move();
        scan.turnRight();
        scan.move();
        scan.turnLeft();
        scan.reverse();

        assertEquals(scan.getLocation().getX(), speed, 0.05);


    }

    @Test
    public void testFerry(){

        Ferry ferry = new Ferry(12, 15000);
        Volvo240 vov = new Volvo240();
        Saab95 saab = new Saab95();

        vov.setLocation(1,3);
        saab.setLocation(0,5);

        Garage.setClose(6);

        ferry.loadOn(vov);
        ferry.loadOn(saab);

        ferry.loadOff();

        assertEquals(ferry.carList().get(0), saab);


    }

    @Test
    public void testFerryMovement(){

        Ferry ferry = new Ferry(12, 15000);
        Volvo240 vov = new Volvo240();

        ferry.loadOn(vov);

        ferry.raiseRamp();

        ferry.move();
        ferry.turnRight();
        ferry.move();
        ferry.turnLeft();
        ferry.reverse();

        assertEquals(ferry.getLocation(), ferry.carList().get(0).getLocation());

    }




}
