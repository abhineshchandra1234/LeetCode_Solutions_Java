# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- Maintain two segment trees to store the sum of values and the sum of their squares for each range. Use lazy propagation to perform range updates efficiently.
- Iterate through the array from left to right and use lastSeenIdx to find the previous occurrence of the current element.
- Add 1 to the range from lastSeenIdx[nums[i]] + 1 to i. This updates the distinct-element counts of all subarrays ending at index i.
- The segment tree maintains the sum of squared distinct-element counts. After each update, add the root's squared sum (sqSumSegTree[0]) to the result.
- Store the current index in lastSeenIdx and continue processing.
- Return the accumulated result modulo `(10^9+7)`.

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(nlogn)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(4*n)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    static final long MOD = 1_000_000_007L;
    int n;

    long[] sqSumSegTree;
    long[] sumSegTree;
    long[] lazyTree;

    void lazyAddition(int i, int l, int r, long val) {
        long len = r - l + 1;

        sqSumSegTree[i] += 2 * val * sumSegTree[i] + len * val * val;
        sumSegTree[i] += len * val;
    }

    void updateRange(int start, int end, int i, int l, int r, long val) {
        if (lazyTree[i] != 0) {
            lazyAddition(i, l, r, lazyTree[i]);

            if (l != r) {
                lazyTree[2 * i + 1] += lazyTree[i];
                lazyTree[2 * i + 2] += lazyTree[i];
            }
            lazyTree[i] = 0;
        }

        // out of range
        if (l > end || r < start || l > r) {
            return;
        }

        // completely within range
        if (l >= start && r <= end) {
            lazyAddition(i, l, r, val);

            if (l != r) {
                lazyTree[2 * i + 1] += val;
                lazyTree[2 * i + 2] += val;
            }
            return;
        }

        int mid = l + (r - l) / 2;
        updateRange(start, end, 2 * i + 1, l, mid, val);
        updateRange(start, end, 2 * i + 2, mid + 1, r, val);

        sumSegTree[i] = sumSegTree[2 * i + 1] + sumSegTree[2 * i + 2];
        sqSumSegTree[i] = sqSumSegTree[2 * i + 1] + sqSumSegTree[2 * i + 2];
    }

    public int sumCounts(int[] nums) {
        n = nums.length;

        sqSumSegTree = new long[4 * n];
        sumSegTree = new long[4 * n];
        lazyTree = new long[4 * n];

        int[] lastSeenIdx = new int[100001];
        java.util.Arrays.fill(lastSeenIdx, -1);
        long result = 0;

        for (int i = 0; i < n; i++) {
            int start = lastSeenIdx[nums[i]] + 1;
            int end = i;

            updateRange(start, end, 0, 0, n - 1, 1);

            result = (result + sqSumSegTree[0]) % MOD;

            lastSeenIdx[nums[i]] = i;
        }

        return (int) result;
    }
}
```