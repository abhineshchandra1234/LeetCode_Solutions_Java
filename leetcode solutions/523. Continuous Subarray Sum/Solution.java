/**
 * 523. Continuous Subarray Sum
 * 
 * Intuition
 * 
 * if the array contains good subarray return true else false
 * good subarray
 * length 2
 * sum of nos is multiple of k
 * prefix sum is useful to calculate sum of subarrays
 * sub-array(i+1,j)%k == 0 -> good-subarray
 * (prefix[i] - prefox[j])%k == 0
 * prefix[i]%k - prefix[j]%k == 0
 * prefix[i]%k == prefix[j]%k
 * So for a good subarray prefix sum up to i modulo k should be equal to prefix
 * sum up to j modulo k
 * So whenever we get prefix sum modulo k equal at any indices, there indicies
 * forms the good-subarray, by being at the ends of it
 * Since we are concerned about modulo of prefix sum, we are discarding rest of
 * the sum at each step
 * 
 * Approach
 * 
 * Base condition is (0,-1), for 0 is prefix sum modulo k at index -1.
 * This is for calculating res at starting indices
 * 
 * Complexity
 * 
 * Time complexity: O(n), using prefix sum to find (i & j)
 * 
 * Space complexity: O(n), storing prefix sum modulo k
 * 
 */
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> m = new HashMap();
        m.put(0, -1);
        int prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];

            prefix %= k;
            if (m.get(prefix) != null) {
                if (i - m.get(prefix) > 1)
                    return true;
            } else
                m.put(prefix, i);
        }
        return false;
    }
}