package javas.IO_Formatting_Parsing;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerailizeDemo {
    public static void main(String[] args) throws IOException,ClassNotFoundException{
        Student stu = null;
        Student student = null;
        FileInputStream fileInputStream = new FileInputStream("serialize");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        stu = (Student) objectInputStream.readObject();

        if (stu != null){
            System.out.println(stu.getFirstname());
            System.out.println(stu.getLastname());
            System.out.println(stu.getAge());
            System.out.println(stu);
        }

        if (objectInputStream != null)
            objectInputStream.close();

        if (fileInputStream != null)
            fileInputStream.close();

    }
}
