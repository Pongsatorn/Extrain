package javas.IO_Formatting_Parsing.IOStream;

import org.apache.log4j.Logger;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Macbook-Macbook on 27/12/2559.
 */
public class CharStreamReadandWrite {
    final static Logger logger = Logger.getLogger(CharStreamReadandWrite.class);
    public static void main(String[] args) throws IOException{
        FileReader in= null;
        FileWriter out = null;
        try {
            in = new FileReader("input.txt");
            out = new FileWriter("charOutput.txt");
            int c;
            int count = 1;
            while ((c = in.read()) != -1) {
                logger.debug("Data "+count +": "+ (char)c);
                out.write(c);
                count++;
            }
            logger.debug("Successfuly");
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
