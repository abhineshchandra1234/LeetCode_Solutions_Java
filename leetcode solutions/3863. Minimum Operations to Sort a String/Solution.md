# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will first check if array is sorted if it is return 0 steps
- if array length is 2, we cannot sort it return -1
- Find min and max char in the array
- If first char is min or last char is max, return 1, ie in one step we can sort it
- Find min and max char in the middle
- if start char is greater than max mid and end char is less than min mid, return 3 steps
- At last return 2 steps

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
    public int minOperations(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();

        boolean sorted = true;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                sorted = false;
                break;
            }
        }

        if (sorted)
            return 0;

        if (n == 2)
            return -1;

        char min = arr[0];
        char max = arr[0];
        for (int i = 1; i < n; i++) {
            min = (char) Math.min(min, arr[i]);
            max = (char) Math.max(max, arr[i]);
        }

        if (arr[0] == min || arr[n - 1] == max)
            return 1;

        char minMid = arr[1];
        char maxMid = arr[1];
        for (int i = 2; i < n - 1; i++) {
            minMid = (char) Math.min(minMid, arr[i]);
            maxMid = (char) Math.max(maxMid, arr[i]);
        }

        if (arr[0] > maxMid && arr[n - 1] < minMid)
            return 3;

        return 2;
    }
}
```