package registroalumnos;

import static Manager.StudentsManager.readStudentsFile;
import static Manager.StudentsManager.initiFiles;
import static Manager.StudentsManager.writeFile;
import static Manager.StudentsManager.findStudentByDNI;
import static Manager.StudentsManager.students;

import java.io.IOException;
import java.util.Scanner;

public class StudentRegister {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        initiFiles();

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
                System.out.print("Chose an option: ");
                option = sc.nextInt();

                switch (option) {
                    case 1:
                        //Add new student
/*NO DEJA CREAR UN NUEVO ALUMNO, EN EL MOMENTO EN QUE ESTE FUNCIONE YA SE PODRAN COMPROVAR LOS SIGUIENTES.*/
                        writeFile();
                        break;
                    case 2:
                        //Show all students registered
                        System.out.println(readStudentsFile());
                        break;
                    case 3:
                        //Delete student from register
                        break;
                    case 4:
                        //Search student by DNI
                        try {
                            System.out.print("Introduce el DNI del estudiante: ");
                            String DNI = sc.nextLine();
                            Student s = findStudentByDNI(DNI);
                            if (s != null) {
                                System.out.println("El DNI que has introducido no pertenece a ningún estudiante del sistema.");
                            } else {
                                System.out.print("Nuevo nombre: ");
                                s.setName(sc.nextLine());
                                students.remove(s);
                            }

                        } catch (Exception e) {
                            System.err.println("Error en la lectura del fichero.");
                        }
                    case 5:
                        //
                        System.out.println("Good Bye!");
                        break;
                    default:
                        System.out.println("this option doesn't exists");
                }

            } while (option != 5);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

}
