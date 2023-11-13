import java.util.*;

public class ExamTest {

    public static void main(String[] args) {
        String s = "xa**j*z*e*a*q*ry*bioj*mzd**k**g*";
        System.out.println(removeStars(s));
        String testS = "tree";
        System.out.println(frequencySort(testS));
        System.out.println(frequencySort(testS));
        String s1 = "leetcode";
        String t = "practice";
        System.out.println(minSteps(s1, t));
    }

    public static int minSteps(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        Set<Character> sSet = new HashSet<>();
        int count = 0;
        for (char c: s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }

        for (char c: t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        for (char c: s.toCharArray()) {
            sSet.add(c);
        }

        for (char c: sSet) {
            int sCount = 0;
            int tCount = 0;

            sCount = sMap.get(c);
            if (tMap.get(c) != null) {
                tCount = tMap.get(c);
            }

            if (sCount >= tCount) {
                count += (sCount - tCount);
            }

        }

        return count;

    }

    public static String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for(char c: s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>(Comparator.comparing(freq::get).reversed());
        pq.addAll(freq.keySet());

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            char c = pq.poll();
            int n = freq.get(c);
            for (int i = 0; i < n; i++) {
                sb.append(c);
            }
        }


        return sb.toString();

    }

    public static String removeStars(String s) {

        Deque<Character> sDeq = new ArrayDeque<>();

        for (char c: s.toCharArray()) {
            if (c != '*')
                sDeq.push(c);
            else {
                sDeq.pop();
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!sDeq.isEmpty()){
            sb.append(sDeq.pollLast());
        }


        return sb.toString();
    }
}
