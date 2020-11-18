import java.util.ArrayList;

public class ChopShop<Vehicle extends Car> implements Load<Vehicle> {

    private CarTransport garage;

    public ChopShop(int maxCap){

        garage = new CarTransport(0, maxCap);

    }

    public void loadOn(Vehicle car){

        garage.loadOn(car);

    }

    public void loadOff(){

        Car lastCar = carList().get(carList().size()-1);

        System.out.println(lastCar.getModelName());

        garage.loadOff();

    }

    public ArrayList<Car> carList(){

        return garage.carList();

    }
}
