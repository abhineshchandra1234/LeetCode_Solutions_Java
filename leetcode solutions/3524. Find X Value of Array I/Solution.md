# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will traverse from start to the end
- we will find curr rem by taking modulo of curr no and k
- we will increase curr rem count in `currCount`
- Then for each curr no or no we will traverse from 0 to k-1
- we will find new rem by taking oldRem pointer * curr no mod k
- we will increase new rem count in `currCount` by adding `oldRem` count from `prevCount`
- then we will assign `currCount` to `prevCount`
- then we will again traverse from 0 to k-1 and add `prevCount` to res
- Finally return res

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
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;

        long[] res = new long[k];
        long[] prevCount = new long[k];

        for (int i = 0; i < n; i++) {
            long[] currCount = new long[k];
            int currRem = nums[i] % k;
            currCount[currRem]++;

            for (int oldRem = 0; oldRem <= k - 1; oldRem++) {
                int newRem = (int) (((long) oldRem * nums[i] % k) % k);
                currCount[newRem] += prevCount[oldRem];
            }

            prevCount = currCount;

            for (int x = 0; x <= k - 1; x++) {
                res[x] += prevCount[x];
            }
        }

        return res;
    }
}
```