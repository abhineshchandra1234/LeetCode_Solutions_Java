# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will first sort the nums array
- Then we will find out its mid
- then we will calculate how many steps will rerequired to make each no equal to mid
- Finally return steps

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(nlogn)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(1)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int mid = nums[n / 2];

        int moves = 0;
        for (int i = 0; i < n / 2; i++) {
            moves += Math.abs(nums[i] - mid);
            moves += Math.abs(nums[n - i - 1] - mid);
        }
        return moves;
    }
}
```