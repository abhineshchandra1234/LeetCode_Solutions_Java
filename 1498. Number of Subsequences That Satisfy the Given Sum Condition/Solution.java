/**
 * 1498. Number of Subsequences That Satisfy the Given Sum Condition
 * 
 * Intuition
 * We will use two pointer approach to solve this, it is same as two sum
 * Suppose we got index i & j such that nums[i] + nums[j] <= target. Then no of
 * subsequence will be 2^(j-i).
 * In order to get i & j & apply two pointer we need to have array in sorted
 * order.
 * This will not affect no of subsequence as 3,6,5 & 3,5,6 will have same no of
 * subsequence.
 * Now for above statement
 * like - a=[3,5,6] t=9
 * 3 & 6 satisfy the condition ie 3+6<=9, no of subsequence will be 2^(3-1)=4
 * 3 * _ * _ , 3 * 5 * _, 3 * _ * 6, 3 * 5 * 6
 * For each no we have two option either we can take it or leave it
 * we add this subsequence count in the result for each valid pair and get the
 * final result.
 * 
 * Approach
 * 2^(j-i) will take O(n) computation time we can reduce it through binary
 * exponentiation
 * 1st method
 * 2^n , 2^5
 * if n is odd
 * n * 2^(n-1) , 2 * 2^4
 * if n is even
 * n * n * 2^(n/2); , 2 * 2 * 2^2
 * we can compute 2^n in O(logn) time.
 * through pre computation
 * 2nd method
 * store the prev result and compute next
 * pows[0] = 1 ,2^0 = 1
 * pows[1] = pows[0] * 2, 2^1 = 2
 * pows[2] = pows[1] * 2, 2^2 = 4
 * it will take O(1) time, we need not compute 2^n everytime just return res at
 * index n.
 * two-pointers
 * l+r>t
 * r-- to reduce the sum
 * else l++ to compute other nos.
 * if we start r again from end for each l++ then it would always be greater
 * than target bcs array is sorted.
 * 
 * Complexity
 * Time complexity:
 * O(nlogn) -> sorting
 * 
 * Space complexity:
 * 
 * O(n) -> pre-computation
 */
class Solution {
    public int numSubseq(int[] nums, int target) {

        Arrays.sort(nums);
        int res = 0, n = nums.length, l = 0, r = n - 1, mod = (int) 1e9 + 7;
        int[] pows = new int[n];
        pows[0] = 1;
        for (int i = 1; i < n; i++)
            pows[i] = pows[i - 1] * 2 % mod;
        while (l <= r) {
            if (nums[l] + nums[r] > target)
                r--;
            else
                res = (res + pows[r - l++]) % mod;
        }
        return res;
    }
}