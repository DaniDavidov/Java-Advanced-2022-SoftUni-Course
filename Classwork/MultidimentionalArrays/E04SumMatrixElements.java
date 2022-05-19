package MultidimentionalArrays;

import java.util.Scanner;

public class E04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sizes = scanner.nextLine();
        int[][] matrix = matrixCreator(sizes);
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);

        for (int i = 0; i < matrix.length; i++) {
            String input = scanner.nextLine();
            String[] row = input.split(", ");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }
        int sum = matrixCalculator(matrix);
        System.out.println(sum);
    }

    private static int matrixCalculator(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }

    private static int[][] matrixCreator(String sizes) {
        String[] matrixSize = sizes.split(", ");
        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);

        return new int[rows][cols];
    }
}
