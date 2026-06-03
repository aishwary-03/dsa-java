package com.dsa.patterns.dailyquestion;

public class EarliestFinishTimeForLandAndWaterRidesII {

    public static void main(String[] args) {
        EarliestFinishTimeForLandAndWaterRidesII earliestFinishTimeForLandAndWaterRidesII = new EarliestFinishTimeForLandAndWaterRidesII();
        int[] landStartTime = {2, 8};
        int[] landDuration = {4, 1};
        int[] waterStartTime = {6};
        int[] waterDuration = {3};
        System.out.println(earliestFinishTimeForLandAndWaterRidesII.earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration));
    }

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(earliest(landStartTime, landDuration, waterStartTime, waterDuration),
                earliest(waterStartTime, waterDuration, landStartTime, landDuration));
    }

    public int earliest(int[] ride1StartTime, int[] ride1Duration, int[] ride2StartTime, int[] ride2Duration) {
        int ride1Finish = Integer.MAX_VALUE;
        for (int i = 0; i < ride1StartTime.length; i++) {
            ride1Finish = Math.min(ride1Finish, ride1StartTime[i] + ride1Duration[i]);
        }

        int minRideTime = Integer.MAX_VALUE;
        for (int i = 0; i < ride2StartTime.length; i++) {
            int ride2Start = Math.max(ride1Finish, ride2StartTime[i]);
            minRideTime = Math.min(minRideTime, ride2Start + ride2Duration[i]);
        }
        return minRideTime;
    }

}
