import java.math.BigInteger;

public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode l1Node3 = new ListNode(3);
        ListNode l1Node4 = new ListNode(4, l1Node3);
        ListNode l1Node2 = new ListNode(2, l1Node4);

        ListNode l2Node2 = new ListNode(2);
        ListNode l2Node6 = new ListNode(6, l2Node2);
        ListNode l2Node5 = new ListNode(5, l2Node6);

        ListNode resultNode = addTwoNumbers2(l1Node2, l2Node5);
        while (resultNode != null) {
            System.out.print(resultNode.val);
            resultNode = resultNode.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev= null, node = head;

        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }

    public static BigInteger toBigInt(ListNode node) {
        String val = "";

        while (node != null) {
            val += node.val;
            node = node.next;
        }

        return new BigInteger(val);
    }

    public static ListNode toReversedLinkedList(BigInteger val) {
        ListNode prev = null, node = null;

        for (char c: String.valueOf(val).toCharArray()) {
            node = new ListNode(Character.getNumericValue(c));
            node.next = prev;
            prev = node;
        }

        return node;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Reversed = reverseList(l1);
        ListNode l2Reversed = reverseList(l2);

        BigInteger result = toBigInt(l1Reversed).add(toBigInt(l2Reversed));

        return toReversedLinkedList(result);
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode root = node;

        int sum, carry = 0, remainder;

        while (l1 != null || l2 != null || carry != 0) {
            sum = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            remainder = (sum + carry) % 10;
            carry = (sum + carry) / 10;
            node.next = new ListNode(remainder);

            node = node.next;
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