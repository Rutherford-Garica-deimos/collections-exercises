package grades;

import java.util.HashMap;


public class GradesApplication {

    public static HashMap<String, Student> students = new HashMap<>();

//    public static int getGrade(String name) {
//        for (Student student : students) {
//
//        }
//    }

    public static void main(String[] args) {

        Student bob = new Student("Bob");
        Student jack = new Student("Jack");
        Student phil = new Student("Phil");
        Student david = new Student("David");

        bob.addGrade(89);
        bob.addGrade(97);
        bob.addGrade(69);

        jack.addGrade(99);
        jack.addGrade(96);
        jack.addGrade(89);

        phil.addGrade(79);
        phil.addGrade(83);
        phil.addGrade(78);

        david.addGrade(100);
        david.addGrade(89);
        david.addGrade(94);

        students.put("bigBob", bob);
        students.put("bigJack", jack);
        students.put("bigPhil", phil);
        students.put("littleDavid", david);

        System.out.println(students);
    }
}
