package CarPanel;

import Vehicles.MotorVehicle;
import javax.swing.*;
import java.awt.*;

public class SpeedView extends JPanel implements CarObserver{

    private CarModel cModel;
    JLabel speedLabel;

    /**
     * Makes a list of the cars and their respective speeds
     * @param cModel the car model that has the cars
     */

    public SpeedView(CarModel cModel){

        this.cModel = cModel;
        speedLabel = new JLabel();

        this.setLayout(new BorderLayout());
        this.add(speedLabel, SwingConstants.CENTER);
        this.setBackground(Color.CYAN);
        this.setPreferredSize(new Dimension(800/5,200));

        update();

    }

    private String getCarSpeedString(){

        String carSpeeds = "<html> Speeds:" ;

        for (MotorVehicle car : cModel.getCars()){
            carSpeeds = carSpeeds + "<br/>" + car.getModelName() + ": " +String.format("%.2f", car.getCurrentSpeed());
        }

        carSpeeds = carSpeeds + "<html>";

        return carSpeeds;
    }

    private void update(){
            speedLabel.setText(getCarSpeedString());
    }

    public void carsMoved(){
        update();
    }

}
