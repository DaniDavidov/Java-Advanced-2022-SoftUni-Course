package T05FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class E02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        Function<String, Integer> parser = Integer::parseInt;

        List<Integer> numbers = Arrays.stream(input)
                .map(parser)
                .collect(Collectors.toList());
        System.out.println("Count = " + numbers.size());

        int sum = numbers.stream().mapToInt(e -> e).sum();
        System.out.println("Sum = " + sum);
    }
}
