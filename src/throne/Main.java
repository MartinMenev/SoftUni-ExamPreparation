package throne;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        char[][] city = new char[size][];
            int parisRow = -1;
            int parisCol = -1;
            int matrixWidth = -1;

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            if (line.contains("P")) {
                parisRow = i;
                parisCol = line.indexOf("P");
                matrixWidth = line.length();
            }
            city[i] = line.toCharArray();
        }
        boolean runAway = false;
        city[parisRow][parisCol] = '-';

        while (energy > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            int spartanRow = Integer.parseInt(input[1]);
            int spartanCol = Integer.parseInt(input[2]);
            energy -= 1;
            boolean isOutofCity = false;
            if (command.equals("up") && (parisRow - 1 >= 0)) {
                parisRow--;
            } else if (command.equals("down") && (parisRow + 1 < size)) {
                parisRow++;
            } else if (command.equals("left") && (parisCol - 1 >= 0)) {
                parisCol--;
            } else if (command.equals("right") && (parisCol + 1 < matrixWidth)) {
                parisCol++;
            } else {
                isOutofCity = true;
            }

            city[spartanRow][spartanCol] = 'S';

            if (!isOutofCity && city[parisRow][parisCol] == 'S') {
                energy -= 2;
                city[parisRow][parisCol] = '-';


            } else if (!isOutofCity && city[parisRow][parisCol] == 'H') {
                city[parisRow][parisCol] = '-';
                runAway = true;
                break;
            }
        }

        if (runAway) {
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
        } else {
            city[parisRow][parisCol] = 'X';
            System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
        }

        for (char[] rows : city) {
            for (char s : rows) {
                System.out.print(s);
            }
            System.out.println();
        }
    }
}
