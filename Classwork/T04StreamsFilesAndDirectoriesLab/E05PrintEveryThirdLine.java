package T04StreamsFilesAndDirectoriesLab;

import java.io.*;
import java.util.Scanner;

public class E05PrintEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String pathIn = "C:\\Users\\danid\\IdeaProjects\\javaAdvancedJanuary22\\src\\T04StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "C:\\Users\\danid\\IdeaProjects\\javaAdvancedJanuary22\\src\\T04StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";

        Scanner in = new Scanner(new FileReader(pathIn));
        PrintWriter out = new PrintWriter(new FileWriter(pathOut));

        int counter = 1;
        String line = in.nextLine();
        while (in.hasNextLine()) {
            if (counter % 3 == 0) {
                out.println(line);
            }
            counter++;
            line = in.nextLine();
        }
        out.close();
    }
}
