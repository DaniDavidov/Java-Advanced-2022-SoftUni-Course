package T01StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> indexes = new ArrayDeque<>();
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            if (character == '(') {
                indexes.push(i);
            } else if (character == ')') {
                int startIndex = indexes.pop();
                String expression = input.substring(startIndex, i+1);
                System.out.println(expression);
            }
        }
    }
}
