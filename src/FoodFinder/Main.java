package FoodFinder;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> wordsList = List.of("pear","flour","pork", "olive");
        Deque<Character> vowelsQueue = new ArrayDeque<>();
        Deque<Character> consStack = new ArrayDeque<>();
        Set<Character> matchList = new HashSet<>();

        String[] line = scanner.nextLine().split("\\s+");
        for (String s : line) {
            vowelsQueue.offer(s.charAt(0));
        }
        line = scanner.nextLine().split("\\s+");
        for (String s : line) {
            consStack.push(s.charAt(0));
        }

        while (!consStack.isEmpty()) {
            Character currentVowel = vowelsQueue.poll();
            Character currentCons = consStack.pop();
            for (String word : wordsList) {
                if (word.contains(""+ currentVowel)) {
                    matchList.add(currentVowel);
                }
                if (word.contains(""+ currentCons)) {
                    matchList.add(currentCons);
                }
            }
            vowelsQueue.offer(currentVowel);
        }
        Set<String> foundWords = new LinkedHashSet<>();
        int wordCount = 0;
        for (String word : wordsList) {
            boolean foundLetter = true;
           for (char s : word.toCharArray()) {
               if (!matchList.contains(s)) {
                   foundLetter = false;
                   break;
               }
           }
           if (foundLetter) {
               wordCount++;
               foundWords.add(word);
           }
        }

        System.out.println("Words found: " + wordCount);
        for (String foundWord : foundWords) {
            System.out.println(foundWord);
        }
    }
}
