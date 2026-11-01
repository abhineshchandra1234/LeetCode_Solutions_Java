# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we can make every no equal to max or min, both will have similar steps count
- we will do latter one
- for every no steps equal to `curr no - min`
- so we have taken `sum - n*min` for all the nos

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(n)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(1)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;

        long sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            min = Math.min(min, nums[i]);
        }

        return (int) (sum - (long) n * min);
    }
}
```