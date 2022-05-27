package T05FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputNumbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<String> numbers = inputNumbers.stream()
                .filter(e -> e % 2 == 0)
                .map(Object::toString)
                .collect(Collectors.toList());
        System.out.println(String.join(", ", numbers));

        List<String> sortedNumbers = numbers.stream().map(Integer::parseInt)
                .sorted(Integer::compareTo)
                .map(Object::toString)
                .collect(Collectors.toList());
        System.out.println(String.join(", ", sortedNumbers));
    }
}
