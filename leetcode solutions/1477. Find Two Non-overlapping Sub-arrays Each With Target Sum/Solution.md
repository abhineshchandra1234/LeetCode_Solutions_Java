# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will solve this problem using sliding window
- we will expand the window and add values to currSum
- if the currSum is greater than target, we will shrink the window by deducting leftmost no from currSum 
- if currSum is equal to target, means we have got the valid window
- we will calculate the len of the window
- we will update the res with min of res and len plus min found till index i - 1
- then we will update bestMin length with min of bestMin and curr len
- Later we will update min found till index j with bestMin
- if the res is infinity return -1 otherwise return the res

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
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        int i = 0;
        int j = 0;

        int currSum = 0;
        int[] minTillIdx = new int[n];
        Arrays.fill(minTillIdx, Integer.MAX_VALUE);

        int bestMin = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;

        while (j < n) {
            currSum += arr[j];

            while (i < j && currSum > target) {
                currSum -= arr[i++];
            }

            if (currSum == target) {
                int len = j - i + 1;
                if (i > 0 && minTillIdx[i - 1] != Integer.MAX_VALUE) {
                    res = Math.min(res, len + minTillIdx[i - 1]);
                }
                bestMin = Math.min(bestMin, len);
            }
            minTillIdx[j] = bestMin;
            j++;
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
```