package T08IterstorsAndComparatorsExercises.E01ListyIterator;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> inputData = Arrays.stream(input.split("\\s+"))
                .skip(1).collect(Collectors.toList());
        ListyIterator listyIterator = new ListyIterator(inputData);


        String line;
        while (!"END".equals(line = scanner.nextLine())) {
            String[] data = line.split("\\s+");
            String command = data[0];

            switch (command) {
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (Exception e) {
                        System.out.println("Invalid Operation!");
                    }

                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
            }
        }
    }
}
