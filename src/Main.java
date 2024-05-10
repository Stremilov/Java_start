import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main() {
        Student Lev = new Student(18, "Lev", 1, 5);
        Student German = new Student(24, "German", 3, 5);
        Student Sveta = new Student(19, "Sveta", 5, 3);

        Lesson lesson_1 = new Lesson(1F, "Natalya Mihaylovna", Lev, German);
//        lesson_1.mark_everyone(lesson_1.students.toArray(new Student[0]), 5);
        lesson_1.mark_everyone(5);

        Lesson lesson_2 = new Lesson(1.5F, "Pavel Sergeevich", Sveta);
//        lesson_2.mark_everyone(lesson_2.students.toArray(new Student[0]), 5);
        lesson_2.mark_everyone(5);

        Lev.display_student_info();
        German.display_student_info();
        Sveta.display_student_info();

        lesson_1.mark_everyone(4);

        Lev.display_student_info();
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
    int max_possible_mark;
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

}

class Lesson {
    String teacher;
    float duration;
    ArrayList<Student> students;

    public Lesson(float duration, String teacher, Student... cameStudents) {
        students = new ArrayList<>();
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
}