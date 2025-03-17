package registroalumnos;

public class Student {

    private String name;
    private String surname;
    private int age;
    private String course;
    private String DNI;

    public Student(String name, String surname, int age, String course, String DNI) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.course = course;
        this.DNI = DNI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return name + ";" + surname + ";" + age + ";" + course + ";" + DNI;
    }
}
