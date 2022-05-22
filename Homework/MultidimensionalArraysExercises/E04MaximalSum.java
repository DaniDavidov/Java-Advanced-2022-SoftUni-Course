package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class E04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i] = row;
        }

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int startIndexRow = -1;
        int startIndexCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row + 2 < matrix.length && col + 2 < matrix[row].length) {
                    sum = matrix[row][col] + matrix[row][col+1] + matrix[row][col+2]
                            + matrix[row+1][col] + matrix[row+1][col+1] + matrix[row+1][col+2]
                            + matrix[row+2][col] + matrix[row+2][col+1] + matrix[row+2][col+2];
                    if (sum > maxSum) {
                        maxSum = sum;
                        startIndexRow = row;
                        startIndexCol = col;
                    }
                }
            }
        }

        int[][] bestMatrix = fillBestMatrix(matrix, startIndexRow, startIndexCol);


        System.out.println("Sum = " + maxSum);
        for (int row = 0; row < bestMatrix.length; row++) {
            for (int col = 0; col < bestMatrix[row].length; col++) {
                System.out.print(bestMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] fillBestMatrix(int[][] matrix, int startIndexRow, int startIndexCol) {
        int[][] bestMatrix = new int[3][3];
        for (int row = 0; row < bestMatrix.length; row++) {
            for (int col = 0; col < bestMatrix[row].length; col++) {
                bestMatrix[row][col] = bestMatrix[startIndexRow + row][startIndexCol + col];
            }
        }
        return bestMatrix;
    }
}
