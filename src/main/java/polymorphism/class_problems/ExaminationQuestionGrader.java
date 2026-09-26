package polymorphism.class_problems;

import java.util.*;

abstract class Question {
    String questionText;
    String correctAnswer;
    String studentAnswer;
    int points;

    Question(String questionText, String correctAnswer, String studentAnswer, int points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double calculateScore();
    abstract String getType();
}

class MCQQuestion extends Question {
    MCQQuestion(String q, String correct, String student, int points) {
        super(q, correct, student, points);
    }
    double calculateScore() {
        return correctAnswer.equals(studentAnswer) ? points : 0;
    }
    String getType() { return "MCQ"; }
}

class TFQuestion extends Question {
    TFQuestion(String q, String correct, String student, int points) {
        super(q, correct, student, points);
    }
    double calculateScore() {
        return correctAnswer.equals(studentAnswer) ? points : 0;
    }
    String getType() { return "TF"; }
}

class EssayQuestion extends Question {
    EssayQuestion(String q, String correct, String student, int points) {
        super(q, correct, student, points);
    }
    double calculateScore() {
        String[] keywords = correctAnswer.split(",");
        int matches = 0;
        String lowerStudent = studentAnswer.toLowerCase();
        for (String keyword : keywords) {
            if (lowerStudent.contains(keyword.trim().toLowerCase())) {
                matches++;
            }
        }
        if (matches >= 2) return points * 0.75;
        if (matches == 1) return points * 0.50;
        return 0;
    }
    String getType() { return "ESSAY"; }
}

public class ExaminationQuestionGrader {

    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new MCQQuestion("What is the capital of France?", "Paris", "Paris", 10));
        questions.add(new TFQuestion("The Earth is flat?", "False", "True", 5));
        questions.add(new EssayQuestion("Name two primary OOP principles.", "Inheritance, Polymorphism, Encapsulation", "Polymorphism is one.", 20));
        questions.add(new EssayQuestion("Describe abstraction and composition.", "Abstraction, Composition", "I talked about abstraction.", 15));

        double total = 0;
        for (Question q : questions) {
            double score = q.calculateScore();
            System.out.printf("%s: %.2f%n", q.getType(), score);
            total += score;
        }
        System.out.printf("Total Score: %.2f%n", total);
    }
}