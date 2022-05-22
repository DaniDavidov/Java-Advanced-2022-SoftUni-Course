package MultidimensionalArraysExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        List<List<Integer>> matrix = new ArrayList<>();

        fillMatrix(matrix, rows, cols);

        // Receiving input commands to manipulate the matrix
        String line = scanner.nextLine();
        while (!line.equals("Nuke it from orbit")) {
            String[] data = line.split("\\s+");
            int row = Integer.parseInt(data[0]);
            int col = Integer.parseInt(data[1]);
            int radius = Integer.parseInt(data[2]);

            destroyCells(matrix, row, col, radius);
            removeEmptyLines(matrix);


            line = scanner.nextLine();
        }
        printListMatrix(matrix);
    }

    private static void removeEmptyLines(List<List<Integer>> matrix) {
        matrix.removeIf(List::isEmpty);
    }

    private static void printListMatrix(List<List<Integer>> matrix) {
        matrix.forEach(s -> System.out.println(s.toString().replaceAll("[\\[\\],]", "")));
    }

    private static void destroyCells(List<List<Integer>> matrix, int row, int col, int radius) {
        // removing elements cross-like
        int startRow = Math.max(0, row - radius);
        int endRow = Math.min(matrix.size()-1, row + radius);
        for (int r = startRow; r <= endRow; r++) {
            if (matrix.get(r).size() > col && col >= 0 && r != row) {
                matrix.get(r).remove(col);
            }
            if (r == row) {
                int startCol = Math.max(0, col - radius);
                int endCol = Math.min(matrix.get(r).size()-1, col + radius);
                for (int c = endCol; c >= startCol; c--) {
                    matrix.get(row).remove(c);
                }
            }
        }

    }

    private static void fillMatrix(List<List<Integer>> matrix, int rows, int cols) {
        // filling the matrix with increasing integers starting from 1

        int integer = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(integer);
                integer++;
            }
        }
    }
}
