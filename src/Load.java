public interface Load<Vehicle extends Car> {

    void loadOn(Vehicle car);
    void loadOff();

}
