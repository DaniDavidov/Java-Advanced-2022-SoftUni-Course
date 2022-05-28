package T05FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class E01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Consumer<String> printConsumer = System.out::println;

        String[] data = scanner.nextLine().split("\\s+");
        Arrays.stream(data).forEach(printConsumer);
    }
}
