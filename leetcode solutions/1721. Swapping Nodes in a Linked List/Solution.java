/**
 * 1721. Swapping Nodes in a Linked List
 * 
 * Intuition
 * In the question it is given we need to swap nodes values and not the nodes.
 * We will have one ptr point to first node and other ptr point to second node.
 * And we will swap the values using temp and not the nodes.
 * We will use p ptr to traverse list as we encounter first node make n1 point
 * to curr node and n2 point to head.
 * Now we will increase n2 till p is null.
 * Finally we will swap n1 & n2 values.
 * This way we will get result in one traversal.
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
    public ListNode swapNodes(ListNode head, int k) {

        ListNode n1 = null, n2 = null;
        for (ListNode p = head; p != null; p = p.next) {
            if (n2 != null)
                n2 = n2.next;
            if (--k == 0) {
                n1 = p;
                n2 = head;
            }
        }

        int temp = n2.val;
        n2.val = n1.val;
        n1.val = temp;
        return head;
    }
}