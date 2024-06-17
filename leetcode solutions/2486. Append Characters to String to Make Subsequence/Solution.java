/**
 * 2486. Append Characters to String to Make Subsequence
 * 
 * Intuition
 * 
 * we will greedily find out longest prefix of t in s
 * we will use two ptrs si & ti, first will point to s and other to t
 * we will traverse s, if curr chars of both ptrs are same increase ti
 * ti will point to longest prefix of t
 * At last return difference of t length and ti, if the difference is 0 means we
 * have got all chars of t as subsequence in s
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int appendCharacters(String s, String t) {

        int si = 0, ti = 0;

        while (si < s.length() && ti < t.length()) {
            if (s.charAt(si) == t.charAt(ti))
                ti++;
            si++;
        }
        return t.length() - ti;
    }
}