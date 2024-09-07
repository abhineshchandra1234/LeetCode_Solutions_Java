/**
 * 1367. Linked List in Binary Tree
 * 
 * Intuition
 * given a binary tree root and linked list first node as head
 * we need to return true, if list exist in downward path in tree and false
 * otherwise
 * we can solve this problem through DFS
 * we will start from root and check if the path exists, then we will move to
 * its childs
 * then we will backtrack and check path for root.left and root.right
 * For each node, path can exist for curr, curr.left and curr.right
 * 
 * Approach
 * For dfs
 * terminating cond, if head is null means end of list is reached return true
 * terminating cond, if root is null means reached end of tree ie leaf return
 * false
 * if head value is not equal to root value return false
 * check dfs for head.next and root.left or head.next and root.right, as curr
 * node in tree and list are equal and checking for next node in both of them
 * 
 * Complexity
 * Time complexity: O(m*n), In worst case for each node of the tree we need to
 * check each node of the list
 * Space complexity: O(n), recursive stack
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
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    public boolean isSubPath(ListNode head, TreeNode root) {

        if (root == null)
            return false;

        return (dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right));
    }

    public boolean dfs(ListNode head, TreeNode root) {

        if (head == null)
            return true;

        if (root == null)
            return false;

        if (root.val != head.val)
            return false;

        return dfs(head.next, root.left) || dfs(head.next, root.right);
    }
}