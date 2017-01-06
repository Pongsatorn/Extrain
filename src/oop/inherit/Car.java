package oop.inherit;

public class Car {
    private int speed=0;
    private boolean isStarted=false;

    public void start(){
        this.isStarted=true;
    }
    public void drive(){
        this.speed = 40;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
}
