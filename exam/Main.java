package exam;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    private static final String FILE_NAME = "students.dat";
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        loadStudents();

        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    saveStudents();
                    break;
                case 3:
                    displayStudents();
                    break;
                case 4:
                    System.out.println("Exiting the application.");
                    saveStudents();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add new student");
        System.out.println("2. Save");
        System.out.println("3. Display all students");
        System.out.println("4. Exit");
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter EnrolID: ");
        String enrolID = scanner.nextLine();

        System.out.print("Enter FirstName: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter LastName: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        Student student = new Student(enrolID, firstName, lastName, age);
        students.add(student);
    }

    private static void saveStudents() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            outputStream.writeObject(students);
            System.out.println("Students saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadStudents() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
                students = (List<Student>) inputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("\n---- Student Records ----");
            System.out.println("EnrolID " + "        Name "  + "          Age "        + "\n" + "_________________________________" );
            for (Student student : students) {
                System.out.println(student);
            }
            System.out.println("\n"+"----------------------------------");
        }
    }

}
