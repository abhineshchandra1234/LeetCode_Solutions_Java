/**
 * 2762. Continuous Subarrays
 * 
 * Intuition
 * we can solve this problem through sliding window and tree map
 * a window will be valid if the difference of max and min no is less than or
 * equal to 2
 * so all diff will be even less
 * to keep track of max and min nos, we will use tree map
 * when shrinking window, we need these values
 * we will shrink window when max and min diff is more than 2
 * otherwise it is a valid window, which will contribute j-i+1 subarrays
 * Approach
 * 
 * Complexity
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */
class Solution {

    public long continuousSubarrays(int[] nums) {

        int n = nums.length;
        TreeMap<Integer, Integer> m = new TreeMap();
        int i = 0, j = 0;
        long count = 0;
        while (j < n) {
            m.put(nums[j], m.getOrDefault(nums[j], 0) + 1);

            while (m.lastEntry().getKey() - m.firstEntry().getKey() > 2) {
                m.put(nums[i], m.get(nums[i]) - 1);
                if (m.get(nums[i]) == 0)
                    m.remove(nums[i]);
                i++;
            }

            count += j - i + 1;
            j++;
        }

        return count;
    }
}