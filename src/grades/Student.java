package grades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private ArrayList<Integer> grades;
    private HashMap<String, String> attendance;

    public Student(String name) {
        this.name = name;
        grades = new ArrayList<>();
        attendance = new HashMap<>();
    }

    // returns the student's name
    public String getName() {
        return this.name;
    }

    // adds the given grade to the grades property
    public void addGrade(int grade) {
        grades.add(grade);
    }

    public int[] getAllGrades() {
        int[] newArray = new int[grades.size()];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = grades.get(i);
        }
        return newArray;
    }

    // returns the average of the students grades
    public double getGradeAverage() {
        double average = 0;
        for (int grade : this.grades) {
            average += grade;
        }
        average = average / grades.size();
        return average;
    }

    /*
        Create an instance method on your Student class to calculate a student's attendance percentage -- (Total Days - Absences) / Total Days.
     */
    public void addAttendanceLog(String date, String status) {
        attendance.put(date, status);
    }

    public HashMap<String, String> studentAttendanceRecord() {
        return attendance;
    }

    public int attendancePercentage() {
        if (attendance.isEmpty()) {
            return 0;
        } else {
            return ((attendance.size() - totalAbsents().size()) / attendance.size());
        }
    }

    public ArrayList<Map.Entry<String, String>> totalAbsents() {
        ArrayList<Map.Entry<String, String>> absents = new ArrayList<>();
        for (Map.Entry<String, String> entry : attendance.entrySet()) {
            if (entry.getValue().equalsIgnoreCase("a")) {
                absents.add(entry);
            }
        }
        return absents;
    }

    public static void main(String[] args) {
        Student student1 = new Student("Bob");
        student1.addGrade(84);
        student1.addGrade(76);
        student1.addGrade(89);
        System.out.println(student1.getGradeAverage());
    }
}
