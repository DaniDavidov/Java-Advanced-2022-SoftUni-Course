package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i] = row;
        }
        String[] coordinates = scanner.nextLine().split("\\s+");
        int r = Integer.parseInt(coordinates[0]);
        int c = Integer.parseInt(coordinates[1]);
        int wrongNumber = matrix[r][c];

        int[][] fixedMatrix = new int[rows][];
        for (int row = 0; row < matrix.length; row++) {
            fixedMatrix[row] = new int[matrix[row].length];
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongNumber) {
                    int sum = 0;
                    if (col + 1 < matrix[row].length && matrix[row][col+1] != wrongNumber) {
                        sum += matrix[row][col+1];
                    }
                    if (col - 1 >= 0 && matrix[row][col-1] != wrongNumber) {
                        sum += matrix[row][col-1];
                    }
                    if (row + 1 < matrix.length && matrix[row+1][col] != wrongNumber) {
                        sum += matrix[row+1][col];
                    }
                    if (row - 1 >= 0 && matrix[row-1][col] != wrongNumber) {
                        sum += matrix[row-1][col];
                    }
                    fixedMatrix[row][col] = sum;
                } else {
                    fixedMatrix[row][col] = matrix[row][col];
                }
            }
        }
        for (int row = 0; row < fixedMatrix.length; row++) {
            for (int col = 0; col < fixedMatrix[row].length; col++) {
                System.out.print(fixedMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
