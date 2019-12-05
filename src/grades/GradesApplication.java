package grades;

import java.util.HashMap;

import java.util.Scanner;

import util.Input;

public class GradesApplication {

    Input input = new Input();

    public static HashMap<String, Student> students = new HashMap<>();
    public static Scanner scan = new Scanner(System.in);

    public static String[] getNames() { // get student names
        String[] studentNamesArr = new String[students.size()];
        return students.keySet().toArray(studentNamesArr);
    }

    public static void displayStudentGrades(String[] studentNames) {
        for (String name : studentNames) { // iterates through array and prints each element
            System.out.printf("Student: %s", name);
            System.out.println("Grades:");
            for (int grade : students.get(name).getAllGrades()) {
                System.out.printf("- %d%n", grade);
            }
        }
    }

    public static void displayStudentInfo(String[] studentsNames) {
        for (String name : studentsNames) {
            displayStudentGrades(studentsNames);
            System.out.printf("GPA: %f", students.get(name).getGradeAverage());
            System.out.println("---------------");
        }
    }

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

//        displayStudentGrades(getNames());
        displayStudentInfo(getNames());

        System.out.println("Welcome!\n");
        Boolean continueLoop = true;
        while (continueLoop) {

            System.out.println("Here are the GitHub usernames of our students:\n");

            students.forEach((key, value) -> System.out.printf("| %s | ", key));
            System.out.println();

            studentSearchInput();

            System.out.println("Would you like to see another student?(yes/no)");
            String yesNo = scan.next();
            if (yesNo.equalsIgnoreCase("no") || yesNo.equalsIgnoreCase("n")) {
                continueLoop = false;
                System.out.println("Goodbye, and have a wonderful day!");
            }
        }
    }

//    public static int selectOption() {
//        System.out.printf("Enter your choice: %n");
//        return input.getInt(0, 5);
//    }

    public static void displayOptions() {
        System.out.printf("0 - exit%n");
        System.out.printf("1 - student search%n");
        System.out.printf("2 - student search (detailed)%n");
        System.out.printf("3 - view all students%n");
    }

    protected static void studentSearchInput() {
        System.out.println("Select an option:");
        displayOptions();
        System.out.println("What student would you like to see more information on?\n");

        String studentId = scan.next();
        if (students.get(studentId) != null) {
            System.out.printf("%nName %s -  GitHub Username: %s%nCurrent Average: %.2f%n%n"
                    , students.get(studentId).getName(), studentId, students.get(studentId).getGradeAverage());
        } else {
            System.out.printf("%nSorry, no student found with the GitHub username of \"%s\".%n%n", studentId);
        }

    }
}
