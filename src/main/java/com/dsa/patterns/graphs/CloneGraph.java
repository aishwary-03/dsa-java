package com.dsa.patterns.graphs;

import java.util.*;

public class CloneGraph {

    private final Map<Node, Node> map = new HashMap<>();

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        CloneGraph cloneGraph = new CloneGraph();
        Node dfsClonedGraph = cloneGraph.cloneGraph(node1);
        Node bfsClonedGraph = cloneGraph.cloneGraphBFS(node1);

        System.out.println("Original Graph:");
        printGraph(node1);

        System.out.println("\nDFS Cloned Graph:");
        printGraph(dfsClonedGraph);

        System.out.println("\nBFS Cloned Graph:");
        printGraph(bfsClonedGraph);
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node clone = new Node(node.val);

        map.put(node, clone);

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;

    }

    public Node cloneGraphBFS(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        Node clone = new Node(node.val);

        map.put(node, clone);
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (Node neighbor : current.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                map.get(current).neighbors.add(map.get(neighbor));
            }
        }
        return clone;
    }

    public static void printGraph(Node node) {

        if (node == null) {
            return;
        }

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);
        visited.add(node);

        while (!queue.isEmpty()) {

            Node current = queue.poll();

            System.out.print("Node " + current.val + " -> ");

            for (Node neighbor : current.neighbors) {

                System.out.print(neighbor.val + " ");

                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
            System.out.println();
        }
    }




}
