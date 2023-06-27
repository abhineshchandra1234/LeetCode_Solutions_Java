/**
 * 373. Find K Pairs with Smallest Sums
 * 
 * Intuition
 * 
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * different set of min pairs would be
 * 
 * 1,2 7,2 11,2
 * 1,4 7,4 11,4
 * 1,6 7,6 11,6
 * 
 * You will notice it is sorted row and col wise
 * min elements order will be 1,2->1,4->1,6->7,2->7,4...
 * So after adding first set 1,2->1,4->1,6 to min heap we will add next element
 * in the order.
 * we have formed this pair by taking first 0 index of nums1 and all indicies of
 * nums2. then 0 index of nums2 and all indices of nums1 and so on.
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(klogk), we are adding k elements to queue and arranging k elements.
 * 
 * Space complexity: O(k)
 * 
 */
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        List<List<Integer>> res = new ArrayList();

        for (int i = 0; i < nums1.length && i < k; i++)
            q.add(new int[] { nums1[i], nums2[0], 0 });

        while (k-- > 0 && !q.isEmpty()) {
            int[] curr = q.poll();
            res.add(Arrays.asList(curr[0], curr[1]));
            if (curr[2] == nums2.length - 1)
                continue;
            q.add(new int[] { curr[0], nums2[curr[2] + 1], curr[2] + 1 });
        }
        return res;
    }
}