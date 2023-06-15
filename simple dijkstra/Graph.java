/**
 * 
 *
 * @Angus Lindsay
 * @10/6/2023
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
