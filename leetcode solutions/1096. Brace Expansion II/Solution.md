# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- performUnion() handles the choices separated by ,.
- performConcat() handles parts that are next to each other and combines all possibilities.
- getUnit() gets either a single character or a whole {...} block.
- If it sees another {...}, it recursively solves that block.
TreeSet makes sure duplicate answers are removed and results stay sorted.

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
    String s;
    int n;
    int idx = 0;

    public List<String> braceExpansionII(String expression) {
        n = expression.length();
        s = expression;
        idx = 0;

        Set<String> st = performUnion();
        return new ArrayList(st);
    }

    private Set<String> performUnion() {
        Set<String> res = new TreeSet();

        while (true) {
            Set<String> temp = performConcat();
            res.addAll(temp);

            if (idx < n && s.charAt(idx) == ',')
                idx++;
            else
                break;
        }

        return res;
    }

    private Set<String> performConcat() {
        Set<String> res = new TreeSet();
        res.add("");

        while (idx < n && (s.charAt(idx) == '{' || Character.isLetter(s.charAt(idx)))) {
            Set<String> temp = getUnit();

            Set<String> concatRes = new TreeSet();
            for (String left : res) {
                for (String right : temp) {
                    concatRes.add(left + right);
                }
            }
            res = concatRes;
        }
        return res;
    }

    private Set<String> getUnit() {
        Set<String> res;

        if (s.charAt(idx) == '{') {
            idx++;
            res = performUnion();
        } else {
            res = new TreeSet();
            res.add(String.valueOf(s.charAt(idx)));
        }

        idx++;
        return res;
    }
}
```