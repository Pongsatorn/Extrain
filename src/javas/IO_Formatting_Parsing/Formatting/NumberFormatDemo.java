package javas.IO_Formatting_Parsing.Formatting;

import java.text.DecimalFormat;

public class NumberFormatDemo {
    public static void main(String[] args) {

        decimalFormat();

    }
    public static void decimalFormat(){
        String pattern = "#,###.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
//        decimalFormat.applyPattern("00.000000");
        String format = decimalFormat.format(12);
        System.out.println(format);
    }

//    public static void stringFormat(){
//        String name = "Keng";
//        String sf1  = String.format("name is %s",name);
//        String sf2  = String.format("value is %f",32.33434);
//
//        System.out.println(sf1);
//        System.out.println(sf2);
//
//    }
}
