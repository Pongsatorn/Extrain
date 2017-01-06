package oop.inherit;

public class Son extends Father{
    public Son(){
//        super("keng");
//        System.out.println("Hello Son");
//        name = "Son";

    }

    @Override
    protected void run(int i){
        System.out.println("Son Run!");
    }

}
