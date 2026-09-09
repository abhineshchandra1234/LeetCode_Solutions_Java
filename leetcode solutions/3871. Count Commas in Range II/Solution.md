# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- each power of 1000 will contribute a comma, as we add comma from 3 places to the right
- so each group will contribute `n-p+1` comma, we will keep increasing p by 1000
- Finally add these groups to the res and return the res

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(logn)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(1)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    public long countCommas(long n) {
        long p = 1000, res = 0;
        while (p <= n) {
            res += n - p + 1;
            p *= 1000;
        }
        return res;
    }
}
```