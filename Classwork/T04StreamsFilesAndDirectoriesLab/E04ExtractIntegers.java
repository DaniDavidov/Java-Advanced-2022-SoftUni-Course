package T04StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class E04ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String pathIn = "C:\\Users\\danid\\IdeaProjects\\javaAdvancedJanuary22\\src\\T04StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "C:\\Users\\danid\\IdeaProjects\\javaAdvancedJanuary22\\src\\T04StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";

        Scanner scanner = new Scanner(new FileInputStream(pathIn));
        PrintWriter printWriter = new PrintWriter(pathOut);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                printWriter.println(number);
            }
            scanner.next();
        }
        printWriter.close();
    }
}
