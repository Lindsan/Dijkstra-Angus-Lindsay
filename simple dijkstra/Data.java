/**
 * This class serves as the entry point for the program. It creates an instance of the ReadCSV class and initializes the GUI by passing the Graph object to its constructor.
 *
 * @Angus Lindsay
 * @25/6/2023
 */
public class Data {
    public Data() {
        new ReadCSV(); // Creates an instance of the ReadCSV class.
    }

    public static void main(String[] args) {
        Data d = new Data();

        ReadCSV readCSV = new ReadCSV(); // Creates another instance of the ReadCSV class.
        Graph graph = readCSV.getGraph(); // Retrieves the Graph object from the ReadCSV instance.
        // Pass the graph object to the GUI constructor
        GUI gui = new GUI(graph);
    }
}

