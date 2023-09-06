/**
 * 725. Split Linked List in Parts
 * 
 * Intuition
 * 
 * We have n/k parts
 * each n%k parts have an extra node
 * And we will add head of each nodes list to res
 * 
 * Approach
 * 
 * Using above approach we will not have any extra null trailing nodes in each
 * list
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n), Finding the length of the list, also adding nodes to res
 * 
 * Space complexity:
 * 
 * O(1), only the res array
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
    public ListNode[] splitListToParts(ListNode head, int k) {

        ListNode curr = head;
        int n = 0;
        while (curr != null) {
            curr = curr.next;
            n++;
        }

        int width = n / k, rem = n % k;

        ListNode[] ans = new ListNode[k];
        curr = head;

        for (int i = 0; i < k; i++) {
            ListNode dummy = new ListNode(0), write = dummy;
            for (int j = 0; j < width + (i < rem ? 1 : 0); j++) {
                write.next = new ListNode(curr.val);
                write = write.next;
                curr = curr.next;
            }
            ans[i] = dummy.next;
        }

        return ans;
    }
}