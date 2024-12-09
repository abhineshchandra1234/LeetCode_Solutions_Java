/**
 * 3152. Special Array II
 * 
 * Intuition
 * we can solve this problem through prefix sum
 * At each index we will find, how many no's sequentially follow the pattern of
 * e->o-e or o->e->o
 * Initially all will have a value of 1, means at least 1 no follow the pattern
 * we will start checking from second no
 * if the previous no is of different parity, do prefix[i] = 1 + prefix[i-1]
 * if the previous no is of same parity, no changes needed or assign 1
 * Now just traverse query, check if the prefix[i] is greater than or equal to
 * query window
 * If it is we have query window or more no's following the parity pattern,
 * return true else false
 * 
 * Approach
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {

        int n = nums.length;
        int[] prefix = new int[n];
        Arrays.fill(prefix, 1);

        // update prefix
        for (int i = 1; i < n; i++) {
            if ((nums[i] & 1) != (nums[i - 1] & 1))
                prefix[i] = prefix[i - 1] + 1;
        }

        // traverse queries and update res
        boolean[] res = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int win = queries[i][1] - queries[i][0] + 1;
            if (prefix[queries[i][1]] >= win)
                res[i] = true;
            else
                res[i] = false;
        }
        return res;
    }
}