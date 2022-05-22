package MultidimensionalArraysExercises;

import java.util.Scanner;



public class E05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix, scanner);

        String line = scanner.nextLine();
        while (!line.equals("END")) {
            boolean isValid = validateCommand(line, matrix);

            if (isValid) {
                String[] data = line.split("\\s+");
                int row1 = Integer.parseInt(data[1]);
                int col1 = Integer.parseInt(data[2]);
                int row2 = Integer.parseInt(data[3]);
                int col2 = Integer.parseInt(data[4]);

                swapElements(matrix, row1, col1, row2, col2);
                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }

            line = scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void swapElements(String[][] matrix, int row1, int col1, int row2, int col2) {
        String firstCoordinatesValue = matrix[row1][col1];
        String secondCoordinatesValue = matrix[row2][col2];

        //swap the elements
        matrix[row1][col1] = secondCoordinatesValue;
        matrix[row2][col2] = firstCoordinatesValue;
    }


    private static boolean validateCommand(String line, String[][] matrix) {
        // checking weather the input command is valid or not
        // how the input command looks like -> swap row1 col1 row2 col2

        String[] data = line.split("\\s+");
        int row1;
        int col1;
        int row2;
        int col2;

        if (data.length != 5) {
            return false;
        } else {
            row1 = Integer.parseInt(data[1]);
            col1 = Integer.parseInt(data[2]);
            row2 = Integer.parseInt(data[3]);
            col2 = Integer.parseInt(data[4]);
        }

        if (row1 < 0 || matrix.length <= row1) {
            return false;
        }

        if (col1 < 0 || matrix[row1].length <= col1) {
            return false;
        }

        if (row2 < 0 || matrix.length <= row2) {
            return false;
        }

        if (col2 < 0 || matrix[row1].length <= col2) {
            return false;
        }

        return true;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }
    }
}
