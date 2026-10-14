# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- if the sum is not possible return empty string
- we can get the max sum by taking `9s`
- then `remainder` which is `sum%9` will also be added to res
- then remaining places will be appended by `0s` as we have already got max sum

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
    public String maxSumOfSquares(int num, int sum) {
        if (sum > num * 9)
            return "";

        int nines = sum / 9;
        int remain = sum % 9;

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < nines; i++) {
            res.append('9');
        }

        if (remain > 0)
            res.append((char) (remain + '0'));

        while (res.length() < num) {
            res.append('0');
        }

        return res.toString();
    }
}
```