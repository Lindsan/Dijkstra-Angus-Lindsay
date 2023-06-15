/**
 * 
 *
 * @Angus Lindsay
 * @10/6/2023
 */
public class Data {
    public Data() {
        new ReadCSV(); // Creates an instance of the ReadCSV class.
    }

    public static void main(String[] args) {
        Data d = new Data();

        ReadCSV readCSV = new ReadCSV(); // Creates another instance of the ReadCSV class.
        Graph graph = readCSV.getGraph(); // Retrieves the Graph object from the ReadCSV instance.
        int nodeCount = graph.getNodeCount(); // Gets the number of nodes in the graph.
        System.out.println("Number of nodes: " + nodeCount); // Prints the number of nodes to the console.
    }
}
