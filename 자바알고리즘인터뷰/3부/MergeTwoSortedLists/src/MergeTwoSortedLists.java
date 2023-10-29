public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode oneNode5 = new ListNode(5);
        ListNode oneNode2 = new ListNode(2, oneNode5);
        ListNode oneNode1 = new ListNode(1, oneNode2);

        ListNode twoNode4 = new ListNode(4);
        ListNode twoNode3 = new ListNode(3, twoNode4);
        ListNode twoNode1 = new ListNode(1, twoNode3);

        ListNode resultNode = mergeTwoLists(oneNode1, twoNode1);

        while (resultNode != null) {
            System.out.print(resultNode.val);
            resultNode = resultNode.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val;}
    ListNode(int val, ListNode next) { this.val = val; this.next = next;}
}