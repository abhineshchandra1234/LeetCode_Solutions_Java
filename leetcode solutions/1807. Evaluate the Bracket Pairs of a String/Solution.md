# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will use a hash map to store knowledge pairs
- Then we will traverse string, if its a alphabet add it to the res
- if the char is open bracket, append next chars till close bracket into a temp string
- Then check if map contains temp, if it does add its value to res else add question mark to res
- Finally return res

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
    public String evaluate(String s, List<List<String>> knowledge) {

        int n = s.length();
        Map<String, String> mp = new HashMap();

        for (List<String> a : knowledge) {
            mp.put(a.get(0), a.get(1));
        }

        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < n) {
            if (Character.isAlphabetic(s.charAt(i))) {
                res.append(s.charAt(i));
            } else {
                i++;
                StringBuilder temp = new StringBuilder();
                while (i < n && s.charAt(i) != ')') {
                    temp.append(s.charAt(i));
                    i++;
                }
                res.append(mp.getOrDefault(temp.toString(), "?"));
            }
            i++;
        }
        return res.toString();
    }
}
```