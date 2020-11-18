import org.junit.Test;

public class testDemo2 {


    @Test
    public void testChopShop(){

        Saab95 sab = new Saab95();
        Volvo240 vol = new Volvo240();
        ChopShop<Saab95> saabverkstad = new ChopShop<>(10);

        sab.setLocation(new Location(0,0));

        saabverkstad.loadOn(sab);

        System.out.println(saabverkstad.carList());

        saabverkstad.loadOn(vol);

        System.out.println(saabverkstad.carList());

        saabverkstad.loadOff();




    }
}
