# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will traverse through the indices
- if `n%i+1==0` we will add its square of nos to res
- Finally return the res

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
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            if (n % (i + 1) == 0)
                res += nums[i] * nums[i];
        }

        return res;
    }
}
```