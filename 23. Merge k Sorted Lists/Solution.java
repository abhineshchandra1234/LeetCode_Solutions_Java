/**
 * 23. Merge k Sorted Lists
 * 
 * approach - 
 * we will use minHeap to solve this. We will parse each list and add each node value to minHeap.
 * Then we will take two dummy nodes. Then we will pop top node from heap and add it 
 * to dummy next. Finally return dummy next. we will add only values to heap bcs if we add nodes it will contain links.
 * 
 * Time - O(nlogn) where n is the number of nodes in the linked lists
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
        public ListNode mergeKLists(ListNode[] lists) {
            
            if(lists.length==0)
                return null;
            
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for(ListNode head: lists) {
                while(head!=null) {
                    minHeap.add(head.val);
                    head = head.next;
                }
            }
            
            ListNode temp = new ListNode();
            ListNode head = temp;
            while(!minHeap.isEmpty()) {
                head.next = new ListNode(minHeap.poll());
                head = head.next;
            }
            
            return temp.next;
        }
    }