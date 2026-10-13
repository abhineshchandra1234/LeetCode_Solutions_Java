# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will first take square of numbers and store it at its curr place
- then we will sort the nums, nos in front will be small and nos in back will be large
- to maximize our res, we will subtract nos in front from res and add nos in back to the res
- Finally return res

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(nlogn)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(n)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);

        long res = 0;
        for (int i = 0; i < n / 2; i++) {
            res -= nums[i];
        }

        for (int i = n / 2; i < n; i++) {
            res += nums[i];
        }
        return res;
    }
}
```