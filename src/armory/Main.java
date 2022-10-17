package armory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char [size][size];

        int officerRow = -1;
        int officerCol = -1;

        for (int i = 0; i < size; i++) {
            String nextLine = scanner.nextLine();
            if (nextLine.contains("A")) {
                officerRow = i;
                officerCol = nextLine.indexOf("A");
                matrix[officerRow][officerCol] = '-';
            }
            matrix[i] = nextLine.toCharArray();
        }

        int boughtBlades = 0;
        boolean isOutOfArmory = false;

        matrix[officerRow][officerCol] = '-';

        while (boughtBlades < 65) {
            String command = scanner.nextLine();

            switch (command) {
                case "up" -> {
                    officerRow--;
                    if (!isInBound(officerRow, officerCol, size)) {
                        isOutOfArmory = true;
                    } else {
                        if (Character.isDigit(matrix[officerRow][officerCol])) {
                            boughtBlades += Integer.parseInt("" + matrix[officerRow][officerCol]);
                            matrix[officerRow][officerCol] = '-';
                        }
                        if (matrix[officerRow][officerCol] == 'M') {
                            matrix[officerRow][officerCol] = '-';
                            for (int i = 0; i < size; i++) {
                                for (int j = 0; j < size; j++) {
                                    if (matrix[officerRow][officerCol] == 'M') {
                                        officerRow = i;
                                        officerCol = j;
                                        matrix[i][j] = '-';
                                    }
                                }
                            }
                        }
                    }
                }
                case "down" -> {
                    officerRow++;
                    if (!isInBound(officerRow, officerCol, size)) {
                        isOutOfArmory = true;
                    } else {
                        if (Character.isDigit(matrix[officerRow][officerCol])) {
                            boughtBlades += Integer.parseInt("" + matrix[officerRow][officerCol]);
                            matrix[officerRow][officerCol] = '-';
                        }
                        if (matrix[officerRow][officerCol] == 'M') {
                            matrix[officerRow][officerCol] = '-';
                            for (int i = 0; i < size; i++) {
                                for (int j = 0; j < size; j++) {
                                    if (matrix[i][j] == 'M') {
                                        officerRow = i;
                                        officerCol = j;
                                        matrix[i][j] = '-';
                                    }
                                }
                            }
                        }
                    }
                }
                case "left" -> {
                    officerCol--;
                    if (!isInBound(officerRow, officerCol, size)) {
                        isOutOfArmory = true;
                    } else {
                        if (Character.isDigit(matrix[officerRow][officerCol])) {
                            boughtBlades += Integer.parseInt("" + matrix[officerRow][officerCol]);
                            matrix[officerRow][officerCol] = '-';
                        }
                        if (matrix[officerRow][officerCol] == 'M') {
                            matrix[officerRow][officerCol] = '-';
                            for (int i = 0; i < size; i++) {
                                for (int j = 0; j < size; j++) {
                                    if (matrix[i][j] == 'M') {
                                        officerRow = i;
                                        officerCol = j;
                                        matrix[i][j] = '-';
                                    }
                                }
                            }
                        }
                    }
                }
                case "right" -> {
                    officerCol++;
                    if (!isInBound(officerRow, officerCol, size)) {
                        isOutOfArmory = true;
                    } else {
                        if (Character.isDigit(matrix[officerRow][officerCol])) {
                            boughtBlades += Integer.parseInt("" + matrix[officerRow][officerCol]);
                            matrix[officerRow][officerCol] = '-';
                        }
                        if (matrix[officerRow][officerCol] == 'M') {
                            matrix[officerRow][officerCol] = '-';
                            for (int i = 0; i < size; i++) {
                                for (int j = 0; j < size; j++) {
                                    if (matrix[i][j] == 'M') {
                                        officerRow = i;
                                        officerCol = j;
                                        matrix[i][j] = '-';
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (isOutOfArmory) {
                break;
            }
        }

        if(isOutOfArmory) {
            System.out.println("I do not need more swords!");
        } else {
            matrix[officerRow][officerCol] = 'A';
            System.out.println("Very nice swords, I will come back for more!");
        }

        System.out.printf("The king paid %d gold coins.%n", boughtBlades);

        printMatrix(matrix);
    }


    private static boolean isInBound(int officerRow, int officerCol, int size) {
        return officerRow >= 0 && officerRow < size && officerCol >= 0 && officerCol < size;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] rows : matrix) {
            for (char s : rows) {
                System.out.print(s);
            }
            System.out.println();
        }
    }
}
