package Manager;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import registroalumnos.Student;

public class StudentsManager {

    public static File studentsRegister;
    public static ArrayList<Student> students = new ArrayList<>();

    public static void initFiles() {
        String projectRoute = System.getProperty("user.dir");
        String separator = File.separator;
        String folderRoute = projectRoute + separator + "files";

        File register = new File(folderRoute);
        if (!register.exists()) {
            register.mkdir();
        }

        studentsRegister = new File(folderRoute + separator + "studentsRegister.txt");
        if (!studentsRegister.exists()) {
            try {
                studentsRegister.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static ArrayList<String> readStudentsFile() throws IOException {
        ArrayList<String> datosAlumno = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(studentsRegister))) {
            String line;
            while ((line = br.readLine()) != null) {
                datosAlumno.add(line);
            }
        }
        return datosAlumno;
    }

    public static void writeFile(Student student) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(studentsRegister, true))) {
            bw.write(student.toString());
            bw.newLine();
        }
    }

    public static void loadStudents() throws IOException {
        students.clear();
        ArrayList<String> studentData = readStudentsFile();
        for (String data : studentData) {
            String[] parts = data.split(";");
            Student s = new Student(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], parts[4]);
            students.add(s);
        }
    }

    public static Student findStudentByDNI(String DNI) {
        for (Student s : students) {
            if (s.getDNI().equals(DNI)) {
                return s;
            }
        }
        return null;
    }

    public static void deleteStudentByDNI(String DNI) throws IOException {
        Student studentToRemove = findStudentByDNI(DNI);
        if (studentToRemove != null) {
            students.remove(studentToRemove);
            saveAllStudents();
        }
    }

    public static void saveAllStudents() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(studentsRegister))) {
            for (Student s : students) {
                bw.write(s.toString());
                bw.newLine();
            }
        }
    }
}
