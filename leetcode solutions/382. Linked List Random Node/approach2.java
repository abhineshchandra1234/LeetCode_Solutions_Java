/*
 * 382. Linked List Random Node
 * 
 * approach2 -
 * we will solve this using reservoir sampling
 * we will first initialize head with given head.
 * in random function we are picking random no between 0 and i everytime count value increases.
 * to keep it random we are only updating res value if we get random value as 0, whose chance is very less
 * It is fairly simple, our goal is to get random value, 
 * we which are getting by picking random no from increasing pool of nos.
 * Made random global to avoid creating it repetadely, you can create it locally in random func also.
 * 
 * Time - O(n)
 * Space - O(1)
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
    private ListNode head;
    private Random random;
    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }
    
    public int getRandom() {
        int count = 0;
        int res = 0;
        ListNode curr = head;
        
        while(curr!=null) {
            count++;
            if(random.nextInt(count)==0)
                res = curr.val;
            curr = curr.next;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */