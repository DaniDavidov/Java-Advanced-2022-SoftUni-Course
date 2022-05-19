package MultidimentionalArrays;

import java.util.*;

public class E06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];
        for (int i = 0; i < size; i++) {
            String[] row = scanner.nextLine().split("\\s+");
            matrix[i] = row;
        }

        List<String> firstDiagonal = new ArrayList<>();
        List<String> secondDiagonal = new ArrayList<>();

        int row = 0;
        for (int col = 0; col < matrix[row].length; col++) {
            firstDiagonal.add(matrix[row][col]);

            if (row + 1 < matrix.length) {
                row++;
            }
        }

        for (int col = 0; col < matrix[row].length; col++) {
            secondDiagonal.add(matrix[row][col]);

            if (row - 1 >= 0) {
                row--;
            }
        }
        System.out.println(String.join(" ", firstDiagonal));
        System.out.println(String.join(" ", secondDiagonal));
    }
}
