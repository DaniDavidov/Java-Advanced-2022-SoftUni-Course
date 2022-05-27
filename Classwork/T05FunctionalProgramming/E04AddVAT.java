package T05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class E04AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] prices = scanner.nextLine().split(", ");
        UnaryOperator<Double> addVAT = e -> e * 1.2;
        Consumer<Double> printer = e -> System.out.printf("%.2f%n", e);

        System.out.println("Prices with VAT:");
        Arrays.stream(prices)
                .map(Double::parseDouble)
                .map(addVAT)
                .forEach(printer);
    }
}
