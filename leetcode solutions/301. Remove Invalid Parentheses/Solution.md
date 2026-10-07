# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will generate all the strings using backtracking, and if they are valid we will add them to the set
- we have a var count which keeps track of open brackets, if its less than 0, then it is a invalid substring
- if we have reached index n and if the curr length is greater than max length update max length
- if curr length is equal to max length, add curr string to stack
- if the curr char is alphabet explore possiblity by adding it then removing it
- if the curr char is open or close bracket, explore possiblity by adding it then removing it
- add -1 to count if it is close bracket
- Finally return set as an array list

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(2^n)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(n^2)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    private Set<String> st = new HashSet();
    private int n, maxL;

    public List<String> removeInvalidParentheses(String s) {
        n = s.length();
        maxL = 0;

        solve(s, 0, new StringBuilder(), 0);
        return new ArrayList(st);
    }

    private void solve(String s, int i, StringBuilder curr, int count) {
        if (count < 0)
            return;

        if (i == n) {
            if (count == 0) {
                if (curr.length() > maxL) {
                    maxL = curr.length();
                    st.clear();
                }

                if (curr.length() == maxL) {
                    st.add(curr.toString());
                }
            }
            return;
        }

        char c = s.charAt(i);

        //for chars
        if (c != '(' && c != ')') {
            curr.append(c);
            solve(s, i + 1, curr, count);
            curr.deleteCharAt(curr.length() - 1);
            return;
        }

        //for open & close brackets
        curr.append(c);
        solve(s, i + 1, curr, count + (c == '(' ? 1 : -1));
        curr.deleteCharAt(curr.length() - 1);
        solve(s, i + 1, curr, count);
    }
}
```