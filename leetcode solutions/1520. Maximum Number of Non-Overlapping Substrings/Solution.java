# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will first record start and end index of each char
- then we will check validity of all chars
- if in between chars ie from start and end of curr char, has start less than curr char, then it is not a valid char
- if the curr char is valid we will update end of curr char with max of end of in between char and end of curr char
- then we will traverse from end and add valid chars substring to res
- if curr index is start of char and its end is less than last start of previous substring, then we can add curr index substring to res
- Finally return res 

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(n)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(26)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();

        int[] start = new int[26];
        int[] end = new int[26];
        boolean[] isValid = new boolean[26];

        Arrays.fill(start, -1);
        Arrays.fill(isValid, true);

        List<String> res = new ArrayList();

        //updating start and end index of each char
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';

            if (start[idx] == -1)
                start[idx] = i;
            end[idx] = i;
        }

        //checking validity of all chars
        for (int c = 0; c < 26; c++) {
            if (start[c] == -1)
                continue;
            //checking in between chars
            for (int i = start[c]; i <= end[c]; i++) {
                int ch = s.charAt(i) - 'a';
                if (start[ch] < start[c]) {
                    isValid[c] = false;
                    break;
                }
                //update end with max of in between chars
                end[c] = Math.max(end[c], end[ch]);
            }
        }

        int lastStart = Integer.MAX_VALUE;
        //traversing from end and adding valid substring to res
        for (int i = n - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'a';

            if (!isValid[c])
                continue;

            if (i == start[c] && end[c] < lastStart) {
                res.add(s.substring(i, end[c] + 1));
                lastStart = i;
            }
        }

        return res;
    }
}
```