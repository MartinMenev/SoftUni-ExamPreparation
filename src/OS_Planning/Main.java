package OS_Planning;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //tasks
        int[] arr = getArr(scanner, ", ");
        Deque<Integer> taskStack = new ArrayDeque<>();
        for (int task : arr) {
            taskStack.push(task);
        }
        //threads
        Deque<Integer> threadsQueue = new ArrayDeque<>();
        for (int thread : getArr(scanner, "\\s+")) {
            threadsQueue.offer(thread);
        }

        int taskToKill = Integer.parseInt(scanner.nextLine());

        while (taskStack.peek() != taskToKill) {

            if (threadsQueue.peek() >= taskStack.peek() ) {
                taskStack.pop();
                threadsQueue.poll();
            } else {
                threadsQueue.poll();
            }
        }
        System.out.printf("Thread with value %d killed task %d%n", threadsQueue.peek(), taskToKill);
        for (Integer thread : threadsQueue) {
            System.out.print(thread + " ");
        }
    }


    private static int[] getArr(Scanner scanner, String delimiter) {
        return Arrays
         .stream(scanner.nextLine().split(delimiter))
         .mapToInt(Integer::parseInt).toArray();
    }
}
