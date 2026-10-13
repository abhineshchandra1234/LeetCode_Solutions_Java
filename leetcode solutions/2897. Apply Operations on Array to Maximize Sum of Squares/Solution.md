# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- First we will update count array which will keep count of 1 bits at each index
- Next we will traverse through bits length and update curr with 1 bits
- Then we will square it and add it to res
- By this way we will get the greatest no
- we will do this operation k times to get k numbers

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
    public int maxSum(List<Integer> nums, int k) {
        int mod = (int) (1e9 + 7);
        int bits = 30;

        int[] count = new int[bits];

        for (int num : nums) {
            for (int b = 0; b < bits; b++) {
                if ((num & (1 << b)) != 0)
                    count[b]++;
            }
        }

        long res = 0;

        while (k-- > 0) {
            long curr = 0;
            for (int b = 0; b < bits; b++) {
                if (count[b] > 0) {
                    count[b]--;
                    curr |= (1L << b);
                }
            }

            res = (res + curr * curr) % mod;
        }

        return (int) res;
    }
}
```