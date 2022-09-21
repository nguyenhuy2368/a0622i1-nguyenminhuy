package ss6_ke_thua.bt.MovablePoint;

public class MovablePoint extends Point {
    public float xSpeed;
    public float ySpeed;

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint() {
        this.xSpeed = 0.0f;
        this.ySpeed = 0.0f;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float [] arr = {this.xSpeed,this.ySpeed};
        return arr;
    }

    @Override
    public String toString() {
        return "(x: "+x+", y: "+y+"), speed ="+"(xSpeed: "+xSpeed+", ySpeed: "+ySpeed+")";
    }

//    @Override
//    public String toString() {
//        return "MovablePoint{" +
//                "xSpeed=" + xSpeed +
//                ", ySpeed=" + ySpeed +
//                ", x=" + x +
//                ", y=" + y +
//                '}';
//    }
}
