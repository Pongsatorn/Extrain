package javas.IO_Formatting_Parsing.IOStream;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteReadStream {
    final static Logger logger = Logger.getLogger(ByteReadStream.class);
    public static void main(String[] args)throws IOException {
        FileInputStream in = null;
        try {
            in = new FileInputStream("input.txt");
            int c;
            int count = 1 ;
            while ((c = in.read()) != -1) {
                logger.debug("Data "+count +": "+ (char)c);
                count++;
            }
            logger.debug("Count = " + (count-1));
        }
        finally {
            if (in != null) {
                in.close();
            }
        }
    }
}
