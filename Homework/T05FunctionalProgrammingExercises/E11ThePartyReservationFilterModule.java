package T05FunctionalProgrammingExercises;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class E11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Predicate<String>> filters = new LinkedHashMap<>();
        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String line;
        while (!"Print".equals(line = scanner.nextLine())){
            String[] data = line.split(";");
            String command = data[0];
            String filter = data[1];
            String parameter = data[2];

            updateFiltersMap(filters, filter + parameter, command, filter, parameter);
        }
        updateGuestList(guests, filters);
        printGuests(guests);
    }

    private static void printGuests(List<String> guests) {
        System.out.println(String.join(" ", guests));
    }

    private static void updateGuestList(List<String> guests, Map<String, Predicate<String>> filters) {
        for (Map.Entry<String, Predicate<String>> predicate : filters.entrySet()) {
            List<String> guestsToBeRemoved = guests.stream().filter(predicate.getValue()).collect(Collectors.toList());
            guests.removeAll(guestsToBeRemoved);
        }
    }

    private static void updateFiltersMap(Map<String, Predicate<String>> filters,String name, String command, String filter, String parameter) {
        Predicate<String> predicate = createPredicate(filter, parameter);

        switch (command) {
            case "Add filter":
                filters.put(name, predicate);
                break;
            case "Remove filter":
                filters.remove(name);
                break;
        }
    }

    private static Predicate<String> createPredicate(String filter, String parameter) {
        Predicate<String> predicate;
        switch (filter) {
            case "Starts with":
                return predicate = e -> e.startsWith(parameter);
            case "Ends with":
                return predicate = e -> e.endsWith(parameter);
            case "Length":
                int length = Integer.parseInt(parameter);
                return predicate = e -> e.length() == length;
            case "Contains":
                return predicate = e -> e.contains(parameter);
            default:
                throw new IllegalStateException("Unexpected value: " + filter);
        }
    }
}
