package CarPanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import Vehicles.MotorVehicle;
import Vehicles.Volvo240;
import Vehicles.Saab95;
import Vehicles.Scania;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    //BufferedImage volvoImage;
    // To keep track of a single car's position
    //Point volvoPoint = new Point();

    private Map<String, BufferedImage> carImages = new HashMap<>();
    //private ArrayList<MotorVehicle> cars = new ArrayList<>();
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

                //volvoImage = ImageIO.read(CarPanel.DrawPanel.class.getResourceAsStream("pics/Vehicles.Volvo240.jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        for (MotorVehicle car: cc.getCars()) {
            g.drawImage(carImages.get(car.getModelName()), (int) car.getLocation().getX(), (int) car.getLocation().getY(), null);

            //System.out.println(car.getModelName());
        }

        // see javadoc for more info on the parameters
    }
}
