package MultidimentionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class E02PositionOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean numberFound = false;
        int[][] matrix = readMatrix(scanner);
        int wantedNumber = Integer.parseInt(scanner.nextLine());

        List<String> outputLines = findIndexes(matrix, wantedNumber);
        String output = formatOutput(outputLines);

        System.out.println(output);
    }

    private static String formatOutput(List<String> outputLines) {
        if (outputLines.isEmpty()) {
            return "not found";
        }
        return String.join(System.lineSeparator(), outputLines);
    }

    private static int[][] readMatrix(Scanner scanner) {
        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i] = row;
        }
        return matrix;
    }

    private static List<String> findIndexes(int[][] matrix, int wantedNumber) {
        List<String> outputLines = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wantedNumber) {
                    outputLines.add(row + " " + col);
                }
            }
        }
        return outputLines;
    }
}
