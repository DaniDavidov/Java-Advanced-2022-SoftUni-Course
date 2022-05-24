package T03SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> emails = new LinkedHashMap<>();

        String name;
        while (!"stop".equals(name = scanner.nextLine())) {
            String email = scanner.nextLine();

            if (!email.contains(".us") && !email.contains(".uk") && !email.contains(".com")) {
                emails.put(name, email);
            }
        }
        emails.forEach((k, v) -> System.out.printf("%s -> %s%n", k, v));
    }
}
