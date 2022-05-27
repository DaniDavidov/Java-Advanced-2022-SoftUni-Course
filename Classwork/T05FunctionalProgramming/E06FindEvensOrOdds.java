package T05FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class E06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s+");
        int lowerBound = Integer.parseInt(data[0]);
        int upperBound = Integer.parseInt(data[1]);
        List<Integer> numbers = new ArrayList<>();

        for (int i = lowerBound; i <= upperBound; i++) {
            numbers.add(i);
        }
        // even or odd
        String condition = scanner.nextLine();

        Predicate<Integer> filterNumbers;
        if (condition.equals("even")) {
            filterNumbers = e -> e % 2 == 0;
        } else {
            filterNumbers = e -> e % 2 != 0;
        }

        numbers.stream()
                .filter(filterNumbers)
                .forEach(e -> System.out.print(e + " "));
    }
}
