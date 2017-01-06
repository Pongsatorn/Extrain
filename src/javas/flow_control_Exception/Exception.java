package javas.flow_control_Exception;


import org.apache.log4j.Logger;

public class Exception {
    static final Logger logger = Logger.getLogger(Exception.class);
    public static void main(String[] args) {
        try {
            int a = 50/0;
            System.out.println("Hello a");
        }catch (ArithmeticException e){
            System.out.println(e);
        }

        try {
            String s = null;
            System.out.println(s.length());
        }catch (NullPointerException e){
            System.out.println(e);
        }

        try {
            String s="abc";
            int i=Integer.parseInt(s);
        }catch (NumberFormatException e){
            System.out.println(e);
        }

        try {
            int b[]=new int[5];
            b[10]=50;
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }


        try{
            validate(13);
        }catch (ArithmeticException e){
            System.out.println(e);
        }


    }
    static void validate(int age) throws ArithmeticException{
        if(age<18)
            throw new ArithmeticException("not valid");
        else
            System.out.println("welcome");
    }
}
