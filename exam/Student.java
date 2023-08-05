package exam;
import javax.naming.Name;
import java.io.*;
public class Student implements Serializable{
    private String enrolID;
    private String firstName;
    private String lastName;
    private int age;

    public Student(String enrolID, String firstName, String lastName, int age) {
        this.enrolID = enrolID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getEnrolID() {
        return enrolID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setEnrolID(String enrolID) {
        this.enrolID = enrolID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "\n"+ enrolID +"           " + firstName+lastName + "           " + age;
    }
}



