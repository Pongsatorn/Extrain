package javas.IO_Formatting_Parsing.IOStream;

import org.apache.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;

public class ByteWriteStream {
    final static Logger logger = Logger.getLogger(ByteWriteStream.class);
    public static void main(String[] args) throws IOException{
        FileOutputStream write = null;
        try {
            write = new FileOutputStream("output.txt");
            write.write('A');
            write.write('B');
            logger.debug("Successfully");
        }
        finally {
            if (write != null) {
                write.close();
            }
        }
    }
}
