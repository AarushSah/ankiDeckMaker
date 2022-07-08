import java.io.File;  // Import the File class
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class AnkiMaker {

    //File Name
    public static String fileName = "newDeck.txt";
    
    //Seperator for Anki text fields
    public static String seperator = " ; ";

    //Line creator for Anki text fields
    public static String writeLine(String... params) {

        String line = "";
        for(int i = 0; i < params.length; i++) {
            line += params[i];
            if(i != params.length - 1) {
                line += seperator;
            }
        }
        line += "\n";  
        
        return line;

    }

    //Create File
    public static void initFile(String fileName) {
        try {
            File file = new File(fileName);
            if(!file.exists()) {
                file.createNewFile();
            }
        } catch(IOException e) {
            System.out.println("Error creating file");
        }
    }

    //Write to File
    public static void writeToFile(String txt) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(txt);
            writer.close();
        } catch(IOException e) {
            System.out.println("Error writing to file");
        }
    }

    //Main Method
    public static void main(String[] args) {
        initFile(fileName);
        String text = "";
        //--EDIT CODE BELOW THIS LINE--
        

        //Creates Anki deck for times tables up to 100
        for(int i = 1; i <= 100; i++) {
            for(int j = 1; j <= 100; j++) {
                text += writeLine(i + " x " + j + " =", (i * j) + "");
            }
        }


        //--EDIT CODE ABOVE THIS LINE--
        writeToFile(text);

    }


}