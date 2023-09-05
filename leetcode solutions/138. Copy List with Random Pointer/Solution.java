/**
 * 138. Copy List with Random Pointer
 * 
 * Intuition
 * 
 * credits liaison
 * Iterate the original list and create duplicate of each node. Each duplicate
 * node will follow the original node.
 * Iterate the new list and assign random ptr of duplicated nodes
 * Restore the original list and extract the duplicated nodes.
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
/*
 * // Definition for a Node.
 * class Node {
 * int val;
 * Node next;
 * Node random;
 * 
 * public Node(int val) {
 * this.val = val;
 * this.next = null;
 * this.random = null;
 * }
 * }
 */

class Solution {
    public Node copyRandomList(Node head) {

        Node iter = head, next;

        // make copy of each node
        // and link them together side-by-side in a single list
        while (iter != null) {
            next = iter.next;

            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = next;

            iter = next;
        }

        // assign random ptrs for copy nodes
        iter = head;
        while (iter != null) {
            if (iter.random != null)
                iter.next.random = iter.random.next;
            iter = iter.next.next;
        }

        // restore the original list and extract the copied list
        iter = head;
        Node pseudoHead = new Node(0);
        Node copy, copyIter = pseudoHead;

        while (iter != null) {
            next = iter.next.next;

            // extract the copy
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            // restore the original list
            iter.next = next;

            iter = next;
        }

        return pseudoHead.next;
    }
}