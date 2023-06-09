/**
 * 
 *
 * @Angus Lindsay
 * @10/6/2023
 */
public class Data {
    public Data() {
        new ReadCSV();
    }

    public static void main(String[] args) {
        Data d = new Data();
        
        ReadCSV readCSV = new ReadCSV();
        Graph graph = readCSV.getGraph();
        int nodeCount = graph.getNodeCount();
        System.out.println("Number of nodes: " + nodeCount);
    }
}
