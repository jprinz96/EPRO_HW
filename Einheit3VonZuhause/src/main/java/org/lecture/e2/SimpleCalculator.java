package org.lecture.e2;

import java.util.Scanner;

public class SimpleCalculator {
    static Scanner scan = new Scanner(System.in);

    static void main() {
        System.out.print("Enter first double: ");
        double a = readDouble();
        System.out.print("Enter second double: ");
        double b = readDouble();
        System.out.print("""
                Choose calculation type:
                 ADD (+)
                 SUBTRACT (-)
                 MULTIPLY (*)
                 DIVIDE (/)
                 MODULO (%)
                Enter the Name: 
                """);
        String type = readCalcType();

        if((CalculationType.DIVIDE == CalculationType.valueOf(type) || CalculationType.MODULO == CalculationType.valueOf(type)) && b == 0) {
            System.out.println("Error: Division or modulo by zero not allowed!");
            System.exit(0);
        }

        double result = calculate(a,b, CalculationType.valueOf(type));
        System.out.printf("Result: %.2f" , result);

    }

    static double calculate(double a, double b, CalculationType type) {
        return switch (type) {
            case ADD -> a + b;
            case SUBTRACT -> a - b;
            case MULTIPLY -> a * b;
            case DIVIDE -> a / b;
            case MODULO -> a % b;
        };

    }

    static double readDouble() {
        double number = scan.nextDouble();
        scan.nextLine();
        return number;
    }

    static String readCalcType() {
        String type = scan.nextLine().toUpperCase();
        return type;
    }

}
