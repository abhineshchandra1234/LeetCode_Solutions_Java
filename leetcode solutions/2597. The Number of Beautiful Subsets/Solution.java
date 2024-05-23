/**
 * 2597. The Number of Beautiful Subsets
 * 
 * Intuition
 * 
 * we can solve this problem through backtracking
 * solution is hidden in the internal working of the backtracking
 * we can have a local freq map of elements for each step or index and when we
 * add any element, we just need to check if nums[i]+k or nums[i]-k exist in the
 * map, if it does, we will skip that element
 * If nums[i]+k or nums[i]-k doesnt exist, we will first choose that element for
 * base solution, then try its extensions
 * Then we will unchoose that element
 * We will also try extensions for condition in which we do not take that
 * element
 * The terminating condition is, if we reach end of index, return 1 ie it is a
 * beautiful subset
 * For each index or step we will return sum of taken and not_taken curr element
 * ie basic logic of backtracking
 * 
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(2^n), we are generating 2^n subsets
 * 
 * Space complexity: O(n), recursive stack length for each index is max n
 * 
 */
class Solution {
    public int beautifulSubsets(int[] nums, int k) {

        Map<Integer, Integer> m = new HashMap();
        int ans = helper(nums, k, m, 0);
        return ans - 1;
    }

    private int helper(int[] nums, int k, Map<Integer, Integer> m, int i) {

        if (i == nums.length)
            return 1;

        int taken = 0;
        if (!m.containsKey(nums[i] + k) && !m.containsKey(nums[i] - k)) {
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
            taken = helper(nums, k, m, i + 1);
            m.put(nums[i], m.get(nums[i]) - 1);
            if (m.get(nums[i]) == 0)
                m.remove(nums[i]);
        }

        int notTaken = helper(nums, k, m, i + 1);
        return taken + notTaken;
    }
}