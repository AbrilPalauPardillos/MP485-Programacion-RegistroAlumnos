/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import registroalumnos.Student;

/**
 *
 * @author usuario
 */
public class StudentsManager {

    public static File file;
    public static String studentsRegister;
    public static ArrayList<Student> students = new ArrayList<Student>();

    public static void initiFiles() {

        Scanner sc = new Scanner(System.in);

        // create new folder if not exists
        String projectRoute = System.getProperty("user.dir");
        String separator = File.separator;

        String folderRoute = projectRoute + separator + "files";

        // create new folder if not exists => register
        File register = new File(folderRoute);
        if (!register.exists()) {
            register.mkdir();
        } else {
            System.out.println("This folder exist.");
        }

        // create new file => registerStudents
        File studentsRegister = new File(folderRoute + separator + "studentsRegister.txt");

        if (!studentsRegister.exists()) {
            try {
                studentsRegister.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Lectura de la informacion
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static ArrayList<String> readStudentsFile() throws FileNotFoundException, IOException {

        ArrayList<String> datosAlumno = new ArrayList<>();
        FileReader fr = new FileReader(studentsRegister);
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();

        while (line != null) {
            datosAlumno.add(line);
            line = br.readLine();
        }

        br.close();
        return datosAlumno;
    }

    /**
     * escritura de fichero
     *
     * @return
     * @throws IOException
     */
    public static void writeFile() throws IOException {
        Scanner sc = new Scanner(System.in);

        FileWriter fw = new FileWriter(studentsRegister);
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            //name
            System.out.println("Student's name: ");
            String name = sc.nextLine();
            //surname
            System.out.println("Student's surname: ");
            String surname = sc.nextLine();
            //age
            System.out.println("Student's age: ");
            int age = sc.nextInt();
            //course
            System.out.println("Student's course: ");
            String course = sc.nextLine();
            //DNI
            System.out.println("Student's DNI: ");
            String DNI = sc.nextLine();
            
            //ADD NEW STUDENT INTO ARRAYLIST
            Student newStudent = new Student(name, surname, age, course, DNI);
            students.add(newStudent);
            
            //ADD NEW STUDENT INTO FILE
            String studentData = (name + " " + surname + " " + age + " " + course + " " + DNI);
            for (int i = 0; i < students.size(); i++) {
                studentData += students.get(i).toString() + System.getProperty("line.separator");
            }

            bw.write(studentData);
            bw.flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

    /**
     *
     * @throws IOException
     */
    public static void getStudent() throws IOException {
        ArrayList<String> studentData = readStudentsFile();
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < studentData.size(); i++) {

            String[] part = studentData.get(i).split(";");

            Student s = new Student(part[0], part[1], Integer.parseInt(part[2]), part[3], part[4]);

            students.add(s);
        }
    }

    /**
     *
     * @param DNI
     * @return
     */
    public static Student findStudentByDNI(String DNI) {
        Student student = null;
        for (Student s : students) {
            if (s.getDNI().equals(DNI)) {
                student = s;
            } else {
            }
        }
        return null;
    }
}
