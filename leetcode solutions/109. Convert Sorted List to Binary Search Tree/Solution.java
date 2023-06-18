/**
 * 109. Convert Sorted List to Binary Search Tree
 * 
 * approach - 
 * we will solve this problem using recursion and two-pointer approach
 * for two-pointer approach we need start and end.
 * Initially we will pass head as start and null as tail to recursive function
 * then we will find mid using two-pointer approach
 * we will make mid as root and for its left we will pass start,slow
 * for right we will pass slow.next, tail to recursive function
 * 
 * Time - O(nlogn), for logn recursive call, and traversing each sub-list
 * Space - O(1)
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        
        if(head==null)
            return null;

        return toBst(head,null);
    }
    private TreeNode toBst(ListNode head, ListNode tail) {
        if(head==tail)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=tail && fast.next!=tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode thead = new TreeNode(slow.val);
        thead.left = toBst(head,slow);
        thead.right = toBst(slow.next,tail);
        return thead;
    }
}