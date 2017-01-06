package javas.IO_Formatting_Parsing;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeDemo {
    public static void main(String[] args) throws IOException {
        Student stu = new Student();
        stu.setFirstname("Pongsatorn");
        stu.setLastname("Saeueng");
        stu.setAge(21);

        FileOutputStream fileOutputStream = new FileOutputStream("serialize");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(stu);
        System.out.println("Serialize Bravo!!");
        if (objectOutputStream != null)
            objectOutputStream.close();
        if (fileOutputStream != null)
            fileOutputStream.close();
    }
}
