package CarPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 * */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());

    private CarModel cModel;

    public CarController(CarModel cModel){

        this.cModel = cModel;

    }


    /** Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    **/

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cModel.update();
        }
    }

    public void startTime(){
        timer.start();
    }

    void gas(int amount) {
        cModel.gas(amount);
    }

    void brake(int amount) {
        cModel.brake(amount);
    }

     void turboOff(){
        cModel.turboOff();
     }

    void turboOn(){
        cModel.turboOn();
    }

    void liftBed(){
        cModel.liftBed();
    }
    void lowerBed(){
        cModel.lowerBed();
    }

    void start(){
        cModel.start();
    }

    void stop(){
        cModel.stop();
    }
   /* void addCar(){
        cModel.addCar(new Saab95() sab);
    }*/
}
