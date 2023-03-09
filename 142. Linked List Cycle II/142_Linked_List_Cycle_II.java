/**
 * 142. Linked List Cycle II
 * Use the linked list cycle logic to find the cycle
 * return null if there is no cycle
 * then run a loop till head!=slow
 * head & slow will meet at the start of the cycle
 * head = [3,2,0,-4], pos = 1
 * here slow & fast will meet at -4, slow is now at -4
 * then again head & slow will meet at 2 ie start of the cycle
 * slow & head are at equal distance from start of the cycle
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
                
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)
                break;
        }
        if(fast==null || fast.next==null)
            return null;
        while(head!=slow) {
            head = head.next;
            slow = slow.next;
        }

        return head;
    }
}