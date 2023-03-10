/**
 * 382. Linked List Random Node
 * 
 * approach1 - 
 * 
 * we will use a list to store nodes value initially.
 * In random function we will pick a random index based on list size and 
 * return node value at that index.
 * 
 * Time - O(n)
 * Space - O(n)
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
class Solution {
    List<Integer> nodes = new ArrayList();
    public Solution(ListNode head) {
        while(head!=null) {
            nodes.add(head.val);
            head = head.next;
        }
    }
    
    public int getRandom() {
        int index = (int)(Math.random()*nodes.size());
        return nodes.get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */