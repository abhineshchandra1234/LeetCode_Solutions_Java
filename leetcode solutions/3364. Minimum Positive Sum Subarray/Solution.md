# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will use sliding window to solve this problem
- for each i from 0 to n, we will expand the window till r and calculate curr sum
- if window size is between l and r, we have valid window and we will update the res with curr sum
- At last we will check if res is equal to max value then return -1 otherwise return the res

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(n^2)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(1)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int currS = 0;
            for (int j = i; j < n && (j - i + 1) <= r; j++) {
                currS += nums.get(j);

                if ((j - i + 1) >= l && currS > 0)
                    res = Math.min(res, currS);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
```