package CarPanel;

import Vehicles.MotorVehicle;

import javax.swing.*;
import java.awt.*;

public class SpeedView extends JPanel implements CarObserver{

    private CarModel cModel;
    JLabel speedLabel;


    public SpeedView(CarModel cModel){

        this.cModel = cModel;

        setLayout(new BorderLayout());
        speedLabel = new JLabel();

        this.add(speedLabel, SwingConstants.CENTER);
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(800/5,200));
        update();

    }

    private String getCarSpeeds(){
        String carSpeeds = "<html> Speeds:" ;
        for (MotorVehicle car : cModel.getCars()){
            carSpeeds = carSpeeds + "<br/>" + car.getModelName() + ": " +String.format("%.2f", car.getCurrentSpeed());
        }

        carSpeeds = carSpeeds + "<html>";

        return carSpeeds;
    }

    private void update(){
            speedLabel.setText(getCarSpeeds());
    }

    public void carsMoved(){
        update();
    }



}
