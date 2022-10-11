package lootbox;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> boxQueue = new ArrayDeque<>();
        Deque<Integer> boxStack = new ArrayDeque<>();

        List<Integer> claimedItems = new ArrayList<>();

        int[] arr = Arrays
         .stream(scanner.nextLine().split(" "))
         .mapToInt(Integer::parseInt).toArray();

        for (int i : arr) {
            boxQueue.offer(i);
        }

        arr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int i : arr) {
            boxStack.push(i);
        }

        while (!boxQueue.isEmpty() && !boxStack.isEmpty()) {
            int sum = boxQueue.peek() + boxStack.peek();
            if (sum % 2 == 0) {
                boxStack.pop();
                boxQueue.poll();
                claimedItems.add(sum);
            } else {
                boxQueue.offer(boxStack.pop());
            }
        }
        if (boxQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }

        int sum = 0;
        for (Integer item : claimedItems) {
            sum+= item;
        }
        if (sum >= 100) {
            System.out.println("Your loot was epic! Value: " + sum);
        } else {
            System.out.println("Your loot was poor... Value: " + sum);
        }
    }
}
