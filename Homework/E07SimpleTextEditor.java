package T02StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> updates = new ArrayDeque<>();
        int commandsCount = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder("");
        updates.push(text.toString());

        for (int i = 0; i < commandsCount; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            int command = Integer.parseInt(data[0]);
            if (updates.size() != 0) {
                text = new StringBuilder(updates.peek());
            }

            switch (command) {
                case 1:
                    String str = data[1];
                    text.append(str);
                    updates.push(text.toString());

                    break;
                case 2:
                    int count = Integer.parseInt(data[1]);

                    if (text.length() != 0) {
                        text.delete(text.length() - count, text.length());
                    }
                    updates.push(text.toString());

                    break;
                case 3:
                    int index = Integer.parseInt(data[1]);

                    System.out.println(text.charAt(index-1));
                    break;
                case 4:
                    updates.pop();

                    break;

            }
        }
    }
}
