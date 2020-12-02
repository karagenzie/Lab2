package CarPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Vehicles.MotorVehicle;
import Vehicles.Volvo240;
import Vehicles.Saab95;
import Vehicles.Scania;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    private CarView frame;
    // A list of cars, modify if needed
    private ArrayList<MotorVehicle> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        Volvo240 vov = new Volvo240();
        vov.setLocation(400,400);

        Saab95 saab = new Saab95();
        saab.setLocation(200, 200);

        Scania scan = new Scania();
        scan.setLocation(100, 100);

        cc.cars.add(vov);
        cc.cars.add(saab);
        cc.cars.add(scan);
        cc.cars.add(new Scania());


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);


        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (MotorVehicle car : cars) {

                if (!isInside(car)){
                    car.reverse();
                    car.turnLeft();
                    car.turnLeft();
                }

                car.move();
                int x = (int) Math.round(car.getLocation().getX());
                int y = (int) Math.round(car.getLocation().getY());

                //System.out.println("x: " + x + " y: " + y);

                //frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    public ArrayList<MotorVehicle> getCars(){

        return cars;

    }

    private boolean isInside(MotorVehicle car){

        double carX = car.getLocation().getX();
        double carY = car.getLocation().getY();

        if (carX > 600 || carX < 0 || carY > 500 || carY < 0)
            return false;
        else
            return true;
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (MotorVehicle car : cars
                ) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (MotorVehicle car : cars
        ) {
            car.brake(brake);
        }
    }

     void turboOff(){
        for (MotorVehicle saab : cars)
            if (saab.getClass() == Saab95.class)
                ((Saab95) saab).setTurboOff();
     }

    void turboOn(){
        for (MotorVehicle saab : cars)
            if (saab.getClass() == Saab95.class)
                ((Saab95) saab).setTurboOn();
    }

    void liftBed(){
        for (MotorVehicle scan : cars)
            if (scan.getClass() == Scania.class)
                ((Scania) scan).raiseBed(70);
    }
    void lowerBed(){
        for (MotorVehicle scan : cars)
            if (scan.getClass() == Scania.class)
                ((Scania) scan).lowerBed(70);
    }

    void start(){
        for (MotorVehicle car : cars)
            car.startEngine();
    }

    void stop(){
        for (MotorVehicle car : cars)
            car.stopEngine();
    }

}
