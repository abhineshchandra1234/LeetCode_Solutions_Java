/**
 * 1838. Frequency of the Most Frequent Element
 * 
 * Intuition
 * 
 * credits lee215
 * we can find max freq of any value by using sliding window size which contains
 * only that value
 * value of such window is size * max
 * valid window will have its value k + sum >= size * max or
 * k + sum >= (j - i + 1) * A[j]
 * we try to have max freq by converting all nos to max no since we can only
 * increase the nos
 * 
 * Approach
 * 
 * Input: nums = [1,2,4], k = 5
 * Output: 3
 * here [1,2,4] satisfy the cond (k + sum >= size * max),
 * size of the valid window is 3, since we can convert [1,2] to 4
 * 5 + (1+2+4) >= 3 * 4
 * 12 >= 12
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(nlogn), sorting
 * 
 * Space complexity:
 * 
 * O(logn), sorting
 * 
 */
class Solution {
    public int maxFrequency(int[] nums, int k) {

        int res = 0;
        long sum = 0;
        Arrays.sort(nums);
        for (int i = 0, j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum + k < (long) nums[j] * (j - i + 1))
                sum -= nums[i++];
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}