package T01StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();

        String line = scanner.nextLine();
        while (!line.equals("print")) {

            if (line.equals("cancel")) {
                if (queue.size() < 1) {
                    System.out.println("Printer is on standby");
                } else {
                    String removed = queue.pollFirst();
                    System.out.println("Canceled " + removed);
                }
            } else {
                queue.offer(line);
            }

            line = scanner.nextLine();
        }
        for (String s : queue) {
            System.out.println(s);
        }
    }
}
