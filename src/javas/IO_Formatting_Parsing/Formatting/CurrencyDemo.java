package javas.IO_Formatting_Parsing.Formatting;

import org.apache.log4j.Logger;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class CurrencyDemo {
    final static Logger logger = Logger.getLogger(CurrencyDemo.class);
    public static void main(String[] args) {
    displayCurrency(Locale.CANADA);
    displayCurrency(Locale.CHINA);
    displayCurrency(Locale.CANADA_FRENCH);
    displayCurrency(Locale.FRANCE);
    displayCurrency(Locale.GERMANY);
    displayCurrency(new Locale("th","TH"));

    }


    static public void displayCurrency( Locale currentLocale) {

        double currencyAmount = 9876543.21;
        Currency currentCurrency = Currency.getInstance(currentLocale);
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(currentLocale);
        logger.debug(currentLocale.getDisplayName() + ", " +
                     currentCurrency.getDisplayName() + ": " +
                     currencyFormatter.format(currencyAmount));
    }
}
