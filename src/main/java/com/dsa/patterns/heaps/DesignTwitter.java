package com.dsa.patterns.heaps;

import java.util.*;

public class DesignTwitter {

    int timestamp;
    Map<Integer, List<int[]>> userToTweets;
    Map<Integer, Set<Integer>> userToFollowers;

    public DesignTwitter() {
        timestamp = 0;
        userToTweets = new HashMap<>();
        userToFollowers = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userToTweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{timestamp, tweetId});
        timestamp++;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        Set<Integer> followees = new HashSet<>(userToFollowers.getOrDefault(userId, new HashSet<>()));
        followees.add(userId);
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        followees.forEach(user -> {
            List<int[]> tweets = userToTweets.getOrDefault(user, List.of());
            int start = Math.max(0, tweets.size() - 10);
            tweets.subList(start, tweets.size()).forEach(heap::offer);
        });

        while (!heap.isEmpty() && newsFeed.size() < 10) {
            newsFeed.add(heap.poll()[1]);
        }
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        userToFollowers.computeIfAbsent(followerId, id -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        userToFollowers.computeIfPresent(followerId, (k, v) -> {
            v.remove(followeeId);
            return v.isEmpty() ? null : v;
        });
    }

    public static void main(String[] args) {
        DesignTwitter twitter = new DesignTwitter();

        twitter.postTweet(1, 101);
        twitter.postTweet(1, 102);
        System.out.println(twitter.getNewsFeed(1));

        twitter.postTweet(2, 201);
        twitter.follow(1, 2);
        System.out.println(twitter.getNewsFeed(1));

        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));

        twitter.follow(1, 2);
        for (int i = 0; i < 10; i++) {
            twitter.postTweet(2, 300 + i);
        }
        System.out.println(twitter.getNewsFeed(1));
    }

}
