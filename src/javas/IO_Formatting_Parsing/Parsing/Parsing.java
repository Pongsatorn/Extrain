package javas.IO_Formatting_Parsing.Parsing;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Parsing {
    public static void main(String[] args) {
        String time = "Jul 24 2012 05:19:34";
        String dateInString = "7-Jun-2013";
        String datewww = "7-ธ.ค.-2559";

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        try {

            Date date = formatter.parse(datewww);
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
