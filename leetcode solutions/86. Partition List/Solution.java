/**
 * 86. Partition List
 * 
 * Intuition
 * 
 * credits cbmbbz
 * we will solve this problem using two linked list
 * first list will contain nodes less than x and second list will contain all
 * other nodes.
 * We will traverse the list if we get head value less than x add the node to
 * first list otherwise add it to second list
 * so the original list will get divided into two list and eventually merged at
 * last for the answer.
 * At last add second list at the end of first list.
 * 
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
    public ListNode partition(ListNode head, int x) {

        ListNode dummy1 = new ListNode(), dummy2 = new ListNode();
        ListNode curr1 = dummy1, curr2 = dummy2;

        while (head != null) {
            if (head.val < x) {
                curr1.next = head;
                curr1 = head;
            } else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
        }
        curr2.next = null;
        curr1.next = dummy2.next;
        return dummy1.next;
    }
}