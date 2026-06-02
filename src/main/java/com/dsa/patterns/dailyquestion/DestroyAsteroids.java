package com.dsa.patterns.dailyquestion;

import java.util.Arrays;

public class DestroyAsteroids {

    public static void main(String[] args) {
        DestroyAsteroids destroyAsteroids = new DestroyAsteroids();
        System.out.println(destroyAsteroids.asteroidsDestroyed(5, new int[]{3, 9, 19, 5, 21}));
    }

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currentMass = mass;
        for (int asteroid : asteroids) {
            if (currentMass >= asteroid) {
                currentMass += asteroid;
            } else {
                return false;
            }
        }
        return true;
    }
}
