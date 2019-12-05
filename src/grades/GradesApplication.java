package grades;

import java.util.HashMap;
import java.util.Set;


public class GradesApplication {

    public static HashMap<String, Student> students = new HashMap<>();

    public static String[] getNames() { // get student names
        String[] studentNamesArr = new String[students.size()];
        return students.keySet().toArray(studentNamesArr);
    }

//        TODO: UNCOMMENT BELOW
//    public static void displayStudentGrades(String[] studentNames) {
//        for (String name : studentNames) { // iterates through array and prints each element
//            System.out.printf("Student: %s", name);
//            System.out.println("Grades:");
//            for (int grade : students.get(name).getAllGrades()) {
//                System.out.printf("- %d%n", grade);
//            }
//        }
//    }

    //        TODO: UNCOMMENT BELOW
//    public static void displayStudentInfo(String[] studentsNames) {
//        for (String name : studentsNames) {
//            displayStudentGrades(studentsNames);
//            System.out.printf("GPA: %f", students.get(name).getGradeAverage());
//            System.out.println("---------------");
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

//        System.out.println(students);
//        getNames();
//        displayStudentInfo(getNames());
//        TODO: UNCOMMENT BELOW
//        displayStudentGrades(getNames());
//        displayStudentInfo(getNames());
    }
}
