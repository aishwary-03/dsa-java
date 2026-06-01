package com.dsa.patterns.dailyquestion;

public class EarliestFinishTimeForLandAndWaterRidesI {

    public static void main(String[] args) {
        EarliestFinishTimeForLandAndWaterRidesI earliestFinishTimeForLandAndWaterRidesI = new EarliestFinishTimeForLandAndWaterRidesI();
        int[] landStartTime = {2, 8};
        int[] landDuration = {4, 1};
        int[] waterStartTime = {6};
        int[] waterDuration = {3};
        System.out.println(earliestFinishTimeForLandAndWaterRidesI.earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration));
    }

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(earliest(landStartTime, landDuration, waterStartTime, waterDuration),
                earliest(waterStartTime, waterDuration, landStartTime, landDuration));
    }

    public int earliest(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int fastestLandRide = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            fastestLandRide = Math.min(fastestLandRide, landStartTime[i] + landDuration[i]);
        }

        int fastestRides = Integer.MAX_VALUE;
        for (int i = 0; i < waterStartTime.length; i++) {
            int waterRideStart = Math.max(fastestLandRide, waterStartTime[i]);
            fastestRides = Math.min(fastestRides, waterRideStart + waterDuration[i]);
        }
        return fastestRides;
    }
}
