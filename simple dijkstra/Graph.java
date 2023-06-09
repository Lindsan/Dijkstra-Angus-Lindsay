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
        nodes.add(node);
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public Node getNode(String name) {
        for (Node node : nodes) {
            if (node.getName().equals(name)) {
                return node;
            }
        }
        return null;
    }

    public int getNodeCount() {
        return nodes.size();
    }
}
