package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //read first matrix
        int[] dimentions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = dimentions[0];
        int cols = dimentions[1];

        int[][] firstMatrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            firstMatrix[i] = row;
        }

        // read second matrix
        dimentions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        rows = dimentions[0];
        cols = dimentions[1];



        int[][] secondMatrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            secondMatrix[i] = row;
        }

        boolean result = checkIfEqual(firstMatrix, secondMatrix);

        if (result) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
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
