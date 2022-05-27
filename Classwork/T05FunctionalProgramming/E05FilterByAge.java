package T05FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class E05FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> namesByAge = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(", ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            namesByAge.put(name, age);
        }
        // older or younger
        String condition = scanner.nextLine();
        int ageLimit = Integer.parseInt(scanner.nextLine());

        // How to print the elements
        String format = scanner.nextLine();

        BiPredicate<Integer, Integer> filterAge;
        if (condition.equals("younger")) {
            filterAge = (personAge, age) -> personAge <= age;
        } else {
            filterAge = (personAge, age) -> personAge >= age;
        }

        Consumer<Map.Entry<String, Integer>> printConsumer;
        switch (format) {
            case "age":
                printConsumer = person -> System.out.println(person.getValue());
                break;
            case "name":
                printConsumer = person -> System.out.println(person.getKey());
                break;
            case "name age":
                printConsumer = person -> System.out.println(person.getKey() + " - " + person.getValue());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + format);
        }

        BiPredicate<Integer, Integer> finalFilterAge = filterAge;
        namesByAge.entrySet().stream()
                .filter(person -> finalFilterAge.test(person.getValue(), ageLimit))
                .forEach(printConsumer);
    }
}
