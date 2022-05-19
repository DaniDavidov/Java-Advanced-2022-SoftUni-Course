package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E02PositionOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean numberFound = false;
        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i] = row;
        }

        int wantedNumber = Integer.parseInt(scanner.nextLine());

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wantedNumber) {
                    numberFound = true;
                    System.out.println(row + " " + col);
                }
            }
        }
        if (!numberFound) {
            System.out.println("not found");
        }
    }
}
