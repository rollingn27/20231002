import java.util.*;

public class Exam1119 {
    public static void main(String[] args) {
        int[][] graph = {
                { 1, 2 },
                { 3 },
                { 3 },
                {}
        };
        System.out.println(allPathsSourceTarget(graph));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> results = new ArrayList<>();

        List<Integer> arr = new LinkedList<>();
        arr.add(0);
        dfs(results, graph, 0, graph.length - 1, arr);

        return results;
    }

    public static void dfs(List<List<Integer>> results, int[][] graph, int src, int dest, List<Integer> arr) {
        if (src == dest) {
            results.add(arr);
            return;
        }

        for (int g: graph[src]) {
            arr.add(g);
            dfs(results, graph, g, dest, arr);
            arr.add(g);
        }
    }
}
