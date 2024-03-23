/**
 * 143. Reorder List
 * 
 * Intuition
 * 
 * we will first reverse second half of the list
 * Then we will merge first half and the reversed list
 * when we observe the res, we will find list is broken in 2 halfs and 2nd half
 * is reversed.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
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
    public void reorderList(ListNode head) {

        if (head == null || head.next == null)
            return;

        ListNode slow = head, fast = head, prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // preparing first list
        prev.next = null;

        ListNode l2 = reverse(slow);

        merge(head, l2);
    }

    private void merge(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode n1 = l1.next, n2 = l2.next;

            l1.next = l2;

            // single node for l1
            if (n1 == null)
                break;

            l2.next = n1;

            l1 = n1;
            l2 = n2;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}