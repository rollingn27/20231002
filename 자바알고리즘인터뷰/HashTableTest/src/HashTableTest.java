import java.util.*;

public class HashTableTest {
    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        String s = "abcabcbbc";
        System.out.println(numJewelsInStones2(J, S));
        System.out.println(lengthOfLongestSubstring(s));

        int[] nums = { 1, 1, 1, 2, 2, 3, 4 };
        int k = 5;
        topKFrequent(nums, k);
        String[] participant = { "leo", "kiki", "eden" };
        String[] completion = { "eden", "kiki" };
        System.out.println(solution(participant, completion));

    }

    public static String solution(String[] participant, String[] completion) {

        Map<String, Integer> m = new HashMap<>();
        for (String part: participant) {
            m.put(part, m.getOrDefault(part, 0) + 1);
        }

        for (String com: completion) {
            int left = m.get(com);
            if (left == 1) {
                m.remove(com);
            } else {
                m.put(com, left - 1);
            }
        }

        return m.entrySet().iterator().next().getKey();
    }

    public static int[] topKFrequent2(int[] nums, int k) {
        int[] result = new int[k];
        int idx = 0;
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int num: nums) {
            numsMap.put(num, numsMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int element: numsMap.keySet()) {
            pq.add(new int[] { element, numsMap.get(element) });
        }

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[0];
        }

        return result;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        int idx = 0;
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int num: nums) {
            numsMap.put(num, numsMap.getOrDefault(num, 0) + 1);
        }

        Map<Integer, List<Integer>> buckets = new HashMap<>();
        for (int elem: numsMap.keySet()) {
            int freq = numsMap.get(elem);
            List<Integer> elems = buckets.getOrDefault(freq, new ArrayList<>());
            elems.add(elem);
            buckets.put(freq, elems);
        }

        for (int i = nums.length; i >= 1 && idx < k; i--) {
            if (buckets.get(i) != null) {
                for (int elem: buckets.get(i)) {
                    result[idx] = elem;
                    idx++;
                }
            }
        }

        return result;
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> used = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        int right = 0;

        for (char c: s.toCharArray()) {
            if (right < left) {
                right += left - right;
                continue;
            }

            if (used.containsKey(c) && left <= used.get(c)) {
                left = used.get(c) + 1;
            } else {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            used.put(c, right);
            right++;
        }

        return maxLength;
    }

    public static int numJewelsInStones2(String jewels, String stones) {
        int count = 0;
        Set<Character> j = new HashSet<>();
        for (char c: jewels.toCharArray()) {
            j.add(c);
        }

        for (char c: stones.toCharArray()) {
            if (j.contains(c))
                count++;
        }

        return count;
    }

    public static int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        Map<Character, Integer> s = new HashMap<>();
        for (char c: stones.toCharArray()) {
            s.put(c, s.getOrDefault(c, 0) + 1);
        }

        for (char c: jewels.toCharArray()) {
            if (s.containsKey(c))
                count += s.get(c);
        }

        return count;
    }
}
