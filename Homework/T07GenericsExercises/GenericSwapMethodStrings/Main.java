package T07GenericsExercises.GenericSwapMethodStrings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        // problem 3
        /*Elements<String> elements = new Elements<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            elements.add(line);
        }
        */

        // problem 4
        Elements<Integer> elements = new Elements<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            elements.add(num);
        }

        String[] data = scanner.nextLine().split("\\s+");
        int firstIndex = Integer.parseInt(data[0]);
        int secondIndex = Integer.parseInt(data[1]);

        elements.swap(firstIndex, secondIndex);
        System.out.println(elements.toString());

    }
}
