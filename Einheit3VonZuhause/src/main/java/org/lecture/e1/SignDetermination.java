package org.lecture.e1;

import java.util.Scanner;

public class SignDetermination {
    private static Scanner scan = new Scanner(System.in);

    static void main() {
        System.out.println("Please enter a number: ");
        int number = getNumberFromConsole();
        isNegative(number);
        System.out.println("Enter another number: ");
        int number2 = getNumberFromConsole();
        isNegative(number2);

    }

    public static int getNumberFromConsole() {
        int number = scan.nextInt();
        scan.nextLine();
        return number;
    }

    public static void isNegative(int number) {
        if (number < 0) {
            System.out.println("Number is negative");
        } else if (number > 0) {
            System.out.println("Number is positive");
        } else {
            System.out.println("Number is zero");
        }
    }
}
