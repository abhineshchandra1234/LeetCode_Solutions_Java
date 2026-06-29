// 1967. Number of Strings That Appear as Substrings in Word

/***
 * Intuition
 * we will traverse patterns and for every pattern, we will check it at each
 * index of word
 * if there is a match we will return true otherwise return false at the end
 * for each true we would increase the res and return the res at the end
 * Approach
 * 
 * Complexity
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */

class Solution {

    public int numOfStrings(String[] patterns, String word) {
        int res = 0;
        for (String pattern : patterns) {
            if (check(pattern, word)) {
                res++;
            }
        }
        return res;
    }

    private boolean check(String pattern, String word) {
        int m = pattern.length();
        int n = word.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (word.charAt(i + j) != pattern.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}