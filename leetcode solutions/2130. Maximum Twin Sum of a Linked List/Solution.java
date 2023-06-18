/**
 * 2130. Maximum Twin Sum of a Linked List
 * 
 * Intuition
 * We will solve this problem in 3 steps and 2 mins:)
 * First get to the middle of the linked list
 * Reverse the second part of the list
 * Take max sum of pairs of each list
 * We need to reverse the list bcs we cannot traverse back as in double linked
 * list
 * 
 * Approach
 * we are using prev instead of head to traverse list bcs first list is still
 * connected to slow.
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
    public int pairSum(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        int maxVal = 0;

        // get middle of the linked list
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse second part of linked list
        ListNode nextNode, prev = null;
        while (slow != null) {
            nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }

        // get max sum of pairs
        while (prev != null) {
            maxVal = Math.max(maxVal, head.val + prev.val);
            prev = prev.next;
            head = head.next;
        }

        return maxVal;
    }
}