/**
 * 
 *
 * @Angus Lindsay
 * @6/6/2023
 */
import java.util.Scanner;
import java.io.IOException;
import java.io.File;

public class ReadCSV {
    private final String FILENAME = "dijkstra.txt";
    private final int MAXLINES = 100;
    private final int VALUESPERLINE = 3;

    public ReadCSV() {
        File theFile = new File(FILENAME);
        String[] csvLines = new String[MAXLINES];
        String[][] allLinesAllElements = new String[MAXLINES][VALUESPERLINE];
        int lineCount = 0;

        try {
            Scanner reader = new Scanner(theFile);

            while (reader.hasNextLine() && lineCount < MAXLINES) {
                String line = reader.nextLine();
                csvLines[lineCount] = line;
                lineCount++;
            }

            for (int i = 0; i < lineCount; i++)
                System.out.println(csvLines[i]);

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
        Node.calculateShortestPathFromSource(graph.getNode("A"));
        for (Node node : graph.getNodes()) {
            System.out.println("Shortest Path from A to " + node.getName());
            System.out.println("Distance: " + node.getDistance());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ReadCSV readCSV = new ReadCSV();
    }
}