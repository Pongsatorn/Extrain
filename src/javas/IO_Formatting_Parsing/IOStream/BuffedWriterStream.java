package javas.IO_Formatting_Parsing.IOStream;

import org.apache.log4j.Logger;

import java.io.*;

public class BuffedWriterStream {
    final static Logger logger = Logger.getLogger(BuffedWriterStream.class);
    public static void main(String[] args) throws IOException {
        logger.info("Hello Buff write");
        FileWriter writer = null;
        BufferedWriter buffwrite = null;

        try {
            String str = "Hello";
            writer = new FileWriter("buffOutput.txt");
            buffwrite = new BufferedWriter(writer);
            buffwrite.write(str);


            logger.debug("Successfuly");
        } finally {
            if (buffwrite != null)
                buffwrite.close();
            if (writer != null)
                writer.close();
        }
    }
}
