package T03SetsAndMapsAdvancedExercises;


import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class E04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> occurrences = new TreeMap<>();

        String input = scanner.nextLine();
        char[] symbols = input.toCharArray();

        for (char symbol : symbols) {
            occurrences.putIfAbsent(symbol, 0);
            occurrences.put(symbol, occurrences.get(symbol) + 1);
        }
        occurrences.forEach((k, v) -> System.out.printf("%c: %d time/s%n", k, v));
    }
}
