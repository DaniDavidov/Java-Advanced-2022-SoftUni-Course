package T03SetsAndMapsAdvancedExercises;

import java.util.*;
import java.util.stream.Collectors;

public class E07HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> usersByDecks = new LinkedHashMap<>();

        String line;
        while (!"JOKER".equals(line = scanner.nextLine())) {
            String[] data = line.split(": ");
            String name = data[0];
            String[] deck = data[1].split(", ");

            usersByDecks.putIfAbsent(name, new LinkedHashSet<>());
            usersByDecks.get(name).addAll(List.of(deck));

        }
        printStatistics(usersByDecks);

    }

    private static void printStatistics (Map<String, Set<String>> usersByDecks) {
        for (Map.Entry<String, Set<String>> entry : usersByDecks.entrySet()) {
            int sum = calculateCardsValue(entry.getValue());
            System.out.println(entry.getKey() + ": " + sum);
        }

    }

    private static int calculateCardsValue(Set<String> deck) {
        int sum = 0;
        for (String card : deck) {
            int index = card.length() % 2;
            String strPower = card.substring(0, index + 1);
            String strType = card.substring(index + 1);
            int power = 0;
            int type = 0;

            if (Character.isDigit(strPower.charAt(0))) {
                power = Integer.parseInt(strPower);
            } else {
                switch (strPower) {
                    case "J":
                        power = 11;
                        break;
                    case "Q":
                        power = 12;
                        break;
                    case "K":
                        power = 13;
                        break;
                    case "A":
                        power = 14;
                        break;
                }
            }

            switch (strType) {
                case "S":
                    type = 4;
                    break;
                case "H":
                    type = 3;
                    break;
                case "D":
                    type = 2;
                    break;
                case "C":
                    type = 1;
                    break;
            }
            sum += power * type;
        }
        return sum;
    }
}
