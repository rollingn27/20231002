public class ReverseLinkedList {

    public static void main(String[] args) {

        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode printNode = node1;

        while (printNode != null) {
            System.out.print(printNode.val);
            printNode = printNode.next;
        }

        ListNode reverseNode = reverseList(node1);
        System.out.println("");

        while (reverseNode != null) {
            System.out.print(reverseNode.val);
            reverseNode = reverseNode.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }

    public static ListNode reverse(ListNode node, ListNode prev) {

        if (node == null) {
            return prev;
        }

        ListNode next = node.next;
        node.next = prev;
        return reverse(next, node);
    }

    public static ListNode reverseList2(ListNode head) {
        ListNode prev = null, node = head;

        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val;}
    ListNode(int val, ListNode next) { this.val = val; this.next = next;}
}