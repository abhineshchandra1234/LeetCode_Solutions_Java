/**
 * 1669. Merge In Between Linked Lists
 * 
 * Intuition
 * 
 * we will solve this problem using two ptrs
 * we will update ptrs such that first ptr point to a-1 & second ptr points to b
 * Then we will add second list after first ptr
 * we will move to end to second list using third ptr and update its next with b
 * next ie rest of the list
 * At last return first list on which two ptrs are working
 * 
 * Approach
 * 
 * we will use index to update ptrs
 * we will increase index as ptr moves
 * initially start will point to null and end will point to start of first list
 * we will run a loop of b length to make second ptr point to b
 * In between if we reach index a-1 update start with end, means start will
 * point to a-1
 * At the end of above loop start or first ptr will point to a-1 & end or second
 * ptr will point to b
 * Then we just need to link or delink lists
 * we can use given ptr list2 to parse second list
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode start = null;
        ListNode end = list1;
        int index = 0;

        // point start to a-1 & end to b
        for (int i = 0; i < b; i++) {
            if (i == a - 1)
                start = end;
            end = end.next;
        }

        // link first list to second list
        start.next = list2;

        while (list2.next != null)
            list2 = list2.next;

        // link second list to remaining list
        list2.next = end.next;

        return list1;
    }
}