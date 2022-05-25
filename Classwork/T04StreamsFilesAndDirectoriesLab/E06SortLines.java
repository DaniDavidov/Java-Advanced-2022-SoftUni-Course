package T04StreamsFilesAndDirectoriesLab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class E06SortLines {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String pathIn = "C:\\Users\\danid\\IdeaProjects\\javaAdvancedJanuary22\\src\\T04StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "C:\\Users\\danid\\IdeaProjects\\javaAdvancedJanuary22\\src\\T04StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt";

        Path input = Paths.get(pathIn);
        Path output = Paths.get(pathOut);

        List<String> lines = Files.readAllLines(input);
        Collections.sort(lines);
        Files.write(output, lines);
    }
}
