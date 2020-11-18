public class Location {

    private double x;
    private double y;

    public Location(double x, double y){

        this.x = x;
        this.y = x;

    }

    public double getX(){

        return x;

    }

    public double getY(){

        return y;

    }

    public void setX(double value){

        x = value;

    }

    public void setY(double value){

        y = value;

    }

    public void addY(double value){

        y += value;

    }

    public void addX(double value){

        x += value;

    }




}
