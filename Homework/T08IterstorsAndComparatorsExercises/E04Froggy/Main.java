package T08IterstorsAndComparatorsExercises.E04Froggy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Integer> numbers = Arrays.stream(input.split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());

        Lake lake = new Lake(numbers);
        int counter = 0;
        for (Integer integer : lake) {
            if (counter < lake.getNumbers().size() - 1) {
                System.out.print(integer + ", ");
            } else {
                System.out.print(integer);
            }
            counter++;
        }
    }
}
