package rallyRacing;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String carNumber = scanner.nextLine();

        int carRow = 0;
        int carCol = 0;

        int distance = 0;

        String [][] route = new String [size][size];

        for (int i = 0; i < size; i++) {
            route[i] = scanner.nextLine().split(" ");
        }

        String command = scanner.nextLine();

        boolean hasFinished = false;

        while (!command.equals("End")) {
            distance += 10;

            if (command.equals("up")) {
                carRow--;
            } else if (command.equals("down")) {
                carRow++;
            } else if (command.equals("left")) {
                carCol--;
            } else if (command.equals("right")) {
                carCol++;
            }

            if (route[carRow][carCol].equals("T")) {
                distance += 20;
                route[carRow][carCol] = ".";
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (route[i][j].equals("T")) {
                            carRow = i;
                            carCol = j;
                            route[i][j] = ".";
                        }
                    }
                }
            } else if (route[carRow][carCol].equals("F")) {
                hasFinished = true;
                break;
            }
            command = scanner.nextLine();
        }

        if (hasFinished) {
            System.out.printf("Racing car %s finished the stage!%n", carNumber);
        } else {
            System.out.printf("Racing car %s DNF.%n", carNumber);
        }
        System.out.printf("Distance covered %d km.%n", distance);

        route[carRow][carCol] = "C";

        for (String[] rows : route) {
            for (String s : rows) {
                System.out.print(s);
            }
            System.out.println();
        }
    }
}
