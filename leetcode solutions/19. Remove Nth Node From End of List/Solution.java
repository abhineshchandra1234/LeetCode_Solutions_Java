/**
 * 19. Remove Nth Node From End of List
 * 
 * Intuition
 * 
 * we will solve this problem using two ptrs, and update one ptr with a delay of
 * n
 * we will first move fast ptr n steps ahead
 * Then we will move both slow and fast ptr till fast.next is not equal to null
 * this way slow.next ptr will point to the node to be removed and fast will
 * point to last node
 * we will delete the desired node with
 * slow.next = slow.next.next;
 * we have used a dummy node whose next point to head, as sometimes the head is
 * deleted, and also to simplify the computation
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n), one pass
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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i < n; i++)
            fast = fast.next;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}