// 1461. Check If a String Contains All Binary Codes of Size K

/**
 * Intuition
 * we will check substring of length k using sliding window
 * If the set doesnt contain the curr sub, add it in the set and reduce unique
 * count
 * unique count will be 2^k, ie all subs
 * if unique count equals 0, return true
 * Otherwise return false at the end
 * Initial string will either contain all subs of k length or miss 0 or few of
 * them
 * Approach
 * 
 * Complexity
 * Time complexity: O(n), sliding window
 * Space complexity: O(n), storing substrings
 */

class Solution {
    public boolean hasAllCodes(String s, int k) {

        if (s.length() < k)
            return false;

        int unique = 1 << k;
        HashSet<String> set = new HashSet();
        for (int i = k; i <= s.length(); i++) {
            String sub = s.substring(i - k, i);

            if (!set.contains(sub)) {
                set.add(sub);
                unique--;
            }
            if (unique == 0)
                return true;
        }
        return false;
    }
}