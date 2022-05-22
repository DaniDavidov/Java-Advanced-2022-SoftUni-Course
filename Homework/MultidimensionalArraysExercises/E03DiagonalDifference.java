package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class E03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // find the difference between the sums of the square matrix diagonals (absolute value)

        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];

        for (int i = 0; i < matrix.length; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i] = row;
        }

        int firstDiagonalSum = 0;
        int secondDiagonalSum = 0;

        int row = 0;
        for (int col = 0; col < matrix[row].length; col++) {
            firstDiagonalSum += matrix[row][col];

            if (row + 1 < matrix.length) {
                row++;
            }
        }

        for (int col = 0; col < matrix[row].length; col++) {
            secondDiagonalSum += matrix[row][col];

            if (row - 1 >= 0) {
                row--;
            }
        }
        int result = Math.abs(firstDiagonalSum - secondDiagonalSum);
        System.out.println(result);
    }
}
