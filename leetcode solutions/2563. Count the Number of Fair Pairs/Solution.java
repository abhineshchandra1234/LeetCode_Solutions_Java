/**
 * 2563. Count the Number of Fair Pairs
 * 
 * # Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we can solve this problem through binary search
- first sort the array nums
- we need to fetch lower and upper bound for each no 
- curr + nums[i] >= lower, curr >= lower - nums[i]
- curr + nums[i] <= upper, curr <= upper - nums[i]
- then just add the difference between upper and lower bound to the res

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: O(nlogn), sorting the array
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: O(logn), sorting
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
 */

 class Solution {

    public long countFairPairs(int[] nums, int lower, int upper) {

        Arrays.sort(nums);
        long res = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int low = lowerBound(nums, i + 1, nums.length, lower - nums[i]);
            int up = upperBound(nums, i + 1, nums.length, upper - nums[i]);
            res += up - low;
        }
        return res;
    }

    private int lowerBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target)
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }

    private int upperBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target)
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }
}