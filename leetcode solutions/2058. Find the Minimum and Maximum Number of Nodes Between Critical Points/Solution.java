// 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points

/**
 * /**
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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] res = { -1, -1 };

        int minDis = Integer.MAX_VALUE;

        ListNode prevN = head;
        ListNode currN = head.next;
        int currIdx = 1;
        int prevCritIdx = 0;
        int firstCritIdx = 0;

        while (currN.next != null) {
            if ((currN.val < prevN.val && currN.val < currN.next.val) ||
                    (currN.val > prevN.val && currN.val > currN.next.val)) {
                if (prevCritIdx == 0) {
                    prevCritIdx = currIdx;
                    firstCritIdx = currIdx;
                } else {
                    minDis = Math.min(
                            minDis,
                            currIdx - prevCritIdx);
                    prevCritIdx = currIdx;
                }
            }

            currIdx++;
            prevN = currN;
            currN = currN.next;
        }

        if (minDis != Integer.MAX_VALUE) {
            int maxDis = prevCritIdx - firstCritIdx;
            res = new int[] { minDis, maxDis };
        }

        return res;
    }
}*/