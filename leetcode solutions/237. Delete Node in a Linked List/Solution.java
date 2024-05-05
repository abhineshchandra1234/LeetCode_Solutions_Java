/**
 * 237. Delete Node in a Linked List
 * 
 * Intuition
 * Target
 * 
 * Remove value of curr node from the list and not the curr node
 * 
 * Given
 * 
 * head is not given only the node whose value is to be deleted is given
 * 
 * Solution
 * 
 * Since there is no head node we have to do all computation using curr node
 * since we cannot delete the curr node, we will swap its value with the next
 * node and delete the next node
 * 
 * Approach
 * 
 * Assign next node value to curr
 * Point curr next to next node's next
 * 
 * Complexity
 * 
 * Time complexity: O(1)
 * 
 * Space complexity: O(1)
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }
}