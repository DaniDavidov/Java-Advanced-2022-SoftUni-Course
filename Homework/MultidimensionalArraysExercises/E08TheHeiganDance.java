package MultidimensionalArraysExercises;

import java.util.Scanner;

public class E08TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double dmgByThePlayer = Double.parseDouble(scanner.nextLine());
        int playerHealth = 18500;
        double heiganHealth = 3000000;
        int playerRow = 7;
        int playerCol = 7;
        boolean cloudISActive = false;
        String spell = "";

        while (playerHealth > 0 && heiganHealth > 0) {
            heiganHealth -= dmgByThePlayer;

            if (cloudISActive) {
                playerHealth -= 3500;
                cloudISActive = false;
                spell = "Plague Cloud";
            }
            if (playerHealth < 0 || heiganHealth < 0) {
                break;
            }

            String[] data = scanner.nextLine().split("\\s+");
            spell = data[0];
            int dmgRow = Integer.parseInt(data[1]);
            int dmgCol = Integer.parseInt(data[2]);

            if (playerIsInTheAreaOfDmg(playerRow, playerCol, dmgRow, dmgCol)) {
                if (canMoveUp(playerRow, dmgRow)) {
                    playerRow--;
                } else if (canMoveRight(playerCol, dmgCol)) {
                    playerCol++;
                } else if (canMoveDown(playerRow, dmgRow)) {
                    playerRow++;
                } else if (canMoveLeft(playerCol, dmgCol)) {
                    playerCol--;
                } else {
                    switch (spell) {
                        case "Cloud":
                            playerHealth -= 3500;
                            cloudISActive = true;
                            spell = "Plague Cloud";
                            break;
                        case "Eruption":
                            playerHealth -= 6000;
                            break;
                    }
                }
            }
        }
        printResults(playerHealth, heiganHealth, playerRow, playerCol, spell);
    }

    private static void printResults(int playerHealth, double heiganHealth, int playerRow, int playerCol, String spell) {
        if (heiganHealth <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganHealth);
        }
        if (playerHealth <= 0) {
            System.out.println("Player: Killed by " + spell);
        } else {
            System.out.println("Player: " + playerHealth);
        }
        System.out.printf("Final position: %d, %d%n", playerRow, playerCol);
    }

    private static boolean canMoveUp(int playerRow, int dmgRow) {
        return indexIsValid(playerRow - 1) && playerRow < dmgRow;
    }

    private static boolean canMoveRight(int playerCol, int dmgCol) {
        return indexIsValid(playerCol + 1) && playerCol > dmgCol;
    }

    private static boolean canMoveDown(int playerRow, int dmgRow) {
        return indexIsValid(playerRow + 1) && playerRow > dmgRow;
    }

    private static boolean canMoveLeft(int playerCol, int dmgCol) {
        return indexIsValid(playerCol - 1) && playerCol < dmgCol;
    }

    private static boolean playerIsInTheAreaOfDmg(int playerRow, int playerCol, int dmgRow, int dmgCol) {
        return playerRow >= Math.max(0, dmgRow - 1) && playerRow <= Math.min(14, dmgRow + 1)
                && playerCol >= Math.max(0, dmgCol - 1) && playerCol <= Math.min(14, dmgCol + 1);
    }
    private static boolean indexIsValid(int i) {
        return i >= 0 && i < 15;
    }
}
