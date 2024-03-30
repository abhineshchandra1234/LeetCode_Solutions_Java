/**
 * 992. Subarrays with K Different Integers
 * 
 * Intuition
 * 
 * credits mik
 * this is problem is hard with lot of mistries, give all blessings you got
 * we will use three ptr leftSmall, leftBig, right to solve this problem
 * we will also use hashmap to keep track of unique nos count as evident in the
 * question
 * we will expand the window, and update freq of no
 * if the unique no count is greater than k ie invalid sub-array, we will shrink
 * window by increasing leftSmall and updating its freq
 * leftBig will reset to leftSmall to point to valid subarray
 * we will find smallest subarray by again shrinking window by increasing
 * leftSmall and updating its freq
 * Finally if the unique no count is k, we will update res with count of valid
 * subarrays for curr window.
 * no of valid sub-arrays for valid window
 * res += leftSmall - leftBig + 1;
 * leftSmall to right is smallest subarray with k or less unique elements which
 * represents + 1
 * leftBig to right is the largest subarray with k or less unique elements with
 * duplications
 * leftSmall - leftBig extra valid subarrays apart from the existing one
 * 
 * Input: nums = [1,2,1,2,3], k = 2
 * Output: 7
 * leftSmall = 2, right = 3
 * leftBig = 0
 * res = 2 - 0 + 1 = 3
 * valid sub-arrays
 * //min valid res
 * [1, 2]
 * //extra res
 * [2, 1, 2]
 * [1, 2, 1, 2]
 * 
 * Approach
 * 
 * we can have array with only single element with duplication, so k or less is
 * written above
 * we are checking map size for this purpose only
 * k or less is also written as we have already checked, invalid subarray with
 * more than k unique elements
 * we check invalid subarray before, as we only need k unique elements, so just
 * discarding the wrong scenarios
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {

        int n = nums.length;
        int leftSmall = 0, leftBig = 0;
        int res = 0;
        Map<Integer, Integer> m = new HashMap();
        for (int right = 0; right < n; right++) {

            // update freq
            m.put(nums[right], m.getOrDefault(nums[right], 0) + 1);

            // invalid subarray
            while (m.size() > k) {
                m.put(nums[leftSmall], m.get(nums[leftSmall]) - 1);
                if (m.get(nums[leftSmall]) == 0)
                    m.remove(nums[leftSmall]);
                leftSmall++;
                leftBig = leftSmall;
            }

            // smallest subarray
            while (m.get(nums[leftSmall]) > 1) {
                m.put(nums[leftSmall], m.get(nums[leftSmall]) - 1);
                leftSmall++;
            }

            // good array
            if (m.size() == k)
                res += leftSmall - leftBig + 1;
        }

        return res;
    }
}