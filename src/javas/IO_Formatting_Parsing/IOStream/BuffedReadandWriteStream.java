package javas.IO_Formatting_Parsing.IOStream;

import org.apache.log4j.Logger;
import java.io.*;

public class BuffedReadandWriteStream {
    final static Logger logger = Logger.getLogger(BuffedWriterStream.class);
    public static void main(String[] args) throws IOException {
        FileWriter writer = null;
        BufferedWriter buffwrite = null;

        FileReader reader = null;
        BufferedReader buffreader = null;
        try {
            String str = "Hello";
            int c ;
            String data;
            writer = new FileWriter("buffOutput.txt");
            reader = new FileReader("input.txt");
            buffreader = new BufferedReader(reader);
            buffwrite = new BufferedWriter(writer);
            while ((data = buffreader.readLine()) != null){
                buffwrite.write(data);
                buffwrite.append("-");
            }

            logger.debug("Successfuly");
        } finally {
            if (buffreader != null)
                buffreader.close();
            if (reader != null)
                reader.close();
            if (buffwrite != null)
                buffwrite.close();
            if (writer != null)
                writer.close();
        }
    }
}
