package registroalumnos;

import Manager.StudentsManager;
import java.io.IOException;
import java.util.Scanner;

public class StudentRegister {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentsManager.initFiles();

        int option;
        try {
            do {
                System.out.println("------------------------------");
                System.out.println("MENU");
                System.out.println("------------------------------");
                System.out.println("1. Add new student");
                System.out.println("2. Show all students registered");
                System.out.println("3. Delete student from register");
                System.out.println("4. Search student by DNI");
                System.out.println("5. Sign out");
                System.out.print("Choose an option: ");
                option = sc.nextInt();
                sc.nextLine(); // Consume the newline character

                switch (option) {
                    case 1:
                        System.out.println("Student's name: ");
                        String name = sc.nextLine();
                        System.out.println("Student's surname: ");
                        String surname = sc.nextLine();
                        System.out.println("Student's age: ");
                        int age = sc.nextInt();
                        sc.nextLine(); // Consume the newline character
                        System.out.println("Student's course: ");
                        String course = sc.nextLine();
                        System.out.println("Student's DNI: ");
                        String DNI = sc.nextLine();

                        Student newStudent = new Student(name, surname, age, course, DNI);
                        StudentsManager.writeFile(newStudent);
                        break;
                    case 2:
                        StudentsManager.loadStudents();
                        for (Student s : StudentsManager.students) {
                            System.out.println(s);
                        }
                        break;
                    case 3:
                        System.out.println("Enter the DNI of the student to delete: ");
                        String deleteDNI = sc.nextLine();
                        StudentsManager.deleteStudentByDNI(deleteDNI);
                        break;
                    case 4:
                        System.out.println("Enter the DNI of the student to search: ");
                        String searchDNI = sc.nextLine();
                        Student foundStudent = StudentsManager.findStudentByDNI(searchDNI);
                        if (foundStudent != null) {
                            System.out.println(foundStudent);
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;
                    case 5:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("This option doesn't exist.");
                }
            } while (option != 5);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
