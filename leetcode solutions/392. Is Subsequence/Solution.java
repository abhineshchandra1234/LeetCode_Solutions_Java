/**
 * 392. Is Subsequence
 * 
 * Intuition
 * 
 * credits mageshyt
 * As it is visible in the question
 * we will parse t string and see s string first char matches in t if it does
 * increase subsequence count and move to next char of s
 * At last if the subsequence count is equal to s length, we got our res.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */

// First Approach
class Solution {
    public boolean isSubsequence(String s, String t) {

        if (s.length() > t.length())
            return false;
        if (s.length() == 0)
            return true;
        int subsequence = 0;
        for (int i = 0; i < t.length(); i++) {
            if (subsequence >= s.length())
                break;
            if (s.charAt(subsequence) == t.charAt(i))
                subsequence++;
        }
        return subsequence == s.length();
    }
}

// Second Approach
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j))
                i++;
            j++;
        }

        return i == s.length();
    }
}

// Third Approach
class Solution {
    public boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> m = new HashMap();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            m.computeIfAbsent(c, k -> new ArrayList()).add(i);
        }

        int prev = -1;
        for (char c : s.toCharArray()) {
            if (!m.containsKey(c))
                return false;

            List<Integer> indices = m.get(c);
            int index = Collections.binarySearch(indices, prev + 1);
            if (index < 0)
                index = -index - 1;
            if (index == indices.size())
                return false;
            prev = indices.get(index);
        }
        return true;
    }
}