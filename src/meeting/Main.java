package meeting;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> malesStack = new ArrayDeque<>();
        Deque<Integer> femalesQueue = new ArrayDeque<>();

        Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(malesStack::push);
        Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(femalesQueue::offer);

        int matches = 0;

        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {
            int male = malesStack.peek();
            int female = femalesQueue.peek();

            if (male <= 0) {
                malesStack.pop();
                continue;
            } else if (male % 25 == 0) {
                malesStack.pop();
                if (!malesStack.isEmpty()) {
                    malesStack.pop();
                    continue;
                }
            }

            if (female <= 0) {
                femalesQueue.poll();
                continue;
            } else if (female % 25 == 0) {
                femalesQueue.poll();
                if (!femalesQueue.isEmpty()) {
                    femalesQueue.poll();
                    continue;
                }
            }

            if (male == female) {
                malesStack.pop();
                matches++;
            } else {
                malesStack.push(malesStack.pop() - 2);
            }
            femalesQueue.poll();
        }

        System.out.println("Matches: " + matches);
        System.out.print("Males left: ");
        if (malesStack.isEmpty()) {
            System.out.print("none");
        } else {
            List<String> temp = new ArrayList<>();
            for (Integer male : malesStack) {
                temp.add(""+ male);
            }
            System.out.print(String.join(", ", temp));
        }
        System.out.println();
        System.out.print("Females left: ");
        if (femalesQueue.isEmpty()) {
            System.out.print("none");
        } else {
            List<String> temp = new ArrayList<>();
            for (Integer female : femalesQueue) {
                temp.add(""+ female);
            }
            System.out.print(String.join(", ", temp));
        }
    }
}
