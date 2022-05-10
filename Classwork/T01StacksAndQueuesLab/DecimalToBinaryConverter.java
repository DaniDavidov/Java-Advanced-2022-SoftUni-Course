package T01StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> binaryRepresentation = new ArrayDeque<>();
        int input = Integer.parseInt(scanner.nextLine());

        if (input == 0) {
            System.out.println(0);
        } else {
            while (input > 0) {
                int leftover = input % 2;
                binaryRepresentation.push(leftover);
                input /= 2;
            }
            for (Integer integer : binaryRepresentation) {
                System.out.print(integer + "");
            }
        }
    }
}
