package org.lecture.traffic;

import java.util.Scanner;

public class TrafficLightMain {
    static Scanner scan = new Scanner(System.in);

    static void main() {
        String menu = """
                3 - Green
                2 - Yellow
                1 - Red
                """;

        System.out.print(menu);
        String choice = scan.nextLine();

        TrafficLight light = switch (choice){
            case "1" -> TrafficLight.RED;
            case "2" -> TrafficLight.YELLOW;
            case "3" -> TrafficLight.GREEN;
            default -> null;
        };

        TrafficLightEvaluater evaluator = new TrafficLightEvaluater(light);
        evaluator.evaluate();

    }
}
