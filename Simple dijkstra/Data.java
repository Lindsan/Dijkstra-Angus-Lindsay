
/**
 * This has all the data for the algorythm to read and runs the algorythm
 *
 * @Angus Lindsay
 * @25/5/2023
 */

import java.util.List;

public class Data {
    public Data() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        Node.calculateShortestPathFromSource(nodeA);

        // Retrieve the shortest paths and distances
        for (Node node : List.of(nodeA, nodeB, nodeC, nodeD, nodeE, nodeF)) {
            System.out.println("Shortest Path from A to " + node.getName() );
            System.out.println("Distance: " + node.getDistance());

        }
    }

    public static void main(String[] args) {
        Data d = new Data();
    }
}