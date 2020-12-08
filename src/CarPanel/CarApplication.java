package CarPanel;

public class CarApplication {

    private static CarModel initCars(){

        CarModel model = new CarModel();

        model.addCar(CarFactory.createSaab(100, 100));
        model.addCar(CarFactory.createVolvo(200, 200));
        model.addCar(CarFactory.createScania(300, 300));

        return model;

    }

    public static void main(String[] args) {

        CarModel cModel = initCars();
        CarController cc = new CarController(cModel);
        CarView view = new CarView("CarSim 1.1", cModel, cc);
        cModel.addObserver(view);

        SpeedView sv = new SpeedView(cModel);
        view.add(sv);
        cModel.addObserver(sv);

        cc.startTime();

    }


}
