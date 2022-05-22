package MultidimensionalArraysExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(command);
        int degrees = 0;
        if (matcher.find()) {
            degrees = Integer.parseInt(matcher.group());
        }

        // getting the string that will consist in the matrix
        List<String> strings = new ArrayList<>();
        String line = scanner.nextLine();
        while (!line.equals("END")) {
            strings.add(line);

            line = scanner.nextLine();
        }

        // getting the element with maximum length
        int maxLength = strings.stream()
                .mapToInt(String::length)
                .max().orElse(0);

        // appending spaces to the elements with shorter length
        appendSpaces(strings, maxLength);

        // filling the matrix
        char[][] matrix = new char[strings.size()][maxLength];
        fillMatrix(matrix, strings);

        // creating a copy of the initial matrix
        char[][] initialMatrix = matrix;

        // calculating how many times we will have to rotate the matrix
        int rotations = degrees / 90;
        while (rotations > 4) {
            rotations -= 4;
        }

        if (rotations == 4) {
            printMatrix(initialMatrix);
        } else {
            for (int i = 0; i < rotations; i++) {
                matrix = rotate1time(matrix);
            }
            printMatrix(matrix);
        }

    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }
    }

    private static char[][] rotate1time(char[][] matrix) {
        char[][] newMatrix = new char[matrix[0].length][matrix.length];

        int c = 0;
        for (int i = 0; i < newMatrix.length; i++) {
            int r = matrix.length - 1;

            for (int j = 0; j < newMatrix[i].length; j++) {
                newMatrix[i][j] = matrix[r][c];
                r--;
            }
            c++;
        }
        return newMatrix;
    }


    private static void fillMatrix(char[][] matrix, List<String> strings) {
        for (int i = 0; i < matrix.length; i++) {
            char[] row = strings.get(i).toCharArray();
            matrix[i] = row;
        }
    }

    private static void appendSpaces(List<String> strings, int maxLength) {
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() < maxLength) {
                for (int j = strings.get(i).length(); j < maxLength; j++) {
                    strings.set(i, strings.get(i) + " ");
                }
            }
        }
    }
}
