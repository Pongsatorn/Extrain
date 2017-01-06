package oop.inherit;

public class SuperCar extends Car{
    @Override
    public void drive() {
        this.setSpeed(80);
    }

    public void nitrous(){
        this.setSpeed(200);
    }
}
