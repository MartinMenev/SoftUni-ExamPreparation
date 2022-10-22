package energyDrinks;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalCaffeine = 0;

        Deque<Integer> caffeineStack = new ArrayDeque<>();
        Deque<Integer> energyDrinkQueue = new ArrayDeque<>();

        Arrays
                .stream(scanner.nextLine().trim().split(", "))
                .map(Integer::parseInt)
                .forEach(caffeineStack::push);
        Arrays
                .stream(scanner.nextLine().trim().split(", "))
                .map(Integer::parseInt)
                .forEach(energyDrinkQueue::offer);

        while (!caffeineStack.isEmpty() && !energyDrinkQueue.isEmpty()) {
            int caffeineMilligrams = caffeineStack.peek();
            int energyDrink = energyDrinkQueue.peek();
                int sum = caffeineMilligrams * energyDrink;
            if (sum <= (300 - totalCaffeine)) {
                totalCaffeine += sum;
                energyDrinkQueue.poll();
            } else {
                energyDrinkQueue.offer(energyDrinkQueue.poll());
                totalCaffeine -= 30;
                if (totalCaffeine < 0) {
                    totalCaffeine = 0;
                }
            }
            caffeineStack.pop();
        }
            if (energyDrinkQueue.isEmpty()) {
                System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
            } else {
                System.out.print("Drinks left: ");
                List<String> remainingDrinks = new ArrayList<>();
                for (Integer drink : energyDrinkQueue) {
                    remainingDrinks.add(""+drink);
                }
                System.out.print(String.join(", ", remainingDrinks));
                System.out.println();
            }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", totalCaffeine);
    }
}
