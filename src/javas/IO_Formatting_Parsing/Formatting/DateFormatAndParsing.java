package javas.IO_Formatting_Parsing.Formatting;


import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatAndParsing {
    final static Logger logger = Logger.getLogger(DateFormatAndParsing.class);
    public static void main(String[] args) {
        /*
        Letter	Description	        Examples
        y	    Year	            2013
        M	    Month in year	    July, 07, 7
        d	    Day in month	    1-31
        E	    Day name in week	Friday, Sunday
        a	    Am/pm marker	    AM, PM
        H	    Hour in day	        0-23
        h	    Hour in am/pm	    1-12
        m	    Minute in hour	    0-60
        s	    Second in minute	0-60

        * */

        /*   String -> Date
                SimpleDateFormat.parse(String);

             Date -> String
                SimpleDateFormat.format(date);
        * */

        demo1();
//        demo2();
//        demo3();
//        demo4();
//        demo5();

    }

    /*  String = 4-ม.ค.-2560
    * */
    public static void demo1() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String dateInString = "4-ม.ค.-2560";

        try {
            Date date = formatter.parse(dateInString);
            logger.debug(date);
            logger.debug(formatter.format(date));

        } catch (ParseException e) {
            logger.error(e);
        }
    }

    /*  String = 04/01/2560
    * */
    public static void demo2(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateInString = "04/01/2560";

        try {
            Date date = formatter.parse(dateInString);
            logger.debug(date);
            logger.debug(formatter.format(date));

        } catch (ParseException e) {
            logger.error(e);
        }
    }

    /*  String = พ. , ม.ค. 4 2560
    * */
    public static void demo3(){
        SimpleDateFormat formatter = new SimpleDateFormat("E, MMM dd yyyy");
        String dateInString = "พ., ม.ค. 4 2560";

        try {

            Date date = formatter.parse(dateInString);
            logger.debug(date);
            logger.debug(formatter.format(date));

        } catch (ParseException e) {
            logger.error(e);
        }

    }

    /*  String = วันพุธ, ม.ค. 4, 2560 12:10:56 หลังเที่ยง
    * */
    public static void demo4(){
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");
        String dateInStringEn = "Friday, Jun 7, 2013 12:10:56 PM";
        String dateInString   = "วันพุธ, ม.ค. 4, 2560 12:10:56 หลังเที่ยง";

        try {

            Date date = formatter.parse(dateInString);
            logger.debug(date);
            logger.debug(formatter.format(date));

        } catch (ParseException e) {
            logger.error(e);
        }
    }

    /*  String = 4-มกราคม-2560
    * */
    public static void demo5() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
        String dateInString = "4-มกราคม-2560";

        try {
            Date date = formatter.parse(dateInString);
            logger.debug(date);
            logger.debug(formatter.format(date));

        } catch (ParseException e) {
            logger.error(e);
        }
    }


}
