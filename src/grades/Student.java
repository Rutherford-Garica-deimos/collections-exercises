package grades;

import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Integer> grades;

    public Student(String name) {
        this.name = name;
        grades = new ArrayList<>();
    }

    // returns the student's name
    public String getName() {
        return this.name;
    }

    ;

    // adds the given grade to the grades property
    public void addGrade(int grade) {
        grades.add(grade);
    }

    public int[] getAllGrades(){
        int[] newArray = new int[grades.size()];
        for (int i= 0 ; i< newArray.length;i++){
            newArray[i] = grades.indexOf(i);
        }
        return newArray;
    }

    ;

    // returns the average of the students grades
    public double getGradeAverage() {
        double average = 0;
        for (int grade : this.grades) {
            average += grade;
        }
        average = average / grades.size();
        return average;
    }

    public static void main(String[] args) {
        Student student1 = new Student("Bob");
        student1.addGrade(84);
        student1.addGrade(76);
        student1.addGrade(89);
        System.out.println(student1.getGradeAverage());
    }
}
