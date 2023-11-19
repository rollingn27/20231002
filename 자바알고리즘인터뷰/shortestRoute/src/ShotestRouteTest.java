import java.util.*;

public class ShotestRouteTest {
    public static void main(String[] args) {
        int[][] times = {
                {3, 1, 5},
                {3, 2, 2},
                {2, 1, 2},
                {3, 4, 1},
                {4, 5, 1},
                {5, 6, 1},
                {6, 7, 1},
                {7, 8, 1},
                {8, 1, 1}
        };

        int n = 3;
        int[][] flights = {
                { 0, 1, 100 },
                { 1, 2, 200 },
                { 0, 2, 500 }
        };

        int src = 0;
        int dst = 2;
        int k = 0;

        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }

    public static class Position {
        final int y;
        final int x;
        final int distance;

        public Position(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }

    static Queue<Position> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
    public static void findPath(int y, int x, int distance, int[][] maps) {
        if (y >= 0 && y < maps.length && x >= 0 && x < maps[0].length && maps[y][x] != 0) {
            maps[y][x] = 0;
            pq.add(new Position(y, x, distance + 1));
        }
    }
    public static int solution(int[][] maps) {

        pq.add(new Position(0, 0, 1));
        Map<Integer, Position> dist = new LinkedHashMap<>();

        while (!pq.isEmpty()) {
            Position cur = pq.poll();

            if (!dist.containsKey(cur.y * 1000 + cur.x)) {
                dist.put(cur.y * 1000 + cur.x, cur);

                findPath(cur.y, cur.x + 1, cur.distance, maps);
                findPath(cur.y, cur.x - 1, cur.distance, maps);
                findPath(cur.y + 1, cur.x, cur.distance, maps);
                findPath(cur.y - 1, cur.x, cur.distance, maps);
            }
        }

        if (dist.containsKey(((maps.length - 1) * 1000) + (maps[0].length - 1))) {
            return dist.get(((maps.length - 1) * 1000) + (maps[0].length - 1)).distance;
        }

        return -1;
    }
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] flight: flights) {
            graph.putIfAbsent(flight[0], new HashMap<>());
            graph.get(flight[0]).put(flight[1], flight[2]);
        }

        Queue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(1)));
        pq.add(Arrays.asList(src, 0, 0));

        Map<Integer, Integer> visited = new HashMap<>();

        while (!pq.isEmpty()) {
            List<Integer> cur = pq.poll();
            int to = cur.get(0);
            int cost = cur.get(1);
            int k_visited = cur.get(2);

            if (to == dst) {
                return cost;
            }

            visited.put(to, k_visited);

            if (k_visited <= k) {
                k_visited += 1;
                if (graph.containsKey(to)) {
                    for (Map.Entry<Integer, Integer> v: graph.get(to).entrySet()) {
                        if (!visited.containsKey(v.getKey()) || k_visited < visited.get(v.getKey())) {
                            int alt = cost + v.getValue();
                            pq.add(Arrays.asList(v.getKey(), alt, k_visited));
                        }

                    }
                }
            }
        }
        return -1;
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        // 출발지 -> 도착지 형태의 맵
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        for (int[] time: times) {
            graph.putIfAbsent(time[0], new HashMap<>());
            // 출발지 -> 도착지 -> 소요 시간 추가
            graph.get(time[0]).put(time[1], time[2]);
        }
        // 정렬 기준 소요 시간으로 우선 순위 큐 생성(도착지, 소요시간)
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        // k부터 시작 k까지의 소요시간은 0
        pq.add(new AbstractMap.SimpleEntry<>(k, 0));

        // 최종 결과를 저장하는 변수 선언
        // 도착지, 소요시간
        Map<Integer, Integer> dist = new HashMap<>();

        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> cur = pq.poll();
            int depart = cur.getKey();
            int time = cur.getValue();

            if (!dist.containsKey(depart)) {
                dist.put(depart, time);

                if (graph.containsKey(depart)) {
                    for (Map.Entry<Integer, Integer> v: graph.get(depart).entrySet()) {
                        int alt = time + v.getValue();
                        pq.add(new AbstractMap.SimpleEntry<>(v.getKey(), alt));
                    }
                }
            }
        }

        if (dist.size() == n) {
            return Collections.max(dist.values());
        }

        return -1;

    }
}
