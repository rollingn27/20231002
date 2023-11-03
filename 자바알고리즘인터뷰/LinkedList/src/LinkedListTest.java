import java.math.BigInteger;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LinkedListTest {

    public static void main(String[] args) {
        int[] num1 = { 1, 2, 3, 4, 5, 6 };
        int[] num2 = { 5, 6, 2 };
        printLinkedList(swapPairs2(makeLinkedList(num1)));
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
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Reversed = reverseList(l1);
        ListNode l2Reversed = reverseList(l2);

        BigInteger result = toBigInt(l1Reversed).add(toBigInt(l2Reversed));

        return toReversedLinkedList(result);
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
    public static BigInteger toBigInt(ListNode node) {
        StringBuilder val = new StringBuilder();

        while (node != null) {
            val.append(node.val);
            node = node.next;
        }

        return new BigInteger(val.toString());
    }
    public static ListNode reverseList(ListNode head) {
        ListNode reverseNode = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = reverseNode;
            reverseNode = head;
            head = next;
        }

        return reverseNode;
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

    public static ListNode makeLinkedList(int[] nums) {

        ListNode node = new ListNode(nums[nums.length - 1]);

        for (int i = nums.length - 2; i >= 0; i--) {
            node = new ListNode(nums[i], node);
        }
        return node;
    }

    public static void printLinkedList(ListNode node) {

        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
    }

    public static boolean isPalindrome(ListNode head) {

        Deque<Integer> deque = new LinkedList<>();
        ListNode node = head;

        while (node != null) {
            deque.add(node.val);
            node = node.next;
        }

        while (!deque.isEmpty() && deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) {
                return false;
            }
        }

        return true;

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }

}
