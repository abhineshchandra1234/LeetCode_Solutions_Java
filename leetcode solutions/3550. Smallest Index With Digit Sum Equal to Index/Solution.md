# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will traverse nums
- for every no, we will find its digit sum
- if the digit sum is equal to the curr idx return curr idx

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
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int digitS = 0;

            while (num > 0) {
                digitS += num % 10;
                num /= 10;
            }

            if (digitS == i)
                return i;
        }

        return -1;
    }
}
```