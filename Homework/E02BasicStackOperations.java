package T02StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class E02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        int[] instructions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] inputNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int elementsToPush = instructions[0];
        int elementsToPop = instructions[1];
        int keyNumber = instructions[2];

        for (int i = 0; i < elementsToPush; i++) {
            numbers.push(inputNumbers[i]);
        }
        for (int i = 0; i < elementsToPop; i++) {
            if (numbers.size() > 0) {
                numbers.pop();
            }
        }
        if (numbers.size() == 0) {
            System.out.println(0);
        } else if (numbers.contains(keyNumber)) {
            System.out.println("true");
        } else {
            int minNumber = Collections.min(numbers);
            System.out.println(minNumber);
        }
    }
}
