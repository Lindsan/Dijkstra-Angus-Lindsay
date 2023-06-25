/**
 * This class represents a graph data structure. It stores a set of Node objects and provides methods to add nodes, retrieve nodes by name, and get the total count of nodes in the graph.
 *
 * @Angus Lindsay
 * @25/6/2023
 */
import java.util.*;

public class Graph {
    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node node) {
        nodes.add(node); // Adds a Node to the set of nodes.
    }

    public Set<Node> getNodes() {
        return nodes; // Returns the set of nodes.
    }

    public Node getNode(String name) {
        for (Node node : nodes) {
            if (node.getName().equals(name)) {
                return node; // Returns the Node with the specified name.
            }
        }
        
        return null; // Returns null if no Node with the specified name is found.
    }

    public int getNodeCount() {
        return nodes.size(); // Returns the number of nodes in the graph.
    }
}
