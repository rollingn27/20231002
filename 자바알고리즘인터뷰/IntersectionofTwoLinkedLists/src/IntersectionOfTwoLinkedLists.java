public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 8, 4, 5};
        int[] nums2 = {5, 6, 1, 8, 4, 5};

        ListNode abc = getIntersectionNode(makeLinkedList(nums1), makeLinkedList(nums2));
        System.out.println("테스트");

    }

    public static ListNode makeLinkedList(int[] nums) {

        ListNode node = new ListNode(nums[0]);
        ListNode temp = node;
        for (int i = 1; i < nums.length; i++) {
            temp.next = new ListNode(nums[i]);
            temp = temp.next;
        }
        return node;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int aCount = 0;
        int bCount = 0;
        ListNode aNode = headA;
        ListNode bNode = headB;

        while (aNode != null) {
            aCount++;
            aNode = aNode.next;
        }

        while (bNode != null) {
            bCount++;
            bNode = bNode.next;
        }

        while (aCount < bCount) {
            headB = headB.next;
            bCount--;
        }

        while (bCount < aCount) {
            headA = headA.next;
            aCount--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    public static ListNode reverseListNode(ListNode head) {

        ListNode node = head;
        ListNode prev = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }

        return prev;
    }



    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
