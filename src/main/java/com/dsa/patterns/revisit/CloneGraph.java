package com.dsa.patterns.revisit;

import com.dsa.patterns.graphs.Node;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {

    private final Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        if (map.containsKey(node)) return map.get(node);

        Node clone = new Node(node.val);

        map.put(node, clone);

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}
