package javas.IO_Formatting_Parsing.IOStream;

import org.apache.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;

public class CharStreamReader {
    final static Logger logger = Logger.getLogger(CharStreamReader.class);
    public static void main(String[] args) throws IOException {
        FileReader in= null;
        try {
            in = new FileReader("input.txt");
            int c;
            int count = 1;
            while ((c = in.read()) != -1) {
                logger.debug("Data Line "+count+" - " + (char)c);
                count++;
            }
            logger.debug("count = " + (count-1));
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
}
