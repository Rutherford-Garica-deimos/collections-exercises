package grades;

import java.util.HashMap;

import java.util.Scanner;

import util.Input;

public class GradesApplication {

    private static Input input = new Input();
    private static boolean continueLoop = true;
    public static Scanner scan = new Scanner(System.in);

    public static HashMap<String, Student> students = new HashMap<>();

    public static void splash() {
        System.out.println("Here are the GitHub user names of our students:");
        students.forEach((key, value) -> System.out.printf("| %s | ", key));
        System.out.printf("%n%n");
    }

    public static void displayOptions() {
        System.out.printf("Select an option: (0-3)%n");
        System.out.printf("0 - exit%n");
        System.out.printf("1 - student search%n");
        System.out.printf("2 - student search (detailed)%n");
        System.out.printf("3 - view all students%n");
    }

    public static int selectOption() {
        return input.getInt(0, 3);
    }

    public static void userSelection(int option) {
        switch (option) {
            case 0:
                continueLoop = false;
                break;
            case 1:
                studentSearch();
                break;
            case 2:
                studentSearchDetailed();
                break;
            case 3:
                displayAllStudents(getNames());
                confirm();
                break;
        }
    }

    protected static String studentSearchInput() {
        System.out.println("What student would you like to see more information on?");
        String studentId = scan.next();
        if (students.get(studentId) == null) {
            System.out.printf("Sorry, no student found with the GitHub username of \"%s\".%n%n", studentId);
            return studentSearchInput(); // Talk about
        } else {
            return studentId;
        }
    }

    public static void displayStudent(String studentName) {
        System.out.printf("Name %s -  GitHub Username: %s%nGrades:%n", students.get(studentName).getName(), studentName);
        displayGrades(studentName);
    }

    public static void displayGrades(String name) {
        for (int grade : students.get(name).getAllGrades()) {
            System.out.printf("- %d%n", grade);
        }
    }

    public static void displayAverage(String studentName) {
        System.out.printf("GPA: %f.2", students.get(studentName).getGradeAverage());
    }

    public static void studentSearch() { // displays student w/all grades
        String student = studentSearchInput();
        displayStudent(student);
        confirm();
    }

    public static void studentSearchDetailed() { // displays student w/all grades & avg.
        String student = studentSearchInput();
        displayStudent(student);
        displayAverage(student);
        confirm();
    }

    public static String[] getNames() { // get all student names
        String[] studentNamesArr = new String[students.size()];
        return students.keySet().toArray(studentNamesArr); // convert Set object -> array
    }

    public static void displayAllStudents(String[] studentNames) { // displays all students details
        for (String name : studentNames) { // iterates through array and prints each element
            System.out.printf("Student: %s", name);
            System.out.println("Grades:");
            displayGrades(name);
            displayAverage(name);
            System.out.println("---------------");
        }
    }

    public static void confirm() { // confirmation to continue
        System.out.println("Would you like to perform another search?(yes/no)");
        String yesNo = scan.next();
        if (yesNo.equalsIgnoreCase("y") || yesNo.equalsIgnoreCase("yes")) {
            run();
        } else {
            continueLoop = false;
            System.out.println("Goodbye, and have a wonderful day!");
        }
    }

    public static void run() { // single method to run program
        splash();
        displayOptions();
        userSelection(selectOption());
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

        System.out.println("Welcome!");

        while (continueLoop) {
            run();
        }
    }
}
