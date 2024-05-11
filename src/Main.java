import java.util.ArrayList;
import java.util.Arrays;

public class Main {



    public static void main() {
        Student Lev = new Student(18, "Lev", 1, 5);
        Student German = new Student(24, "German", 3, 5);
        Student Sveta = new Student(19, "Sveta", 5, 3);

        Lesson lesson_1 = new Lesson("Programming", 1F, "Natalya Mihaylovna", Lev, German);
        Lesson lesson_2 = new Lesson("History", 1.5F, "Pavel Sergeevich", Sveta);

        Lev.set_like(lesson_1.lesson_name);
        Lev.like();
        Lev.set_like(German.name);
        Lev.like();
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

class Student extends Person implements Likable {
    int form;
    int max_possible_mark;
    ArrayList likable_objects = new ArrayList();
    ArrayList marks = new ArrayList();

    public Student(int age, String name, int form, int max_possible_mark) {
        super(age, name);
        this.form = form;
        this.max_possible_mark = max_possible_mark;
    }


    public void sayHi(String say_to_name) {
        System.out.printf("Student %s says 'Hi' to student %s.\n", getName(), say_to_name);
    }


    public void display_student_info() {
        System.out.printf("%s is %s years old. He is %s course.\n", getName(), getAge(), form);
        System.out.println("Max possible student mark: " + max_possible_mark);
        System.out.print("User marks: ");
        for (Object mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
        System.out.println();
    }

    public void set_like(Object object) {
        likable_objects.add(object);
    }

     public void like() {
        System.out.printf("User %s likes ", getName());
        for (Object object : likable_objects) {
            System.out.print(object + " ");
        }
        System.out.println();
    }
}

class Lesson implements Likable {
    String lesson_name;
    String teacher;
    float duration;
    ArrayList<Student> students;

    public Lesson(String lesson_name, float duration, String teacher, Student... cameStudents) {
        students = new ArrayList<>();
        this.lesson_name = lesson_name;
        this.teacher = teacher;
        this.duration = duration;
        students.addAll(Arrays.asList(cameStudents));
    }

    public void displayLessonDetails() {
        System.out.println();
        System.out.println("Teacher: " + teacher);
        System.out.println("Lesson duration: " + duration);
        System.out.print("Students at lesson: ");
        for (Student student : students) {
            System.out.print(student.name + ", ");
        }
        System.out.println();
    }

    private void set_mark(Student student, int current_mark) {
        student.marks.add(current_mark);
    }

    public void mark_everyone(int mark) {
        for (Student student : students) {
            if (student.max_possible_mark >= mark) {
                set_mark(student, mark);
            }
        }
    }

    public void like() {
        // code
    }
}

interface Likable {
    void like();
}

