/*
 * 2542. Maximum Subsequence Score
 * 
 * Intuition
 * Here constraint k is involved so heap will be used.
 * We need to find max score ie product of (sum of k nos of nums1 and min of k
 * nos of num2.
 * k nos must have same indicies.
 * Inorder to have max product we should have max left and max right.
 * for max left ie sum of k nos of nums1 we will take min heap of size k. which
 * will have 3 largest nos of nums1 at any given point.
 * we will maintain sum of min heap to calculate product.
 * for max right ie min of k nos of nums2 we will sort it and traverse from
 * decreasing to increasing.
 * if the min heap size is greater than k we will pop the top no and reduce it
 * from sum
 * if the min heap size is k we have a valid scenario and will update res with
 * max of product.
 * 
 * Approach
 * we will have a pair array where a[i],b[i] is nos of nums1 and nums2
 * respectively.
 * b[i] is sorted.
 * we will traverse through the array and apply above conditions.
 * This way we will cover all nos.
 * 
 * Complexity
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++)
            pairs[i] = new int[] { nums1[i], nums2[i] };
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long res = 0, sum = 0;
        for (int[] pair : pairs) {
            pq.add(pair[0]);
            sum += pair[0];
            if (pq.size() > k)
                sum -= pq.poll();
            if (pq.size() == k)
                res = Math.max(res, (sum * pair[1]));
        }
        return res;
    }
}