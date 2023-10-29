import java.util.Arrays;

public class SwapNodesInParis {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6};

        printNodes(swapPairs3(makeListNode(nums)));
    }

    public static void printNodes(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
        System.out.println("");
    }

    public static ListNode makeListNode(int[] nums) {

        ListNode result = new ListNode();
        for(int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }

        ListNode tmp = new ListNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            result = new ListNode(nums[i], tmp);
            tmp = result;
        }

        return result;
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode node = head;

        while (node != null && node.next != null) {
            int tmp;
            tmp = node.val;
            node.val = node.next.val;
            node.next.val = tmp;
            node = node.next.next;
        }

        return head;
    }

    public static ListNode swapPairs2(ListNode head) {
        ListNode node = new ListNode(0);
        ListNode root = node;
        node.next = head;

        while (node.next != null && node.next.next != null) {
            ListNode a = node.next;
            ListNode b = node.next.next;
            a.next = b.next;
            node.next = b;
            node.next.next = a;

            node = node.next.next;
        }

        return root.next;
    }

    public static ListNode swapPairs3(ListNode head) {
        if (head != null && head.next != null) {
            ListNode p = head.next;
            head.next = swapPairs3(head.next.next);
            p.next = head;
            return p;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val;}
    ListNode(int val, ListNode next) { this.val = val; this.next = next;}
}