package CarPanel;

import javax.swing.*;

public class CarButtons extends JPanel {

    CarModel cModel;

    JButton addCarButton = new JButton("Add Random Car");
    JButton removeCarButton = new JButton("Remove Random Car");

    public CarButtons(CarModel cModel){

        this.cModel = cModel;
        initButtons();

    }

    private void initButtons() {

        this.add(addCarButton);
        this.add(removeCarButton);

        addCarButton.addActionListener(e -> cModel.addRandomCar());
        removeCarButton.addActionListener(e -> cModel.removeRandomCar());

    }
}