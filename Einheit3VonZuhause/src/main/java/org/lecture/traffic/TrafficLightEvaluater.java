package org.lecture.traffic;

public class TrafficLightEvaluater {

    private TrafficLight trafficLight;

    TrafficLightEvaluater(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    public void evaluate() {
        if (trafficLight == TrafficLight.GREEN) {
            System.out.println("Go");
        }
        else if (trafficLight == TrafficLight.YELLOW) {
            System.out.println("Caution! Stop, if possible");
        }
        else if (trafficLight == TrafficLight.RED) {
            System.out.println("Stop!");
        }
        else {
            System.out.println("Something went wrong");
        }
    }
    }

