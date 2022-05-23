package T03SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> numbersMap = new LinkedHashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            numbersMap.putIfAbsent(numbers[i], 0);
            numbersMap.put(numbers[i], numbersMap.get(numbers[i]) + 1);
        }
        numbersMap.forEach((k, v) -> System.out.printf("%.1f -> %d%n", k, v));
    }
}
