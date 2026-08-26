package controlflow.class_problems;

public class GradeClassifier {
    public void classifyWithAttendance(int marks, int attendance) {
        if (attendance >= 75 && marks >= 40) {
            if (marks >= 90) {
                System.out.println("Grade: A");
            } else if (marks >= 75) {
                System.out.println("Grade: B");
            } else if (marks >= 60) {
                System.out.println("Grade: C");
            } else {
                System.out.println("Grade: D");
            }
        } else {
            System.out.println("Detained");
        }
    }

    public static void main(String[] args) {
        GradeClassifier gc = new GradeClassifier();
        gc.classifyWithAttendance(82, 80); // Grade: B
        gc.classifyWithAttendance(91, 60); // Detained
    }
}
