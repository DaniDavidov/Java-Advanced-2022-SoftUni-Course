package T03SetsAndMapsAdvancedExercises;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phonebook = new HashMap<>();

        String line = scanner.nextLine();
        while (!line.equals("search")) {
            String[] data = line.split("-");
            String name = data[0];
            String number = data[1];

            phonebook.put(name, number);

            line = scanner.nextLine();
        }

        String user;
        while (!"stop".equals(user = scanner.nextLine())) {
            if (phonebook.containsKey(user)) {
                System.out.println(user + " -> " + phonebook.get(user));
            } else {
                System.out.printf("Contact %s does not exist.%n", user);
            }
        }
    }
}
