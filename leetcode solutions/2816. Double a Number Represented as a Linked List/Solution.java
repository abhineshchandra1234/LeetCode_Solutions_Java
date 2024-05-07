/**
 * 2816. Double a Number Represented as a Linked List
 * 
 * Intuition
 * 
 * credits lee215
 * Using brute force we first need to reverse the list find the answer by
 * traversing through the list, then again reverse the answer
 * we can optimize it using math
 * if any no is greater than 4, it will have carry eg - 5*2->10, 4*2->8
 * Using this we can simply traverse the nos multiply it by 2 and mod it with 10
 * to get curr no, if the next node value is greater than 4 we need to add 1
 * carry to the curr no
 * 
 * Approach
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
    public ListNode doubleIt(ListNode head) {

        if (head.val > 4)
            head = new ListNode(0, head);

        for (ListNode node = head; node != null; node = node.next) {
            node.val = (node.val * 2) % 10;
            if (node.next != null && node.next.val > 4)
                node.val++;
        }
        return head;
    }
}