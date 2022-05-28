package T05FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class E07FindTheSmallestIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Function<List<Integer>, Integer> findMin = e -> e.stream().mapToInt(a -> a).min().orElse(0);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int min = findMin.apply(numbers);
        int index = numbers.indexOf(min);
        if (index < numbers.size()-1) {
            for (int i = index; i < numbers.size(); i++) {
                if (numbers.get(i) == min) {
                    index = i;
                }
            }
        }
        System.out.println(index);
    }
}
