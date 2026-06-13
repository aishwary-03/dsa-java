package com.dsa.patterns.revisit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("love", "high", 10);
        timeMap.set("love", "low", 20);
        System.out.println(timeMap.get("love", 5));
        System.out.println(timeMap.get("love", 10));
        System.out.println(timeMap.get("love", 15));
        System.out.println(timeMap.get("love", 20));
        System.out.println(timeMap.get("love", 25));
    }
}

class TimeMap {

    private final Map<String, List<Pair>> store;

    public TimeMap() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!store.containsKey(key)) return "";

        List<Pair> values = store.get(key);

        int low = 0;
        int high = values.size() - 1;

        while (low < high) {
            int mid = low + (high - low + 1) / 2;

            Pair pair = values.get(mid);

            if (pair.timeStamp() == timestamp) return pair.value();
            else if (pair.timeStamp() < timestamp) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return values.get(low).timeStamp() > timestamp ? "" : values.get(low).value();
    }

}

record Pair(int timeStamp, String value) {}
