/**
 * 234. Palindrome Linked List
 * 
 * Intuition
 * 
 * As with most linked list problems we will solve it using two ptrs
 * we will reverse second half of the list
 * then compare both lists and return true at last if all values are equal or
 * return false when any value is not same
 * 
 * Approach
 * 
 * to reverse second half of list
 * run first ptr two steps and second ptrs 1 step
 * when the loop breaks first ptr will point to null ie end of list and second
 * ptr will point to mid of the list
 * Then just reverse the list using a reverse func by passing the second ptr
 * compare two lists
 * we can use first ptr head, second ptr slow is changed point it to head of
 * second reversed list
 * Then simply compare both lists using these two ptrs
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
    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = reverse(slow);

        while (slow != null) {
            if (head.val != slow.val)
                return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = new ListNode();
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}