package classical150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2025-01-07 11:24
 */
public class CloneGraph {
    HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }

        if(map.containsKey(node)){
            return map.get(node);
        }

        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node, newNode);

        List<Node> oldNeighbors = node.neighbors;
        for(int i = 0; i < oldNeighbors.size(); i++){
            newNode.neighbors.add(cloneGraph(oldNeighbors.get(i)));
        }
        return newNode;
    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
