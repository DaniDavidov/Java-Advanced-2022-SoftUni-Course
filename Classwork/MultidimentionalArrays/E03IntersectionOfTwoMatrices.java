package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class E03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String[][] firstMatrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] row = scanner.nextLine().split("\\s+");
            firstMatrix[i] = row;
        }

        String[][] secondMatrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] row = scanner.nextLine().split("\\s+");
            secondMatrix[i] = row;
        }

        String[][] intersectedMatrix = new String[rows][cols];
        for (int row = 0; row < intersectedMatrix.length; row++) {
            for (int col = 0; col < intersectedMatrix[row].length; col++) {
                if (Objects.equals(firstMatrix[row][col], secondMatrix[row][col])) {
                    intersectedMatrix[row][col] = firstMatrix[row][col];
                } else {
                    intersectedMatrix[row][col] = "*";
                }
            }
        }

        for (int row = 0; row < intersectedMatrix.length; row++) {
            for (int col = 0; col < intersectedMatrix[row].length; col++) {
                System.out.print(intersectedMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
