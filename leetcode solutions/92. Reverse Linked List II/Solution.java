/**
 * 92. Reverse Linked List II
 * 
 * Intuition
 * 
 * credits ardyadipta
 * we will solve this using 4 ptrs dummy, pre, start and then
 * dummy will point to start of the original list
 * pre will point to start of the reversed list
 * start will point to node at start of reversed sub-list. This node will be
 * moved to the end.
 * Then will point to node that will be reversed.
 * we will take node at last or then and bring it in front after pre
 * 
 * Approach
 * 
 * for - 1,2,3,4,5,6 m = 2, n = 5
 * 1 -> 2 -> 3 -> 4 -> 5 -> 6, pre=1, start=2, then=3
 * 1 -> 3 -> 2 -> 4 -> 5 -> 6, pre=1, start=2, then=4
 * 1 -> 4 -> 3 -> 2 -> 5 -> 6, pre=1, start=2, then=5
 * res -> 1 -> 5 -> 4 -> 3 -> 2 ->6, pre=1, start=2, then=6
 * 
 * you can notice from above we are bringing then forward and increasing it.
 * pre is constant
 * start node is constant and traversing to the back of list.
 * 
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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        // point to start of the original list
        ListNode dummy = new ListNode();
        dummy.next = head;

        // point to start of the reversed list
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++)
            pre = pre.next;

        // point to node at start of reversed sub-list
        ListNode start = pre.next;

        // point to node that will be reversed
        ListNode then = start.next;

        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        return dummy.next;
    }
}