import java.util.*;
import java.util.stream.Collectors;

public class GraphTest {
    public static void main(String[] args) {
//        char[][] grid = {
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'0', '0', '1', '1', '1'}};
//
//        int[] nums = { 1, 2, 3, 4};
//        System.out.println(combine(5, 3));
        int[] candidates = { 2, 3, 5, 8, 1 };
        int target = 9;
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK", "ICN"));
        tickets.add(Arrays.asList("JFK", "ATL"));
        tickets.add(Arrays.asList("ICN", "ATL"));
        tickets.add(Arrays.asList("ATL", "ICN"));
        tickets.add(Arrays.asList("ATL", "JFK"));
        System.out.println(letterCombinations("25"));
        System.out.println(findItinerary2(tickets));
    }

    public static boolean dfs8(Map<Integer, List<Integer>> finishToTakeMap, Integer finish, List<Integer> takes) {
        if (takes.contains(finish)){
            return false;
        }

        if (finishToTakeMap.containsKey(finish)) {
            takes.add(finish);
            for(Integer take: finishToTakeMap.get(finish)) {
                if (!dfs8(finishToTakeMap, take, takes))
                    return false;
            }
            takes.remove(finish);
        }

        return true;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> finishToTakeMap = new HashMap<>();
        for (int[] pre: prerequisites) {
            finishToTakeMap.putIfAbsent(pre[0], new ArrayList<>());
            finishToTakeMap.get(pre[0]).add(pre[1]);
        }

        List<Integer> takes = new ArrayList<>();
        for (Integer finish: finishToTakeMap.keySet()) {
            if (!dfs8(finishToTakeMap, finish, takes)) {
                return false;
            }
        }
        return true;
    }

    public static void dfs7(List<String> results, Map<String, PriorityQueue<String>> fromToMap, String from) {
        while (fromToMap.containsKey(from) && !fromToMap.get(from).isEmpty()) {
            dfs7(results, fromToMap, fromToMap.get(from).poll());
        }

        results.add(0, from);
    }

    public static List<String> findItinerary2(List<List<String>> tickets) {

        Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();

        for (List<String> ticket: tickets) {
            fromToMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            fromToMap.get(ticket.get(0)).add(ticket.get(1));
        }

        List<String> results = new LinkedList<>();
        Deque<String> stack = new ArrayDeque<>();

        stack.push("JFK");
        while (!stack.isEmpty()) {
            while (fromToMap.containsKey(stack.peek()) && !fromToMap.get(stack.peek()).isEmpty()) {
                stack.push(fromToMap.get(stack.peek()).poll());
            }

            results.add(0, stack.pop());
        }

        return results;
    }
    public static List<String> findItinerary(List<List<String>> tickets) {
        List<String> results = new LinkedList<>();
        Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();

        for (List<String> ticket: tickets) {
            fromToMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            fromToMap.get(ticket.get(0)).add(ticket.get(1));
        }

        dfs7(results, fromToMap, "JFK");
        return results;
    }

    public static void dfs6(List<List<Integer>> results, int[] nums, int index, LinkedList<Integer> elements) {
        results.add(new ArrayList(elements));
        for (int i = index; i < nums.length; i++) {
            elements.add(nums[i]);
            dfs6(results, nums, i + 1, elements);
            elements.removeLast();
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        dfs6(results, nums, 0, new LinkedList<>());
        return results;
    }

    public static void dfs5(List<List<Integer>> results, int[] candidates, int target, int index, Deque<Integer> path) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            results.add(new ArrayList<>(path));
        }

        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs5(results, candidates, target - candidates[i], i, path);
            path.removeLast();
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        dfs5(results, candidates, target, 0, new ArrayDeque<>());
        return results;
    }

    public static void dfs4(List<List<Integer>> results, LinkedList<Integer> elements, int n, int start, int k) {
        if (k == 0) {
            results.add(elements.stream().collect(Collectors.toList()));
            return;
        }

        for (int i = start; i <=n; i++) {
            elements.add(i);
            dfs4(results, elements, n, i + 1, k - 1);
            elements.removeLast();
        }
    }
    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> results = new ArrayList<>();
        dfs4(results, new LinkedList<>(), n, 1, k);
        return results;
    }
    public static void dfs3(List<List<Integer>> results, List<Integer> prevElements, List<Integer> elements) {
        if (elements.isEmpty()) {
            results.add(prevElements.stream().collect(Collectors.toList()));
        }

        for (Integer e: elements) {
            List<Integer> nextElements = new ArrayList<>(elements);
            nextElements.remove(e);

            prevElements.add(e);
            dfs3(results, prevElements, nextElements);
            prevElements.remove(e);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> lst = Arrays.stream(nums).boxed().collect(Collectors.toList());
        dfs3(results, new ArrayList<>(), lst);
        return results;
    }

    public static void dfs2(List<String> result, Map<Character, List<Character>> dic, String digits, int index, StringBuilder path) {

        if (path.length() == digits.length()) {
            result.add(String.valueOf(path));
            return;
        }

        for (Character c: dic.get(digits.charAt(index))) {
            dfs2(result, dic, digits, index + 1, new StringBuilder(path).append(c));
        }
    }
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits.isEmpty()) {
            return result;
        }

        Map<Character, List<Character>> dic = new HashMap<>();
        dic.put('0', List.of());
        dic.put('1', List.of());
        dic.put('2', List.of('a', 'b', 'c'));
        dic.put('3', List.of('d', 'e', 'f'));
        dic.put('4', List.of('g', 'h', 'i'));
        dic.put('5', List.of('j', 'k', 'l'));
        dic.put('6', List.of('m', 'n', 'o'));
        dic.put('7', List.of('p', 'q', 'r', 's'));
        dic.put('8', List.of('t', 'u', 'v'));
        dic.put('9', List.of('w', 'x', 'y', 'z'));

        dfs2(result, dic, digits, 0, new StringBuilder());
        return result;
    }

    public static void dfs(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = 'c';
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
        dfs(i + 1, j, grid);
        dfs(i - 1, j , grid);
    }

    public static int numIslands(char[][] grid) {

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }

        return count;
    }
}
