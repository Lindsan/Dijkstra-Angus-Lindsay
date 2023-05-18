/**
 * SplitIt:
 * Demonstration code that uses the Split function.
 *
 * @Angus Lindsay
 * @6/04/22
 */
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class fileReader
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class SplitIt
     */
    public fileReader()
    {
        demoTry();   
    }

    
    void demoTry(){
        int MAXLINES =100;
        int VALUESPERLINE=4;
        System.out.println("Type the name of a file");
        String s1;
        Scanner keyboard;
        Scanner inputStream = new Scanner(System.in);
        s1= inputStream.nextLine();
        String CSVlines[] = new String[MAXLINES];
        String AllLinesAllElements[][]=new String[MAXLINES][VALUESPERLINE];  // where we keep all those lines we read in.
        int lineCount=0;
        File myFile=new File(s1);
        try{
            Scanner readTheFile = new Scanner(myFile);
            while (readTheFile.hasNextLine()){
                String[] currentLine = readTheFile.nextLine().split(" |,");

                System.out.println(readTheFile.nextLine());
                 String splitMe=readTheFile.nextLine();
                String splitOn="a";
                String parts[]=splitMe.split(splitOn);  // this is the magic where we use the split command.
                 int fields=0;
                for (int j=0;j<currentLine.length;j++){
                    
                    String hi =currentLine[j];
                    //System.out.println(hi);
                }
                for (int i=0;i<parts.length;i++){
                    System.out.println(parts[i]); 
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something bad has happened");
        }  
        
        
    }
}