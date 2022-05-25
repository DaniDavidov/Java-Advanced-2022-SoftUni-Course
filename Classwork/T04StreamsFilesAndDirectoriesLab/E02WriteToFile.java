package T04StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class E02WriteToFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pathIn = "C:\\Users\\danid\\IdeaProjects\\javaAdvancedJanuary22\\src\\T04StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "C:\\Users\\danid\\IdeaProjects\\javaAdvancedJanuary22\\src\\T04StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";
        Set<Character> punctuation = new HashSet<>();
        Collections.addAll(punctuation, ',', '.', '!', '?');

        try(FileInputStream inStream = new FileInputStream(pathIn);
            FileOutputStream outStream = new FileOutputStream(pathOut)) {
            int oneByte = inStream.read();

            while (oneByte >= 0) {
                char oneByteAsChar = (char) oneByte;
                if (!punctuation.contains(oneByteAsChar)) {
                    outStream.write(oneByte);
                }
                oneByte = inStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
