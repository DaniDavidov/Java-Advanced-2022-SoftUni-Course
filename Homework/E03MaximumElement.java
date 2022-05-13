package T02StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class E03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        int commandsCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < commandsCount; i++) {
            int[] data = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            int commandNum = data[0];

            switch (commandNum) {
                case 1:
                    int element = data[1];
                    numbers.push(element);
                    break;
                case 2:
                    numbers.pop();
                    break;
                case 3:
                    int maxNumber = Collections.max(numbers);
                    System.out.println(maxNumber);
                    break;
            }
        }
    }
}
