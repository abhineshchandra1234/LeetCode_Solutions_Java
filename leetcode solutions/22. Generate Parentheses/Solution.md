# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will use recursion to solve this problem
- if the curr string length is equal to 2n, add it in the res
- if open bracket is less than n, we will add open bracket to curr string and call recursion on curr string by increasing the open count by 1
- then we will remove the open bracket from curr string
- if close bracket is less than open, add close bracket to curr string
- then call recursion on curr string, by inceasing the close count by 1
- then we will remove the close bracket
- Finally return res

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(2^n)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(2*n)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {

    private List<String> res = new ArrayList();

    public List<String> generateParenthesis(int n) {
        solve(n, "", 0, 0);
        return res;
    }

    private void solve(int n, String curr, int open, int close) {
        if (curr.length() == 2 * n) {
            res.add(curr);
            return;
        }

        if (open < n) {
            curr += '(';
            solve(n, curr, open + 1, close);
            curr = curr.substring(0, curr.length() - 1);
        }

        if (close < open) {
            curr += ')';
            solve(n, curr, open, close + 1);
            curr = curr.substring(0, curr.length() - 1);
        }
    }
}
```