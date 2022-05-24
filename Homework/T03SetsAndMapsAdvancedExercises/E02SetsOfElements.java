package T03SetsAndMapsAdvancedExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class E02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();

        String[] setsSizes = scanner.nextLine().split("\\s+");
        int firstSetSize = Integer.parseInt(setsSizes[0]);
        int secondSetSize = Integer.parseInt(setsSizes[1]);

        for (int i = 0; i < firstSetSize; i++) {
            firstSet.add(scanner.nextLine());
        }

        for (int i = 0; i < secondSetSize; i++) {
            secondSet.add(scanner.nextLine());
        }
        firstSet.retainAll(secondSet);
        firstSet.forEach(e -> System.out.print(e + " "));
    }
}
