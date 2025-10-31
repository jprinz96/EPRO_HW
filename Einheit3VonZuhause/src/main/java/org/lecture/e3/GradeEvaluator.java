package org.lecture.e3;

import java.util.Scanner;

public class GradeEvaluator {

    private static Scanner scan = new Scanner(System.in);
    static void main() {

        System.out.println("Enter your achieved score: ");
        double score = getScoreFromeConsole();
        evaluateGrade(score);

    }

    private static double getScoreFromeConsole() {
        double score = scan.nextDouble();
        return score;
    }
    private static void evaluateGrade(double score) {
        int grade = (score <= 59) ? 5
                : (score < 70) ? 4
                : (score < 80) ? 3
                : (score <= 90) ? 2
                : 1;
        System.out.printf("Your grade fore score %.2f is: %d " , score, grade);

    }
}
