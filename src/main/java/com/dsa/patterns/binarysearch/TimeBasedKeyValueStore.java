package com.dsa.patterns.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {

    Map<String, List<Pair>> store = new HashMap<>();

    public static void main(String[] args) {
        TimeBasedKeyValueStore timeBasedKeyValueStore = new TimeBasedKeyValueStore();
        timeBasedKeyValueStore.set("love", "high", 10);
        timeBasedKeyValueStore.set("love", "low", 20);
        System.out.println(timeBasedKeyValueStore.get("love", 5));
        System.out.println(timeBasedKeyValueStore.get("love", 10));
        System.out.println(timeBasedKeyValueStore.get("love", 15));
        System.out.println(timeBasedKeyValueStore.get("love", 20));
        System.out.println(timeBasedKeyValueStore.get("love", 25));

    }

    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        String result = "";
        if (!store.containsKey(key)) return result;

        List<Pair> pairs = store.get(key);
        int left = 0;
        int right = pairs.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Pair pair = pairs.get(mid);

            if (pair.timestamp() <= timestamp) {
                result = pair.value();
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return result;
    }
}

record Pair(int timestamp, String value) { }
