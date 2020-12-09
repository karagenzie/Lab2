package CarPanel;

import javax.swing.*;

public class CarButtons extends JPanel {

    CarController cc;

    JButton addCarButton = new JButton("Add Random Car");
    JButton removeCarButton = new JButton("Remove Random Car");

    /**
     * Creates a panel with buttons for adding and removing random cars
     * @param cc the car controller
     */

    public CarButtons(CarController cc){

        this.cc = cc;
        initButtons();

    }

    private void initButtons() {

        this.add(addCarButton);
        this.add(removeCarButton);

        addCarButton.addActionListener(e -> cc.addCar());
        removeCarButton.addActionListener(e -> cc.removeCar());

    }
}