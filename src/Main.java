import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main() {
        Student Lev = new Student(18, "Lev", 1);

        Lev.display_person_info();
        Lev.display_student_info();
        Lev.sayHi("German");

        Lesson lesson_1 = new Lesson(1F, "Natalya Mihaylovna", "Sanya", "Alina" , "Masha", "Lev");
        lesson_1.displayLessonDetails();

        Lesson lesson_2 = new Lesson(1.5F, "Pavel Sergeevich", "Sveta", "German" , "Misha");
        lesson_2.displayLessonDetails();
    }
}

class Person {
    int age;
    String name;

    public String getName() {return name;}
    public int getAge() {return age;}

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void display_person_info() {
        System.out.println("Age: " + age);
        System.out.println("Name: " + name);
    }
}

class Student extends Person {
    int form;

    public Student(int age, String name, int form) {
        super(age, name);
        this.form = form;
    }

    public void sayHi(String say_to_name) {
        System.out.printf("Student %s says 'Hi' to student %s.\n", getName(), say_to_name);
    }

    public void display_student_info() {
        System.out.printf("%s is %s years old. He is %s course.\n", getName(), getAge(), form);
    }

}

class Lesson {
    String teacher;
    float duration;
    ArrayList<String> students;

    public Lesson(float duration, String teacher, String ...cameStudents) {
        students = new ArrayList<>();
        this.teacher = teacher;
        this.duration = duration;

        students.addAll(Arrays.asList(cameStudents));
    }

    public void displayLessonDetails() {
        System.out.println();
        System.out.println("Teacher: " + teacher);
        System.out.println("duration: " + duration);
        System.out.print("Students at lesson: ");
        for (String student: students) {
            System.out.print(student + ", ");
        }
        System.out.println();
    }
}
