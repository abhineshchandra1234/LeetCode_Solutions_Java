// 2996. Smallest Missing Integer Greater Than Sequential Prefix Sum

/**
 * Intuition
 * we will find the sequential sum by taking sum of nums[j] & nums[j-1] where
 * nums[j]=nums[j-1] +1
 * if any consecutive no doesnt follow above rules, we will break the loop
 * we will add all existing nos to the set
 * we need missing sequential no
 * check greater or equal to missing sequential no in set and return it as the
 * ans
 * Approach
 * 
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        Set<Integer> st = new HashSet();
        for (int num : nums) {
            st.add(num);
        }

        int sequential = nums[0];
        for (int j = 1; j < n; j++) {
            if (nums[j] == nums[j - 1] + 1)
                sequential += nums[j];
            else
                break;
        }

        while (st.contains(sequential)) {
            sequential++;
        }

        return sequential;
    }
}