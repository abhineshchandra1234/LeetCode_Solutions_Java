// 2095. Delete the Middle Node of a Linked List

/**
 * Intuition
 * we will solve this with two ptrs fast and slow
 * fast will move at 2 pace than slow
 * slow will move at 1 pace
 * when fast will be pointing to the end of the list, slow will point to the
 * middle of the list
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = slow.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}