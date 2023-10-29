import java.util.*;

public class StackAndQueue {
    public static void main(String[] args) {
        String test = "aasdqwadasdasdabsdbbdd";

        System.out.println(removeDuplicatedLetters2(test));
    }

    public static String removeDuplicatedLetters2(String s) {

        Map<Character, Integer> counter = new HashMap<>();
        Map<Character, Boolean> seen = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>();

        for (char c: s.toCharArray())
//            counter.put(c, counter.get(c) == null ? 1 : counter.get(c) + 1);
            counter.put(c, counter.getOrDefault(c, 0) + 1);

        for (char c: s.toCharArray()) {
            counter.put(c, counter.get(c) - 1);

            if (seen.get(c) != null && seen.get(c) == true)
                continue;

            while (!stack.isEmpty() && stack.peek() > c && counter.get(stack.peek()) > 0)
                seen.put(stack.pop(), false);
            stack.push(c);
            seen.put(c, true);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pollLast());
        return sb.toString();
    }

    public static String removeDuplicateLetters(String s) {
        for (char c: toSortedSet(s)) {
            String suffix = s.substring(s.indexOf(c));
            if (toSortedSet(s).equals(toSortedSet(suffix))) {
                return c + removeDuplicateLetters(suffix.replace(String.valueOf(c), ""));
            }
        }

        return "";
    }

    public static Set<Character> toSortedSet(String s) {
        Set<Character> set = new TreeSet<>(new Comparator<Character> () {
            @Override
            public int compare(Character o1, Character o2) {
                if (o1 == o2) {
                    return 0;
                } else if (o1 > o2) {
                    return 1;
                } else
                    return -1;
            }
        });

        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        return set;
    }


    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        Map<Character, Character> table = new HashMap<>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};

        for (int i = 0; i < s.length(); i++) {
            if (!table.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (stack.isEmpty() || table.get(s.charAt(i)) != stack.pop()) {
                return false;
            }
        }
        return stack.size() == 0;
    }
}
