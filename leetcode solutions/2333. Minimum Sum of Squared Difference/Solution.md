# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- first we will find all the differences  and store it in `diff`
- we will find `maxDiff` using differences
- we will use counting sort to store frequency of all diffs
- we will store all nos of `diff` into `countDiff`
- total operations will be sum of `k1` and `k2`
- we will find curr operations by taking min of currDiff frequency and curr operations
- we will reduce curr operations from currDiff
- we will add curr operations to currDiff - 1
- then we will reduce curr operations from k
- finally add freq * diff * diff into res and return res

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(n)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(n)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        int[] countDiff = new int[maxDiff + 1];
        for (int d : diff) {
            countDiff[d]++;
        }

        long k = (long) (k1 + k2);

        for (int currDiff = maxDiff; currDiff > 0
                && k > 0; currDiff--) {
            int ops = (int) Math.min(countDiff[currDiff], k);
            countDiff[currDiff] -= ops;
            countDiff[currDiff - 1] += ops;
            k -= ops;
        }

        long res = 0;
        for (long d = 1; d <= maxDiff; d++) {
            res += countDiff[(int) d] * d * d;
        }

        return res;
    }
}
```