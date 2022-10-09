package PawnWars;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] chess = new String[8][8];
        for (int i = 0; i < chess.length; i++) {
            chess[i] = scanner.nextLine().split("");
        }
        int rowB = -1;
        int colB = -1;
        int rowW = -1;
        int colW = -1;

        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < 8; j++) {
                if (chess[i][j].equals("b")) {
                    rowB = i;
                    colB = j;
                }
                if (chess[i][j].equals("w")) {
                    rowW = i;
                    colW = j;
                }
            }
        }

        while (isBound(rowW - 1) && isBound(rowB + 1)) {
            if (colW > colB) {
               if (chess[rowW -1][colW - 1].equals("b")) {
                   System.out.println("Game over! White capture on " + findCoordinates(rowW-1, colW-1) + ".");
                   return;
               }
            } else {
                if (chess[rowW - 1][colW + 1].equals("b")) {
                    System.out.println("Game over! White capture on " + findCoordinates(rowW-1, colW+1) + ".");
                    return;
                }
            }
            chess[rowW][colW] = "-";
            rowW--;
            chess[rowW][colW] = "w";

            if (colW > colB) {
                if (chess[rowB + 1][colB + 1].equals("w")) {
                    System.out.println("Game over! Black capture on " + findCoordinates(rowB+1, colB+1) + ".");
                    return;
                }
            } else {
                if (chess[rowB + 1][colB - 1].equals("w")) {
                    System.out.println("Game over! Black capture on " + findCoordinates(rowB+1, colB-1) + ".");
                    return;
                }
            }
            chess[rowB][colB] = "-";
            rowB++;
            chess[rowB][colB] = "b";
        }

        if (rowB == 7) {
            System.out.printf("Game over! Black pawn is promoted to a queen at %s.", findCoordinates(rowB, colB));
        } else {
            System.out.printf("Game over! White pawn is promoted to a queen at %s.", findCoordinates(rowW, colW));
        }
    }

    private static String findCoordinates(int row, int col) {
        int rowC = 8 - row;
        char colC = (char) (col + 97);
        return ""+colC + rowC;
    }

    private static boolean isBound(int index) {
        return index >= 0 && index < 8;
    }
}
