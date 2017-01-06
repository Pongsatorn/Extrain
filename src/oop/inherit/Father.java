package oop.inherit;

public class Father {
    protected String name = "Name : Father";
    public Father(){

//        System.out.println("Hello Father");
    }
    public Father(String name){
//        this();
//        System.out.println("Name: "+name);
    }

    protected void run(int i){ //final
        System.out.println("Father Run!!");
    }
    protected final void walk(){
        System.out.println("Father walk");
    }

}
