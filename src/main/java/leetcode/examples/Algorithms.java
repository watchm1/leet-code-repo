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
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] arr = new int[m+n];
        int i=0, j=0, k=0;
        while (i< n && j < m) {
            arr[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        while(i < n) {
            arr[k++] = nums1[i++];
        }
        while(j < m) {
            arr[k++] = nums2[j++];
        }
        
        if ((m+n) % 2 == 0) {
            int firstIndex  = ((m+n)/2 -1);
            int secondIndex = (m+n)/2;

            return (arr[firstIndex] + arr[secondIndex])/2.0;
        }
        return arr[(m+n) / 2];
        
    }
}
