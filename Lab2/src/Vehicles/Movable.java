package Vehicles;

import Vehicles.Location;

interface Movable {

    void reverse();
    void move();
    void turnLeft();
    void turnRight();

    String getDirection();
    Location getLocation();


}
