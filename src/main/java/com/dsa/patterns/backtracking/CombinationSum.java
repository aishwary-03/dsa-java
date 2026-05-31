package com.dsa.patterns.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(candidates, 0, new ArrayList<>(), results, target);
        return results;
    }

    private void backtrack(int[] candidates, int start, List<Integer> path, List<List<Integer>> results, int remaining) {

        if (remaining == 0) {
            results.add(new ArrayList<>(path));
            return;
        }

        if (remaining < 0) return;

        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtrack(candidates, i, path, results, remaining - candidates[i]);
            path.removeLast();
        }
    }

}
