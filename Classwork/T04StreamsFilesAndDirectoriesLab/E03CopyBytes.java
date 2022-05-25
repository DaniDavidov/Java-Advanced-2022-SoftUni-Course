package T04StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class E03CopyBytes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pathIn = "C:\\Users\\danid\\IdeaProjects\\javaAdvancedJanuary22\\src\\T04StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "C:\\Users\\danid\\IdeaProjects\\javaAdvancedJanuary22\\src\\T04StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt";

        try(FileInputStream inStream = new FileInputStream(pathIn);
            FileOutputStream outStream = new FileOutputStream(pathOut)) {

            int oneByte = inStream.read();
            while (oneByte >= 0) {
                if (oneByte == 32 || oneByte == 10) {
                    outStream.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        outStream.write(digits.charAt(i));
                    }
                }

                oneByte = inStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
