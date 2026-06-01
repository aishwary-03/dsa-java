package com.dsa.patterns.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSumII.combinationSum2(candidates, target));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            path.add(candidates[i]);

            backtrack(candidates, i + 1, path, results, remaining - candidates[i]);

            path.removeLast();
        }
    }
}
