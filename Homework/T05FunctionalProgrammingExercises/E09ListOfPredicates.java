package T05FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class E09ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<Integer> dividers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toSet());
        Predicate<Integer> checkDivisibility = e -> {
            for (Integer integer : dividers) {
                if (e % integer != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <= n; i++) {
            boolean isDivisible = checkDivisibility.test(i);
            if (isDivisible) {
                System.out.print(i + " ");
            }
        }
    }
}
