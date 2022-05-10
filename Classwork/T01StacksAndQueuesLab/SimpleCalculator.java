package T01StacksAndQueuesLab;

import java.util.*;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, input);

        while (stack.size() > 1) {
            int firstNum = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());
            int result = 0;

            if (operator.equals("+")) {
                result = firstNum + secondNum;
            } else if (operator.equals("-")) {
                result = firstNum - secondNum;
            }
            stack.push(String.valueOf(result));
        }
        int result = Integer.parseInt(stack.pop());
        System.out.println(result);
    }
}
