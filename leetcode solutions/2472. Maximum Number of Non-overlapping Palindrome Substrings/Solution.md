# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we have a method to fetch if the curr substring is palindrome or not, using `O(1)` time and is stored in the var `isPalindrome`
- we will use recursion, that will traverse from back and calculate res for us
- we will fetch k length substring from back and check if it is palindrome
- if it is palindrome we will update res with max from res and `1 + i to k`
- this `i to k` will traverse from backwards to forward and fetch res for us
- we will use memoization to store res for each index and finally return res  

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(n^2)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(n^2)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    boolean[][] isPalindrome;
    int[] t;

    public int maxPalindromes(String s, int k) {
        int n = s.length();
        isPalindrome = new boolean[n][n];

        for (int L = 1; L <= n; L++) {
            for (int i = 0; i + L <= n; i++) {
                int j = i + L - 1;

                if (i == j)
                    isPalindrome[i][i] = true;
                else if (i + 1 == j)
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j));
                else
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j))
                            && isPalindrome[i + 1][j - 1];
            }
        }

        t = new int[n + 1];
        Arrays.fill(t, -1);
        return solve(n, k);
    }

    private int solve(int n, int k) {
        if (n < k)
            return 0;
        if (t[n] != -1)
            return t[n];

        int res = solve(n - 1, k);

        int j = n - 1;

        for (int i = 0; j - i + 1 >= k; i++) {
            if (isPalindrome[i][j])
                res = Math.max(res, 1 + solve(i, k));
        }

        return t[n] = res;
    }
}
```