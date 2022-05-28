package T05FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class E10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String line;
        while (!"Party!".equals(line = scanner.nextLine())) {
            String[] data = line.split("\\s+");
            String command = data[0];
            String condition = data[1];
            String parameter = data[2];

            Predicate<String> predicate = getPredicate(condition, parameter);

            updateGuestList(predicate, guests, command);

        }
        printList(guests);
    }

    private static void printList(List<String> guests) {
        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            List<String> sortedList = guests.stream().sorted().collect(Collectors.toList());
            System.out.println(String.join(", ", sortedList) + " are going to the party!");
        }
    }

    private static void updateGuestList(Predicate<String> predicate, List<String> guests, String command) {
        switch (command) {
            case "Double":
                List<String> peopleToBeAdded = guests.stream().filter(predicate).collect(Collectors.toList());
                guests.addAll(peopleToBeAdded);
                break;
            case "Remove":
                List<String> peopleToBeRemoved = guests.stream().filter(predicate).collect(Collectors.toList());
                guests.removeAll(peopleToBeRemoved);
        }
    }

    private static Predicate<String> getPredicate(String condition, String parameter) {
        Predicate<String> predicate;
        switch (condition) {
            case "StartsWith":
                return predicate = e -> e.startsWith(parameter);
            case "EndsWith":
                return predicate = e -> e.endsWith(parameter);
            case "Length":
                int length = Integer.parseInt(parameter);
                return predicate = e -> e.length() == length;
            default:
                throw new IllegalStateException("Unexpected value: " + condition);
        }
    }
}
