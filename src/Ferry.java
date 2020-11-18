import java.util.ArrayList;

public class Ferry {

    private CarTransport ferry;
    private ArrayList<Car> cars;

    public Ferry(int maxCap){

        ferry = new CarTransport(100, maxCap);

    }

    public void loadOn(Car car){

        ferry.loadOn(car);

        for(Car i : ferry.carList())
            for(int a = ferry.carList().size() - 1; a >= 0 ; a = a-1)
                cars.add(i);


    }
    public void move(){

    }
    public void reverse(){

    }

    public void loadOff(){
        ferry.carList().remove(0);
        //ferry.loadOff();

    }

}
