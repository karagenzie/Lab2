package CarPanel;

import Vehicles.Saab95;
import Vehicles.Volvo240;
import Vehicles.Scania;

public class CarFactory {

    public static Volvo240 createVolvo(double x, double y){

        Volvo240 volvo = new Volvo240();
        volvo.setLocation(x, y);
        return volvo;

    }

    public static Saab95 createSaab(double x, double y){

        Saab95 saab = new Saab95();
        saab.setLocation(x, y);
        return saab;

    }

    public static Scania createScania(double x, double y){

        Scania scan = new Scania();
        scan.setLocation(x, y);
        return scan;

    }



}
