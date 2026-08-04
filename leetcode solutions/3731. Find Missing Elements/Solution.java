// 3731. Find Missing Elements

/**
 * Intuition
 * for every integers nums[i] and nums[i+1], every integer in the range
 * nums[i]+1,nums[i+1] is missing
 * we will just traverse the nums and add those missing nos to res
 * Approach
 * 
 * Complexity
 * Time complexity: O(nlogn)
 * Space complexity: O(1)
 */

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList();

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = nums[i] + 1; j < nums[i + 1]; j++) {
                ans.add(j);
            }
        }

        return ans;
    }
}