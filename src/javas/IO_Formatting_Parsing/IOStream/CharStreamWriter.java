package javas.IO_Formatting_Parsing.IOStream;

import org.apache.log4j.Logger;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamWriter {
    final static Logger logger = Logger.getLogger(CharStreamWriter.class);
    public static void main(String[] args) throws IOException{
        FileWriter out = null;
        try {
            out = new FileWriter("charOutput.txt");
            out.write('A');
            out.write('B');
            logger.debug("Successfully");

        } finally {

            if (out != null) {
                out.close();
            }
        }
    }
}
