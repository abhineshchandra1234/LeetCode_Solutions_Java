/**
 * 2366. Minimum Replacements to Sort the Array
 * 
 * Intuition
 * 
 * credits singh__12
 * we will traverse the array from back
 * If the curr element is greater than last or prev element we need to divide
 * the curr element
 * If the curr element is equal there will no division hence no inc in
 * operations and updated last will be curr element
 * no of divisions nums[i]/last
 * if there is a remin there will one more division. no of division += 1.
 * updated last or prev for next comparison nums[i]/ no of divisons
 * no of operations is no of divisons - 1.
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public long minimumReplacement(int[] nums) {

        int n = nums.length;
        int last = nums[n - 1];
        long ans = 0;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > last) {
                int t = nums[i] / last;
                if (nums[i] % last != 0)
                    t++;
                last = nums[i] / t;
                ans += t - 1;
            } else
                last = nums[i];
        }

        return ans;
    }
}