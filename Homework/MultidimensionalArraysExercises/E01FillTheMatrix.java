package MultidimensionalArraysExercises;

import java.util.Scanner;

public class E01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // There will be 2 method of filling a matrix
        // Depending on the input we will decide which one to proceed with

        String[] input = scanner.nextLine().split(", ");
        int sizeOfMatrix = Integer.parseInt(input[0]);
        String method = input[1];

        int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
        switch (method) {
            case "A":
                fillTheMatrixPatternA(matrix);

                break;
            case "B":
                fillTheMatrixPatternB(matrix);


                break;
        }

        printMatrix(matrix);
    }

    public static void fillTheMatrixPatternA(int[][] matrix) {
        int counter = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = counter;
                counter++;
            }
        }
    }

    public static void fillTheMatrixPatternB(int[][] matrix) {
        int counter = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 != 0) {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }
            } else {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
