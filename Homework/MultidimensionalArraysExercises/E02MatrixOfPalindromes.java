package MultidimensionalArraysExercises;

import java.util.Scanner;

public class E02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // generate a matrix of palindromes of 3 letters with r rows and c columns
        // Rows define the first and the last letter
        // Columns + rows define the middle letter

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);
        String[][] matrix = new String[rows][columns];
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        fillTheMatrix(matrix, alphabet);

        printTheMatrix(matrix);

    }

    private static void printTheMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillTheMatrix(String[][] matrix, String alphabet) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = String.valueOf(alphabet.charAt(row))
                        + alphabet.charAt(row + col) + alphabet.charAt(row);
            }
        }
    }
}
