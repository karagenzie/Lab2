import java.util.ArrayList;

public class ChopShop<Vehicle extends Car> {

    private CarTransport garage;

    public ChopShop(int maxCap){

        garage = new CarTransport(0, maxCap);

    }

    public void loadOn(Vehicle car){

        garage.loadOn(car);

    }

    public void loadOff(){

        garage.loadOff();

        System.out.println(garage.lastCar().getModelName());

    }

}
