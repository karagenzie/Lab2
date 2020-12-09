package CarPanel;

import Vehicles.MotorVehicle;
import Vehicles.Saab95;
import Vehicles.Volvo240;
import Vehicles.Scania;

public class CarFactory {

    /**
     * Creates a volvo at a given location
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @return the created volvo
     */

    public static Volvo240 createVolvo(double x, double y){

        Volvo240 volvo = new Volvo240();
        volvo.setLocation(x, y);
        randomTurn(volvo);
        return volvo;

    }

    /**
     * Creates a saab at a given location
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @return the created saab
     */

    public static Saab95 createSaab(double x, double y){

        Saab95 saab = new Saab95();
        saab.setLocation(x, y);
        randomTurn(saab);
        return saab;

    }

    /**
     * Creates a Scania object at a given location
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @return the created Scania
     */
    public static Scania createScania(double x, double y){

        Scania scan = new Scania();
        scan.setLocation(x, y);
        randomTurn(scan);
        return scan;

    }

    /**
     * Creates a random vehicle with a random location within certain limits
     * @param xLimit the maximum x-value
     * @param yLimit the maximum y-value
     * @return the created vehicle
     */

    public static MotorVehicle createRandomCar(int xLimit, int yLimit){

        int random = (int) (Math.random() * 3);
        double randomX = Math.random() * xLimit;
        double randomY = Math.random() * yLimit;

        MotorVehicle car;

        if (random == 0) {
            car = createVolvo(randomX, randomY);
        }
        else if (random == 1){
            car = createSaab(randomX,randomY);
        }
        else
            car = createScania(randomX, randomY);

        randomTurn(car);

        return car;

    }

    private static void randomTurn(MotorVehicle car){

        int turns = (int) (Math.random() * 4);

        for (int i = 0; i < turns; i++)
            car.turnLeft();

    }
}
