import java.util.*;

public class GraphTest2 {
    public static void main(String[] args) {
        int numCourses = 3;
        int[][] prerequisites = {
                {1, 0},
                {2, 1}
        };

        System.out.println(canFinish2(numCourses, prerequisites));
    }

    public static boolean dfs(Map<Integer, List<Integer>> finishToTakeMap, Integer finish, List<Integer> takes, List<Integer> taken) {

        if (takes.contains(finish)) {
            return false;
        }

        if (taken.contains(finish)) {
            return true;
        }

        if (finishToTakeMap.containsKey(finish)) {
            takes.add(finish);
            for (Integer take: finishToTakeMap.get(finish)) {
                if (!dfs(finishToTakeMap, take, takes, taken)) {
                    return false;
                }
            }
            takes.remove(finish);
            taken.add(finish);
        }

        return true;
    }

    public static boolean canFinish2(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] preReqRequired = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int preReq = prerequisites[i][1];
            adj.get(preReq).add(prerequisites[i][0]);
            preReqRequired[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(preReqRequired[i]==0){
                queue.add(i);
            }
        }
        List<Integer> topoOrder = new ArrayList<>();
        while(!queue.isEmpty()){
            int curr = queue.poll();
            topoOrder.add(curr);
            for(int i=0;i<adj.get(curr).size();i++){
                preReqRequired[adj.get(curr).get(i)]--;
                if(preReqRequired[adj.get(curr).get(i)]==0){
                    queue.add(adj.get(curr).get(i));
                }
            }
        }

        return topoOrder.size() == numCourses;
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> finishToTakeMap = new HashMap<>();
        for (int[] pre: prerequisites) {
            finishToTakeMap.putIfAbsent(pre[0], new ArrayList<>());
            finishToTakeMap.get(pre[0]).add(pre[1]);
        }

        List<Integer> takes = new ArrayList<>();
        List<Integer> taken = new ArrayList<>();
        for (Integer finish: finishToTakeMap.keySet()) {
            if (!dfs(finishToTakeMap, finish, takes, taken)) {
                return false;
            }
        }

        return true;
    }
}
