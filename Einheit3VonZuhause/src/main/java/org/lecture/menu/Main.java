package org.lecture.menu;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scan = new Scanner(System.in);
        String menu = """
                Please choose an option:
                1 - Addition
                2 - Subtraktion
                3 - Multiplikation
                4 - Division
                5 - Modulo
                
                Choose a number:
                """;
        System.out.println(menu);

        String choice = scan.nextLine();
        MathOperations type =
                switch (choice){
            case "1" -> MathOperations.ADD;
            case "2" -> MathOperations.SUBTRACT;
            case "3" -> MathOperations.MULTIPLY;
            case "4" -> MathOperations.DIVIDE;
            case "5" -> MathOperations.MODULO;
                    default -> {
                        System.out.println("Invalid choice!");
                        yield  null;
                    }
                };
        if (type == null){
            System.out.println("Invalid choice!");
        }
        else {
            System.out.println("Select an option: " + type);
        }


    }
}
