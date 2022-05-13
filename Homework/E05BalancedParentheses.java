package T02StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> openedBracketsStack = new ArrayDeque<>();
        boolean isBalanced = true;

        for (int index = 0; index < input.length(); index++) {
            char symbol = input.charAt(index);

            if (symbol == '{' || symbol == '[' || symbol == '(') {
                openedBracketsStack.push(symbol);
            } else if (symbol == '}' || symbol == ']' || symbol == ')') {

                if (openedBracketsStack.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char lastOpenedBracket = openedBracketsStack.pop();

                if (lastOpenedBracket == '{' && symbol == '}') {
                    isBalanced = true;
                } else if (lastOpenedBracket == '[' && symbol == ']') {
                    isBalanced = true;
                } else if (lastOpenedBracket == '(' && symbol == ')') {
                    isBalanced = true;
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
