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
        // Pass the graph object to the GUI constructor
        
    }
}
