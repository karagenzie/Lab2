import java.util.ArrayList;

public class ChopShop<Vehicle extends Car> {

    private CarTransport trans;

    public ChopShop(int maxCap){

        trans = new CarTransport(0, maxCap);

    }

    public void loadOn(Vehicle car){

        trans.loadOn(car);

    }

    public void loadOff(){

        trans.loadOff();

    }

}
