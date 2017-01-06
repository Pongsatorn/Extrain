package javas.IO_Formatting_Parsing.IOStream;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteReadandWriteStream {
    final static Logger logger = Logger.getLogger(ByteReadandWriteStream.class);
    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("input.txt");
            out = new FileOutputStream("output.txt");
            int c;
            int count = 1 ;
            byte[] bytes = new byte[1024];
            while ((c = in.read()) != -1) {
                logger.debug("Data "+count +" - "+ (char)c);
                out.write(c);
//                out.write(bytes,0,c);
                count++;
            }
            logger.debug("Count = " + (count-1));
        }
        finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
