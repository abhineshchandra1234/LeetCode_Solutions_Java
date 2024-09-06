/**
 * 3217. Delete Nodes From Linked List Present in Array
 * 
 * Intuition
 * we are given an array integer nums and head of the linked list
 * we need to return the modified linked list
 * 
 * Approach
 * we can use simulation to solve this problem
 * As evident in the question add all nos to be removed in a set
 * taverse the list if the no exist in the set, delete prev next value
 * if the no doesnt exist in the set, move prev to next val
 * use dummy node as head for simplification
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
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

    public ListNode modifiedList(int[] nums, ListNode head) {

        Set<Integer> s = new HashSet();

        for (int n : nums) {
            s.add(n);
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (s.contains(curr.val)) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}