package chololateTime;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Double> milkValueQueue = new ArrayDeque<>();
        Deque<Double> cocoaPowderStack = new ArrayDeque<>();

        Map<String, Integer> chocolateMap = new TreeMap<>();
        chocolateMap.put("Milk Chocolate", 0);
        chocolateMap.put("Dark Chocolate", 0);
        chocolateMap.put("Baking Chocolate", 0);

        String[] line = scanner.nextLine().split("\\s+");
        for (String value : line) {
            milkValueQueue.offer(Double.parseDouble(value));
        }
        line = scanner.nextLine().split("\\s+");
        for (String value : line) {
            cocoaPowderStack.push(Double.parseDouble(value));
        }

        while (!cocoaPowderStack.isEmpty() && !milkValueQueue.isEmpty()) {
            double cocoaPercentage = (cocoaPowderStack.peek() / (cocoaPowderStack.peek() + milkValueQueue.peek())) * 100;

            switch ((int) Math.round(cocoaPercentage)) {
                case 30 -> {
                    chocolateMap.put("Milk Chocolate", chocolateMap.get("Milk Chocolate") + 1);
                    removeValues(cocoaPowderStack, milkValueQueue);
                }
                case 50 -> {
                    chocolateMap.put("Dark Chocolate", chocolateMap.get("Dark Chocolate") + 1);
                    removeValues(cocoaPowderStack, milkValueQueue);
                }
                case 100 -> {
                    chocolateMap.put("Baking Chocolate", chocolateMap.get("Baking Chocolate") + 1);
                    removeValues(cocoaPowderStack, milkValueQueue);
                }
                default -> {
                    cocoaPowderStack.pop();
                    milkValueQueue.offer(milkValueQueue.poll() + 10);
                }
            }
        }
        boolean allChocolateTypes = true;

        for (Map.Entry <String, Integer> chocolate : chocolateMap.entrySet()) {
            if (chocolate.getValue() == 0) {
                allChocolateTypes = false;
                break;
            }
        }

        if (allChocolateTypes) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        for (var chocolate : chocolateMap.entrySet()) {
            if (chocolate.getValue() > 0) {
                System.out.printf("# %s --> %d%n", chocolate.getKey(), chocolate.getValue());
            }
        }
    }

    private static void removeValues(Deque<Double> cocoaPowderStack, Deque<Double> milkValueQueue) {
        cocoaPowderStack.pop();
        milkValueQueue.poll();
    }
}
