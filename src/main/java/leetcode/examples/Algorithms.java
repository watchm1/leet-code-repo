package leetcode.examples;

public class Algorithms {
    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headOfL1 = l1;
        ListNode headOfL2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while(headOfL1 != null || headOfL2 != null || carry != 0) {
            int x = (headOfL1 != null ? headOfL1.val : 0);
            int y = (headOfL2 != null ? headOfL2.val : 0);

            int sum = x + y + carry;
            int digit = sum % 10;
            carry = sum / 10;

            curr.next = new ListNode(digit);
            curr = curr.next;
            if (headOfL1 != null) headOfL1 = headOfL1.next;
            if (headOfL2 != null) headOfL2 = headOfL2.next;
        }
        return dummy.next;
    }
}
