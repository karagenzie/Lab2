import Vehicles.ChopShop;
import Vehicles.Location;
import Vehicles.Saab95;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class testDemo {

    ChopShop<Saab95> sv = new ChopShop<>(12);
    Saab95 sab = new Saab95();

    @Test
    public void testLoadOn(){
        sv.loadOn(sab);
        assertEquals(sv.carList().get(0) , sab);
    }


    @Test
    public void testLoadOff(){
        sv.loadOn(sab);
        sv.loadOff();
        assertEquals(sv.carList().size(), 0);
    }
    @Test
    public void testGetLocationX(){
        assertEquals(sv.getLocation().getX() , 0, 0.01);
    }
    @Test
    public void testGetLocationY(){
        assertEquals(sv.getLocation().getY() , 0, 0.01);
    }
    @Test
    public void testSetLocationX(){
        sv.setLocation(1,0);
        assertEquals(sv.getLocation().getX() , 1, 0.01);
    }
    @Test
    public void testSetLocationY(){
        sv.setLocation(0,1);
        assertEquals(sv.getLocation().getY() , 1, 0.01);
    }
    @Test
    public void SetLocationWithLocation(){
        Location loc = new Location(1,0);
        sv.setLocation(loc);
        assertEquals(sv.getLocation().getX() , 1, 0.01);
    }


}
