import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class DequeTest {
    public static void main(String[] args) {
        int[] num1 = {1, 4, 5};
        int[] num2 = {1, 3, 4};
        int[] num3 = {2, 7};
        ListNode[] lists = new ListNode[3];
        lists[0] = makeListNodes(num1);
        lists[1] = makeListNodes(num2);
        lists[2] = makeListNodes(num3);
        ListNode qNode = mergeKLists(lists);
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        System.out.println(solution(scoville, k));

    }

    public static class Point {
        double distance;
        int[] point;

        public Point(double distance, int[] point) {
            this.distance = distance;
            this.point = point;
        }
    }

    public static int solution(int[] scoville, int K {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int s: scoville) {
            pq.add(s);
        }

        int answer = 0;
        while (pq.size() >= 1) {
            if (pq.peek() >= K) {
                return answer;
            }
            if (pq.size() == 1) {
                return -1;
            }
            pq.add(pq.poll() + pq.poll() * 2);

            answer++;
        }

        return -1;
    }
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingDouble(p -> p.distance));
        for (int[] point: points) {
            double distance = Math.sqrt((long) point[0] * point[0] + (long) point[1] * point[1]);
            pq.add(new Point(distance, point));
        }

        int[][] results = new int[k][];
        for (int i = 0; i < k; i++) {
            results[i] = Objects.requireNonNull(pq.poll()).point;
        }

        return results;
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> nodeComparator = (node1, node2) -> node1.val - node2.val;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(nodeComparator);

        ListNode root = new ListNode(0);
        ListNode tail = root;

        for (ListNode node: lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        while (!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;

            if (tail.next != null)
                pq.add(tail.next);
        }

        return root.next;

    }
    public static ListNode makeListNodes(int[] nums) {
        int numsLength = nums.length;
        ListNode node = new ListNode(nums[numsLength - 1]);
        for (int i = numsLength - 2; i >= 0; i--) {
            node = new ListNode(nums[i], node);
        }
        return node;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

