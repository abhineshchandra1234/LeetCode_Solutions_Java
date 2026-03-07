// 1888. Minimum Number of Flips to Make the Binary String Alternating

/**
 * Intuition
 * we have done s = s + s;, to cover all cases of type 1 operations
 * then we have two strings of type s1 1010 and s2 01010, to cover type 2
 * operations
 * we will use sliding window and compare the curr string with s1 and s2
 * if new or old char of curr str window is not equal to s1 or s2, we will
 * increase or decrease res1 ad res2
 * if curr window size is equal to n, we will compare res, res1 and res2
 * Finally return res
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    public int minFlips(String s) {

        int n = s.length();
        s = s + s;

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for (int i = 0; i < 2 * n; i++) {
            s1.append(i % 2 == 1 ? '0' : '1');
            s2.append(i % 2 == 1 ? '1' : '0');
        }

        int i = 0, j = 0;
        int result1 = 0, result2 = 0;
        int result = Integer.MAX_VALUE;

        while (j < 2 * n) {

            // expand window
            if (s.charAt(j) != s1.charAt(j))
                result1++;
            if (s.charAt(j) != s2.charAt(j))
                result2++;

            // shrink window
            if (j - i + 1 > n) {
                if (s.charAt(i) != s1.charAt(i))
                    result1--;
                if (s.charAt(i) != s2.charAt(i))
                    result2--;
                i++;
            }

            // window size n
            if (j - i + 1 == n)
                result = Math.min(result, Math.min(result1, result2));

            j++;
        }

        return result;
    }
}