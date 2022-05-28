package T05FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class E02KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> printConsumer = e -> System.out.println("Sir " + e);
        String[] names = scanner.nextLine().split("\\s+");
        Arrays.stream(names).forEach(printConsumer);
    }
}
