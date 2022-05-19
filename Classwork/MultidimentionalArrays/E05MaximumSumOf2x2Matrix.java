package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E05MaximumSumOf2x2Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);

        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i] = row;
        }
        int maxSum = Integer.MIN_VALUE;
        int[][] maxValueSubMatrix = new int[2][2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int[][] subMatrix = new int[2][2];
                int sum = 0;
                if (row + 1 < matrix.length && col + 1 < matrix[row].length) {
                    sum += matrix[row][col] + matrix[row][col+1] + matrix[row+1][col] + matrix[row+1][col+1];
                    subMatrix[0][0] = matrix[row][col];
                    subMatrix[0][1] = matrix[row][col+1];
                    subMatrix[1][0] = matrix[row+1][col];
                    subMatrix[1][1] = matrix[row+1][col+1];
                }
                if (sum > maxSum) {
                    maxSum = sum;
                    maxValueSubMatrix = subMatrix;
                }
            }
        }
        for (int row = 0; row < maxValueSubMatrix.length; row++) {
            for (int col = 0; col < maxValueSubMatrix[row].length; col++) {
                System.out.print(maxValueSubMatrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println(maxSum);
    }
}
