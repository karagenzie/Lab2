public class Ramp {

    private int angle;

    public Ramp(){

        angle = 0;

    }

    public void raiseRamp(int angle){
        this.angle = Math.min(70, this.angle + angle);
    }

    public void lowerRamp(int angle){

        this.angle = Math.max(0, this.angle - angle);

    }

    public void raiseRamp(){

        this.angle = 70;

    }

    public void lowerRamp(){

        this.angle = 0;

    }

    public int getAngle(){

        return angle;

    }

    public boolean isDown(){

        return (angle == 0);

    }

}
