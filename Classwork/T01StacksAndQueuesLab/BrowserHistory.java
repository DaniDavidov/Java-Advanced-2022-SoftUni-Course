package T01StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        String currentUrl = "";

        String line = scanner.nextLine();
        while (!line.equals("Home")) {

            if (line.equals("back")) {
                if (stack.size() > 1) {
                    String removedUrl = stack.pop();
                    queue.push(removedUrl);
                    currentUrl = stack.peek();
                } else {
                    System.out.println("no previous URLs");
                    line = scanner.nextLine();
                    continue;
                }
            } else if (line.equals("forward")) {
                if (queue.size() < 1) {
                    System.out.println("no next URLs");
                    line = scanner.nextLine();
                    continue;
                } else {
                    currentUrl = queue.pop();
                    stack.push(currentUrl);
                }
            } else {
                stack.push(line);
                currentUrl = line;
            }
            System.out.println(currentUrl);

            line = scanner.nextLine();
        }
    }
}
