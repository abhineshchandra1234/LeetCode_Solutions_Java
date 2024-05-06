/**
 * 2487. Remove Nodes From Linked List
 * 
 * Intuition
 * Target
 * 
 * remove all nodes which has nodes greater than it anywhere in the right side
 * 
 * Given
 * 
 * head of the linked list
 * 
 * Solution
 * 
 * the answer lies in the question
 * we will solve it using recursion
 * we will first traverse to the last node using recursion and using
 * backtracking remove suitable nodes which follows target
 * Resultant list will be in decreasing order, as right nodes with less value
 * than curr nodes are removed
 * ie In resultant list every curr node next will be the greatest among all
 * right nodes
 * Terminating cond -> if head or curr node is null return null
 * Recursive cond -> we will call recursive func on head.next and assign its
 * value to head.next
 * Computation -> if the curr node next node is not null and curr node value is
 * less than next node, remove curr node by returning next node, otherwise curr
 * node is a valid node return it. ie greatest among all right nodes.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n), recursive stack
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
    public ListNode removeNodes(ListNode head) {

        if (head == null)
            return null;
        head.next = removeNodes(head.next);
        return (head.next != null && head.val < head.next.val) ? head.next : head;
    }
}