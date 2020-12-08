package CarPanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import Vehicles.MotorVehicle;

/**
 * This class is a JPanel that tracks the locations of the cars
 * and sets images to the corresponding locations
 */

public class DrawPanel extends JPanel{


    private Map<String, BufferedImage> carImages = new HashMap<>();
    private CarController cc = new CarController();

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarController cc) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.cc = cc;


        // Print an error message in case file is not found with a try/catch block
        for (MotorVehicle car : cc.getCars()) {
            String name = car.getModelName();

            try {
                carImages.put(name, ImageIO.read(new File("src/pics/" + name + ".jpg")));

                //volvoImage = ImageIO.read(CarPanel.DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        for (MotorVehicle car: cc.getCars()) {
            g.drawImage(carImages.get(car.getModelName()), (int) car.getLocation().getX(), (int) car.getLocation().getY(), null);

            //System.out.println(car.getModelName());
        }

    }
}
