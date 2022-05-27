package T05FunctionalProgramming;

import java.util.Scanner;
import java.util.function.BiFunction;

public class E02SumNumbersSecondTry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(", ");
        BiFunction<Integer, String, Integer> parseAndSum = (x, y) -> x + Integer.parseInt(y);

        System.out.println("Count = " + data.length);
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum = parseAndSum.apply(sum, data[i]);
        }
        System.out.println("Sum = " + sum);
    }
}
