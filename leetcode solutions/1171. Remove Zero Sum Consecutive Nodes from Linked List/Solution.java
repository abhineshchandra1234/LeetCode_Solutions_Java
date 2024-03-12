/**
 * 1171. Remove Zero Sum Consecutive Nodes from Linked List
 * 
 * Intuition
 * 
 * It is evident in the question we need to somehow solve it using prefix sum
 * but how
 * If the prefix sum repeat itself means sum of nos after first prefix is 0,
 * that is why prefix is repeating itself
 * So we need to remove nos after first prefix till second prefix
 * removed no -> prefix1 + 1 till prefix2
 * 
 * Input: head = [1,2,-3,3,1]
 * Output: [3,1]
 * 
 * 0, D
 * 1, A
 * 3, B
 * 
 * 0 prefix is again coming for index C
 * So A+B+C sum is equal to 0 that is why prefix is repeating and need to be
 * removed as per the question
 * 
 * Approach
 * 
 * we have used dummy node as sometimes head is also deleted
 * we will use alphabetical indexing for easier understanding
 * we will traverse all the nodes using curr
 * if we see prefix for first time add it in map
 * If we see prefix again then try to remove nos and thier mapping in hashmap
 * Remove mapping
 * curr will point to prefix.next
 * take temp prefix equal to prefix + curr and run a loop till temp is not equal
 * to prefix
 * remove temp from map
 * Remove nos
 * point prefix.next to curr.next
 * note - old link still exist between prefix2 and its next, but it will be
 * skipped while traversing.
 * 
 * Complexity
 * 
 * Time complexity: O(n), one pass
 * 
 * Space complexity: O(n), hash map
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
    public ListNode removeZeroSumSublists(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        HashMap<Integer, ListNode> map = new HashMap();
        int prefix = 0;

        while (curr != null) {
            prefix += curr.val;
            if (map.containsKey(prefix)) {
                curr = map.get(prefix).next;
                int p = prefix + curr.val;
                while (p != prefix) {
                    map.remove(p);
                    curr = curr.next;
                    p += curr.val;
                }
                map.get(prefix).next = curr.next;
            } else
                map.put(prefix, curr);
            curr = curr.next;
        }
        return dummy.next;
    }
}