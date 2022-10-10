package Re_Volt;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int nCommands = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String [size][size];
        int playerRow = -1;
        int playerCol = -1;
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("f")) {
                    playerRow = i;
                    playerCol = j;
                }
            }
        }

        String finish = "F";
        String bonus = "B";
        String trap = "T";
        boolean isWon = false;
        matrix[playerRow][playerCol] = "-";

        while (nCommands-- > 0) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    int previousStep = playerRow;
                    playerRow--;

                    if (playerRow < 0) {
                        playerRow = matrix.length - 1;
                    }

                    if (matrix[playerRow][playerCol].equals(bonus)) {
                            playerRow--;
                        if (playerRow < 0) {
                            playerRow = matrix.length - 1;
                        }
                    } else if (matrix[playerRow][playerCol].equals(trap)) {
                        playerRow = previousStep;
                    }
                    break;

                case "down":
                    previousStep = playerRow;
                    playerRow ++;

                    if (playerRow == matrix.length) {
                        playerRow = 0;
                    }

                    if (matrix[playerRow][playerCol].equals(bonus)) {
                        playerRow++;
                        if (playerRow == matrix.length) {
                            playerRow = 0;
                        }
                    } else if (matrix[playerRow][playerCol].equals(trap)) {
                        playerRow = previousStep;
                    }
                    break;

                case "right":
                    previousStep = playerCol;
                    playerCol ++;

                    if (playerCol == matrix.length) {
                        playerCol = 0;
                    }

                    if (matrix[playerRow][playerCol].equals(bonus)) {
                        playerCol++;
                        if (playerCol == matrix.length) {
                            playerCol = 0;
                        }
                    } else if (matrix[playerRow][playerCol].equals(trap)) {
                        playerCol = previousStep;
                    }
                    break;

                case "left":
                    previousStep = playerCol;
                    playerCol --;

                    if (playerCol < 0) {
                        playerCol = matrix.length - 1;
                    }

                    if (matrix[playerRow][playerCol].equals(bonus)) {
                        playerCol--;
                        if (playerCol < 0) {
                            playerCol = matrix.length - 1;
                        }
                    } else if (matrix[playerRow][playerCol].equals(trap)) {
                        playerCol = previousStep;
                    }
                    break;
            }

            if (matrix[playerRow][playerCol].equals(finish)) {
                isWon = true;
                break;
            }
        }

        System.out.println(isWon
                ? "Player won!"
                : "Player lost!");

        matrix[playerRow][playerCol] = "f";

        for (String[] rows : matrix) {
            for (String s : rows) {
                System.out.print(s);
            }
            System.out.println();
        }
    }
}
