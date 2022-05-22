package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        boolean result = checkIfEqual(firstMatrix, secondMatrix);

        if (result) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][];
        for (int i = 0; i < matrix.length; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i] = row;
        }
        return matrix;
    }

    private static boolean checkIfEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length) {
                return false;
            }
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]){
                    return false;
                }
            }
        }
        return true;
    }
}
