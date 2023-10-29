public class ReverseLinkedList2 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int left = 2;
        int right = 5;
        printNodes(reverseBetween(makeListNode(nums), left, right));
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

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null)
            return null;
        ListNode root = new ListNode(0);
        root.next = head;

        ListNode start = root;
        for (int i = 0; i < left - 1; i++) {
            start = start.next;
        }

        ListNode end = start.next;
        for (int i = 0; i < right - left; i++) {
            ListNode tmp = start.next;
            start.next = end.next;
            end.next = end.next.next;
            start.next.next = tmp;
        }

        return root.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val;}
    ListNode(int val, ListNode next) { this.val = val; this.next = next;}
}