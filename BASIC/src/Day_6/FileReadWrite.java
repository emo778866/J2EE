package Day_6;
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWrite {
    public static void main(String[] args) {

        try {

            File file = new File("output1.txt");
            if (file.createNewFile()) {
                System.out.println("New file created!");
            } else {
                System.out.println("File already exists!");
            }

            FileWriter myWriter = new FileWriter(file, true);
            myWriter.write("This is the first line of file\n");
            myWriter.write("This is the second line of file\n");
            myWriter.write("This is the third line of file\n");
            myWriter.write("This is the fourth line of file\n");

            System.out.println("Writing is done and closing the file.");
            myWriter.close();

            System.out.println("Printing the file - ");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
            String fName = file.getName();
            if (file.delete()) {
                System.out.println("The file named " + fName + " is deleted!");
            }
        } catch (IOException ignored) {
        }
    }
}