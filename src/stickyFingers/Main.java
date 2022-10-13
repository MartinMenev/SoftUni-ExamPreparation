package stickyFingers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String [][] townMatrix = new String[size][size];

        String[] commands = scanner.nextLine().split(",");

        int thiefRow = -1;
        int thiefCol = -1;

        for (int i = 0; i < size; i++) {
            townMatrix[i] = scanner.nextLine().split("\\s+");
            for (int j = 0; j < size; j++) {
                if (townMatrix[i][j].equals("D")) {
                    thiefRow = i;
                    thiefCol = j;
                }
            }
        }
        int totalStolenMoney = 0;
            boolean gotArrested = false;
        for (String command : commands) {
            switch (command) {
                case "up":
                    if (!isBound(thiefRow - 1, thiefCol, size)) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        townMatrix[thiefRow][thiefCol] = "+";
                        thiefRow--;
                        gotArrested = isCaught(townMatrix, thiefRow, thiefCol);
                        totalStolenMoney += isHouse(townMatrix, thiefRow, thiefCol);
                    }
                    break;
                case "down":
                    if (!isBound(thiefRow + 1, thiefCol, size)) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        townMatrix[thiefRow][thiefCol] = "+";
                        thiefRow++;
                        gotArrested = isCaught(townMatrix, thiefRow, thiefCol);
                        totalStolenMoney += isHouse(townMatrix, thiefRow, thiefCol);
                    }
                    break;
                case "left":
                    if (!isBound(thiefRow, thiefCol - 1, size)) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        townMatrix[thiefRow][thiefCol] = "+";
                        thiefCol--;
                        gotArrested = isCaught(townMatrix, thiefRow, thiefCol);
                        totalStolenMoney += isHouse(townMatrix, thiefRow, thiefCol);
                    }
                    break;
                case "right":
                    if (!isBound(thiefRow, thiefCol + 1, size)) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        townMatrix[thiefRow][thiefCol] = "+";
                        thiefCol++;
                        gotArrested = isCaught(townMatrix, thiefRow, thiefCol);
                        totalStolenMoney += isHouse(townMatrix, thiefRow, thiefCol);
                    }
                    break;
            }
            if (gotArrested) {
                break;
            }
        }
        if (gotArrested) {
            System.out.printf("You got caught with %d$, and you are going to jail.%n", totalStolenMoney);
        } else {
            townMatrix[thiefRow][thiefCol] = "D";
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalStolenMoney);
        }
        for (String[] matrix : townMatrix) {
            for (String s : matrix) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    private static boolean isCaught(String[][] matrix, int row, int col) {
        if (matrix[row][col].equals("P")) {
            matrix[row][col] = "#";
            return true;
        }
        return false;
    }

    private static int isHouse(String[][] matrix, int row, int col) {
        int stolenMoney = 0;
        if (matrix[row][col].equals("$")) {
            stolenMoney = row * col;
            System.out.printf("You successfully stole %d$.%n", stolenMoney);
            matrix[row][col] = "+";
        }
        return stolenMoney;
    }

    private static boolean isBound(int row, int col, int size) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }
}
