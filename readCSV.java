/**
 * @Angus Lindsay
 * @6/04/22
 */

import java.util.Scanner; // needed to read files
import java.io.IOException; // handle errors
import java.io.File;  //  File handles

public class readCSV
{

    final String FILENAME="readme.txt"; // change to reflect the CSV we are reading
    final int MAXLINES=100; // for ease of writing, we are only going to read at most 100 lines.
    final int VALUESPERLINE=4;  // for ease of writing, we know how many values we get on each line.
    /**
     * Constructor for objects of class readCSV
     */
    public readCSV()
    {
        File  thefile = new File(FILENAME);  // generate the file handle
        String CSVlines[] = new String[MAXLINES];
        String AllLinesAllElements[][]=new String[MAXLINES][VALUESPERLINE];  // where we keep all those lines we read in.
        int lineCount=0;  // initially keeps track of lines read, eventually used to remember the number that was read;

        try {
            Scanner reader = new Scanner(thefile); // open the file with the Scanner
            
            // Read in the file, stop at file end or if we read too many lines
            while (reader.hasNextLine()  && lineCount < MAXLINES){
                String line=reader.nextLine();                   
                CSVlines[lineCount]=line;
                lineCount++;
            }

            // Now we have all the lines, lets print them out enmass
            // This is just to prove we have read them in okay.  In reality, we don't need to do this step.
            for (int i =0; i<lineCount; i++)
                System.out.println(CSVlines[i]);

            // We want to split the lines on the comma.  The Split command can do this for us.
            // In production code, we would probably do this during the inital reading step
            for (int i =0; i<lineCount; i++){
                String values[] = CSVlines[i].split(",");  // process the line from the Scanner and break it up at each comma.
                
                // Now we will print it out again, again, this is just to prove a point.  Real code doesn't need this.
                for (int j=0; j< values.length;j++)
                    System.out.print(values[j]+"****");
                System.out.println("");

                // However, we probably will want to put this into an array of Strings, which we may want to later do some
                // other processing on.
                for (int j=0; j< values.length;j++)
                    AllLinesAllElements[i][j]=values[j];
            }  // process the file we read, line by line.

        } catch (IOException e) {System.out.println(e);}
        
        // Here we have all the information in our array and we can do what we want with it.
        //Example #1,  print out just the first column
        System.out.println("The first column read");
        for (int i=0;i<lineCount;i++)
            System.out.println(AllLinesAllElements[i][0]);

        // Example #2, I could print out the number of staff arriving at each time.
        System.out.println("Staff arriving at any given time.");
        for (int i=0;i<lineCount;i++)
            System.out.println("At "+AllLinesAllElements[i][0]+" "+AllLinesAllElements[i][2]+" arrived.");                

    }

}