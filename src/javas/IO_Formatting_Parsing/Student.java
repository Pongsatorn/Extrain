package javas.IO_Formatting_Parsing;

import java.io.Serializable;
public class Student implements Serializable {
    private String firstname;
    private String lastname;
    private int age;
    Student(){

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "FirstName : " + this.firstname +
               " LastName : " + this.lastname  +
               " Age : " + this.age;
    }
}
