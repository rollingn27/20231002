public class OddEvenList {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};

        printNodes(oddEvenList(makeListNode(nums)));
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

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
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