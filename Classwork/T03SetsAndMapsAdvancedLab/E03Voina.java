package T03SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class E03Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        for (int round = 0; round < 50; round++) {
            //check if someone has no cards
            if (firstPlayer.isEmpty()) {
                System.out.println("Second player win!");
                return;
            }
            if (secondPlayer.isEmpty()) {
                System.out.println("First player win!");
                return;
            }
            // get card form first player
            int firstPLayerCard = getTopmostValueFormPlayer(firstPlayer);
            // get card from second player
            int secondPlayerCard = getTopmostValueFormPlayer(secondPlayer);

            //remove the card from the 2 decks
            firstPlayer.remove(firstPLayerCard);
            secondPlayer.remove(secondPlayerCard);

            // compare the cards
            if (firstPLayerCard > secondPlayerCard) {
                firstPlayer.add(firstPLayerCard);
                firstPlayer.add(secondPlayerCard);
            } else if (firstPLayerCard < secondPlayerCard) {
                secondPlayer.add(secondPlayerCard);
                secondPlayer.add(firstPLayerCard);
            } else {
                firstPlayer.add(firstPLayerCard);
                secondPlayer.add(secondPlayerCard);
            }
        }
        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (firstPlayer.size() < secondPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }

    private static Integer getTopmostValueFormPlayer(LinkedHashSet<Integer> player) {
        return player.iterator().next();
    }
}
