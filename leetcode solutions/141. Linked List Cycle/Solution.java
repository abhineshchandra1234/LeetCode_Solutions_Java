/*
 * 141. Linked List Cycle
 * 
 * Intuition
 * 
 * credits KnockCat
 * we will solve this using two ptrs fast or slow
 * Initially they will point to head
 * we will increase fast by 2 and slow by 1 units
 * If there is a cycle they will meet at some point otherwise fast will point to
 * null and loop will break
 * We can understand this with real world example of circular race track in
 * which fast sprinter will meet slow sprinter or overtake him at some point
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
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                return true;
        }

        return false;
    }
}