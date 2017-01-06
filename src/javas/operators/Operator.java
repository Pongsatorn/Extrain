package javas.operators;


public class Operator {
    public static void main(String[] args) {
//        printRelationalOperators();

        //Increment and Decrement Operators
        int a = 0, b = 0, c = 0, d = 0;
        System.out.println("++a = "+ ++a);    // a = a + 1;
        System.out.println("a++ = "+ a++);    // a
                                              // a = a + 1;
        System.out.println("a = "+ a);
        System.out.println("a+=10 = "+ (a+=10));// a = a + 10;

        System.out.println("--b = "+ --b);    // b = b - 1;
        System.out.println("b-- = "+ b--);    // b
                                              // b = b - 1;
        System.out.println("b = " + b);
        System.out.println("b-=10 = "+ (b-=10));// b = b - 10;

        System.out.println("c*=10 = " + (c*=10));// c = c * 10;
        System.out.println("d/=10 = " + (d/=10));// d = d / 10;


    }

    public static void printRelationalOperators(){
        int i = 37;
        int j = 42;
        int k = 42;
        System.out.println("Variable values...");
        System.out.println("    i = " +i);
        System.out.println("    j = " +j);
        System.out.println("    k = " +k);
        //greater than
        System.out.println("Greater than...");
        System.out.println("    i > j = "+(i>j));//false
        System.out.println("    j > i = "+(j>i));//true
        System.out.println("    k > j = "+(k>j));//false

        //greater than or equal to
        System.out.println("Greater than or equal to...");
        System.out.println("    i >= j = "+(i>=j));//false
        System.out.println("    j >= i = "+(j>=i));//true
        System.out.println("    k >= j = "+(k>=j));//true
        //less than
        System.out.println("Less than...");
        System.out.println("    i < j = "+(i<j));//true
        System.out.println("    j < i = "+(j<i));//false
        System.out.println("    k < j = "+(k<j));//false
        //less than or equal to
        System.out.println("Less than or equal to...");
        System.out.println("    i <= j = "+(i<=j));//true
        System.out.println("    j <= i = "+(j<=i));//false
        System.out.println("    k <= j = "+(k<=j));//true

        //equal to
        System.out.println("Equal to...");
        System.out.println("    i == j = " + (i==j));//false
        System.out.println("    k == j = " + (k==j));//true
        //not equal to
        System.out.println("Not equal to...");
        System.out.println("    i != j = " + (i!=j));//true
        System.out.println("    k != j = " + (k!=j));//false
    }
}
