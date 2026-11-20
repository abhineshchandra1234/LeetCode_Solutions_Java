# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will first sort array nums
- then we will make two recursive calls to solve function
- we will update res with max of len returned by above two recursive calls
- in first recursive call we will not increment curr value and search for no equal to curr then increase it by 1
- in second recursive call we will increment curr value and seach for no equal to curr
- inside solve function we will make two recursive calls to find function
- find function will return index of nos for above two recursive calls
- using this index we will find len
- then we will return this len to res

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(nlogn)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(n)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    int n;
    int[][] memo;

    public int maxSelectedElements(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);
        memo = new int[n + 1][2];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int res = 1;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, Math.max(solve(i, 0, nums), solve(i, 1, nums)));
        }

        return res;
    }

    private int solve(int i, int inc, int[] nums) {
        if (memo[i][inc] != -1) {
            return memo[i][inc];
        }

        int curr = nums[i] + inc;
        int len = 1;

        int j = find(nums, i + 1, curr + 1);
        if (j != -1) {
            len = Math.max(len, 1 + solve(j, 0, nums));
        }

        j = find(nums, i + 1, curr);
        if (j != -1) {
            len = Math.max(len, 1 + solve(j, 1, nums));
        }

        return memo[i][inc] = len;
    }

    private int find(int[] nums, int start, int target) {
        int l = start, h = n;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }

        if (l < n && nums[l] == target) {
            return l;
        }

        return -1;
    }
}
```