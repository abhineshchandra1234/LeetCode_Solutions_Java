/**
 * 459. Repeated Substring Pattern
 * 
 * Intuition
 * 
 * we will solve this problem using brute force
 * we will traverse through the string, if the sub-string length divides the
 * string.
 * Then we will repeat the sub-string for possible times and at last check if
 * the new string matches the original string.
 * 
 * Approach
 * 
 * we are running a loop from 1 to mid/2. As last index is excluded.
 * 
 * Complexity
 * 
 * Time complexity: O(n*sqrt(n))
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public boolean repeatedSubstringPattern(String s) {

        int n = s.length();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                StringBuilder pattern = new StringBuilder();
                for (int j = 0; j < n / i; j++)
                    pattern.append(s.substring(0, i));
                if (s.equals(pattern.toString()))
                    return true;
            }
        }
        return false;
    }
}
