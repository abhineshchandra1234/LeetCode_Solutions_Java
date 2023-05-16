/**
 * 24. Swap Nodes in Pairs
 * 
 * Intuition
 * we will need two ptrs to solve this problem.
 * First ptr will point to ith node and second will point to i-1th node
 * we will swap these nodes. Note we cannot swap values here.
 * As it is visible from the question if the head is null or there is single
 * node return the head.
 * In order to swap, you need the curr & curr.next node as not null.
 * We have used the above condition to traverse the nodes.
 * prev will point to i-1th node and curr will point to ith node
 * we will swap prev and curr nodes by breaking and adding the links
 * Finally we will point prev to curr & curr to curr.next.
 * And we will return dummy.next which will point to head.
 * Input: head = [1,2,3,4], head = 1
 * Output: [2,1,4,3], head = 2.
 * It is easier to solve for them who uses two ptrs and understand logic behind
 * linked list.
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
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode dummyNode = new ListNode();
        ListNode prevNode = dummyNode;
        ListNode currNode = head;

        while (currNode != null && currNode.next != null) {
            prevNode.next = currNode.next;
            currNode.next = prevNode.next.next;
            prevNode.next.next = currNode;

            prevNode = currNode;
            currNode = currNode.next;
        }
        return dummyNode.next;
    }
}