package javas.IO_Formatting_Parsing.IOStream;

import org.apache.log4j.Logger;

import java.io.*;

public class BuffedReaderStream {
    private final static Logger logger = Logger.getLogger(BuffedReaderStream.class);;
    public static void main(String[] args) throws IOException {
        FileReader in= null;
        BufferedReader buffIn = null;
        try {
            in = new FileReader("input.txt");
            buffIn = new BufferedReader(in);
            int count = 1;
            String data;
            while ((data = buffIn.readLine()) != null) {
               logger.debug("Data Line "+count+" - " + data);
               count++;
            }
        } finally {
            if (buffIn != null){
                buffIn.close();
            }
            if (in != null) {
                in.close();
            }

        }
    }
}
