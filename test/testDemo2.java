import org.junit.Test;

public class testDemo2 {


    @Test
    public void testChopShop(){

        Saab95 sab = new Saab95();
        Volvo240 vol = new Volvo240();
        ChopShop<Car> saabverkstad = new ChopShop<>(10);

        sab.setLocation(new Location(0,0.5));

        saabverkstad.loadOn(sab);
        //saabverkstad.loadOn(vol);
        saabverkstad.loadOff();

    }
}
