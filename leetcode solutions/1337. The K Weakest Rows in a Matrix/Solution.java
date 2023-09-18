/**
 * 1337. The K Weakest Rows in a Matrix
 * 
 * Intuition
 * 
 * As it is visible in the question we will solve it using heap
 * we will store soldier count and row in the heap
 * we will use max heap with constraint which will behave as min heap and save
 * space
 * we will find soldier count through binary search, as it is sorted array
 * as we are using max heap reverse the conds max soldier count and max row will
 * be at the top
 * 
 * Approach
 * Complexity
 * 
 * Time complexity:
 * 
 * O(nlogn), binary search for each row
 * 
 * Space complexity:
 * 
 * O(k), heap and res size
 * 
 */
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0]
                ? b[0] - a[0]
                : b[1] - a[1]);

        int[] ans = new int[k];

        for (int i = 0; i < mat.length; i++) {
            pq.add(new int[] { numOnes(mat[i]), i });
            if (pq.size() > k)
                pq.poll();
        }

        while (k > 0)
            ans[--k] = pq.poll()[1];

        return ans;
    }

    private int numOnes(int[] row) {
        int lo = 0;
        int hi = row.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (row[mid] == 1)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }
}