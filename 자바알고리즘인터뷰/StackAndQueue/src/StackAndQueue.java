import java.util.*;

public class StackAndQueue {
    public static void main(String[] args) {
        String testString = "dbacdcbc";
        int[] temperatures = { 23, 24, 25, 21, 19, 22, 26, 23 };
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int last = stack.pop();
                result[last] = i - last;
            }

            stack.push(i);
        }
        return result;
    }

    public static String removeDuplicateLetters(String s) {

        Map<Character, Integer> counter = new HashMap<>();
        Map<Character, Boolean> done = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>();

        for (char c: s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        for (char c: s.toCharArray()) {
            counter.put(c, counter.get(c) - 1);

            if (done.get(c) != null && done.get(c)) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > c && counter.get(stack.peek()) > 0) {
                done.put(stack.pop(), false);
            }

            stack.push(c);
            done.put(c, true);
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> checkTable = new HashMap<>();
        checkTable.put(')', '(');
        checkTable.put('}', '{');
        checkTable.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            if (!checkTable.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (stack.isEmpty() || !checkTable.get(s.charAt(i)).equals(stack.pop())) {
                return false;
            }
        }

        return stack.isEmpty();

    }
}
