/**
 * 974. Subarray Sums Divisible by K
 * 
 * Intuition
 * 
 * return count of subarrays whose sum is divisible by k
 * 
 * subarray(i+1,j)%k == 0
 * prefix(j)%k - prefix(i)%k == 0
 * prefix(j)%k == prefix(i)%k
 * 
 * So j will form suitable subarrays with all i, where i<j, whose prefix mod k
 * is equal
 * It is similar to 523. Continuous Subarray Sum, or sum of subarray is a
 * multiple of k
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        int sum = 0, res = 0;

        Map<Integer, Integer> m = new HashMap();
        m.put(0, 1);

        for (int n : nums) {
            sum = (sum + n) % k;

            if (sum < 0)
                sum += k;

            res += m.getOrDefault(sum, 0);
            m.put(sum, m.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}