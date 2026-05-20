// 15. 3Sum

/**
 * Intuition
 * we will solve this using two pointers and sorting
 * to access elements faster we will sort the array
 * then we will fix i pointer and apply 2 pointers using j and k
 * if all three curr nos equal to 0, add these ptrs in res
 * if the sum is greater than 0, reduce k ptr we want lower value
 * if the sum is less than 0, increase j ptr we want higher value
 * we will remove duplicates i and j values, this way k will automatically be
 * unique
 * Approach
 * 
 * Complexity
 * Time complexity: O(n^2)
 * Space complexity: O(logn)
 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            // remove i duplicates
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int total = nums[i] + nums[j] + nums[k];

                if (total > 0)
                    k--;
                else if (total < 0)
                    j++;
                else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    // remove j duplicates
                    // k will automatically we unique
                    while (nums[j] == nums[j - 1] && j < k)
                        j++;
                }
            }
        }
        return res;
    }
}