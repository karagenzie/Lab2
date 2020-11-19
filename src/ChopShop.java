import java.util.ArrayList;

public class ChopShop<Model extends Car> implements Load<Model> {

    private CarTransport garage;

    public ChopShop(int maxCap){

        garage = new CarTransport(0, maxCap, maxCap*100000);

    }

    public void loadOn(Model car){

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
