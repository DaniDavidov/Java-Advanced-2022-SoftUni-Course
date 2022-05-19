package MultidimentionalArrays;

import java.util.Objects;
import java.util.Scanner;

public class E07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] chessTable = new String[8][8];
        for (int i = 0; i < chessTable.length; i++) {
            String[] row = scanner.nextLine().split("\\s+");
            chessTable[i] = row;
        }
        boolean queenFound = true;
        for (int row = 0; row < chessTable.length; row++) {
            for (int col = 0; col < chessTable[row].length; col++) {
                if (Objects.equals(chessTable[row][col], "q")) {
                    
                }
            }
        }
    }
}
