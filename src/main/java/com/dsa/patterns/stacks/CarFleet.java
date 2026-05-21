package com.dsa.patterns.stacks;

import java.util.Arrays;

public class CarFleet {

    public static void main(String[] args) {
        CarFleet carFleet = new CarFleet();
        int target = 12;

        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};

        System.out.println(carFleet.carFleet(target, position, speed));

    }

    public int carFleet(int target, int[] position, int[] speed) {
        double[][] cars = new double[position.length][2];

        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];;
        }

        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleets = 0;
        double currentFleetTime = 0;

        for (double[] car : cars) {
            double time = car[1];

            if (time > currentFleetTime) {
                fleets++;
                currentFleetTime = time;
            }
        }
        return fleets;
    }

}
