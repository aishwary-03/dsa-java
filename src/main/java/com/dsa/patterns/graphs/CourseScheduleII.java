package com.dsa.patterns.graphs;

import java.util.*;

public class CourseScheduleII {

    public static void main(String[] args) {
        CourseScheduleII courseScheduleII = new CourseScheduleII();
        int[][] prerequisites = {{0, 1}, {1, 0}};
        System.out.println(Arrays.toString(courseScheduleII.findOrder(2, prerequisites)));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];

            adj.get(prerequisite).add(course);

            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int completedCourses = 0;
        int[] order = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            completedCourses++;
            order[index++] = current;

            for (int neighbor : adj.get(current)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return completedCourses == numCourses ? order : new int[]{};


    }
}
