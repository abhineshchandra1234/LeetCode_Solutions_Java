# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- by default res will be 2, as prod of two nos = gcd * lcm of two nos
- we can use sliding window to solve this problem
- a valid window ie subarray will have all pairs gcd equal to 1
- we will keep expanding window until above condition satisfy
- we will shrink the window, if above condition fails
- we will take product of only valid window
- once we get a valid window, we will update res with its length
- finally return the res

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
    public int maxLength(int[] nums) {
        int res = 2;
        int prod = 1;
        int n = nums.length;
        int start = 0, end = 0;

        while (end < n) {
            while (gcd(prod, nums[end]) > 1) {
                prod /= nums[start];
                start++;
            }
            prod *= nums[end];
            res = Math.max(res, end - start + 1);
            end++;
        }

        return res;
    }

    private int gcd(int n1, int n2) {
        while (n2 != 0) {
            int temp = n1;
            n1 = n2;
            n2 = temp % n2;
        }
        return n1;
    }
}
```