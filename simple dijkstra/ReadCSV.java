/**
 * 
 * @Angus Lindsay
 * @10/6/2023
 */
import java.util.Scanner;
import java.io.IOException;
import java.io.File;

public class ReadCSV {
    private String fileName = "dijkstra.txt";
    private int MAXLINES = 100;
    private int VALUESPERLINE = 3;
    private Graph graph;

    public ReadCSV() {
        Scanner inputStream = new Scanner(System.in);
        
        // Prompt for the name of the file
        // System.out.println("What is the name of the file?");
        // String fileName = inputStream.nextLine();

        // Prompt for the node to calculate the shortest path from
        System.out.println("Which node would you like to calculate the shortest path from?");
        String startNode = inputStream.nextLine();

        File theFile = new File(fileName);
        String[] csvLines = new String[MAXLINES];
        String[][] allLinesAllElements = new String[MAXLINES][VALUESPERLINE];
        int lineCount = 0;

        try {
            Scanner reader = new Scanner(theFile);

            // Read lines from the file
            while (reader.hasNextLine() && lineCount < MAXLINES) {
                String line = reader.nextLine();
                csvLines[lineCount] = line;
                lineCount++;
            }

            // Print the read lines
            for (int i = 0; i < lineCount; i++) {
                System.out.println(csvLines[i]);
            }

            // Split lines into values
            for (int i = 0; i < lineCount; i++) {
                String[] values = csvLines[i].split(",");
                for (int j = 0; j < VALUESPERLINE; j++) {
                    if (j < values.length)
                        allLinesAllElements[i][j] = values[j];
                    else
                        allLinesAllElements[i][j] = "";
                }
            }

        } catch (IOException e) {
            System.out.println(e);
        }

        // Create nodes and graph based on the read data
        Graph graph = new Graph();

        for (int i = 0; i < lineCount; i++) {
            String nodeName = allLinesAllElements[i][0];
            Node node = graph.getNode(nodeName);

            if (node == null) {
                node = new Node(nodeName);
                graph.addNode(node);
            }

            for (int j = 1; j < VALUESPERLINE; j += 2) {
                if (!allLinesAllElements[i][j].isEmpty() && !allLinesAllElements[i][j + 1].isEmpty()) {
                    String destinationName = allLinesAllElements[i][j];
                    int distance = Integer.parseInt(allLinesAllElements[i][j + 1]);

                    Node destination = graph.getNode(destinationName);
                    if (destination == null) {
                        destination = new Node(destinationName);
                        graph.addNode(destination);
                    }

                    node.addDestination(destination, distance);
                    destination.addDestination(node, distance); // Connect both nodes
                }
            }
        }

        // Print shortest paths
        Node.calculateShortestPathFromSource(graph.getNode(startNode));
        for (Node node : graph.getNodes()) {
            System.out.println("Shortest Path from " + startNode + " to " + node.getName());
            System.out.println("Distance: " + node.getDistance());
            System.out.println();
        }
        System.out.println("Node count: " + graph.getNodeCount());
        this.graph = graph; // Assign the created graph to the field
        GUI gui = new GUI(graph);
    }

    public Graph getGraph() {
        return graph;
    }
}
