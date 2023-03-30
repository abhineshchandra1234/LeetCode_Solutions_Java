/**
 * 87. Scramble String
 * 
 * Intuition
 * we will solve this using recursion & memoization ie hashmap to reduce space &
 * time complexity
 * we will store a combination of strings s1 & s2 as keys along with their
 * boolean
 * value of scramble string
 * We do this so that we avoid repeated computation for the same string
 * s1 cannot scramble into s2 if the freq of their chars differ
 * if there is 0<=i<=s1.length()
 * if s1[0,i] can scramble into s2[0,i] and s1[i,length] can scramble into
 * s2[i,length] or
 * if s1[0,i] can scramble into s2[length-i,length] and s1[i,length] can
 * scramble into s2[0,length-i]
 * then s1 can scramble into s2.
 * we just need to reverse or pick a different part of both strings and first
 * see
 * if their chars freq match then see if both sub parts of the strings are
 * identical.
 * 
 * 
 * Approach
 * we will first check if both strings are identical and return true, it will be
 * the
 * terminating cond for recursion
 * then we will see if the map contains both strings as keys and then return its
 * value
 * then we will traverse through the length of the string
 * inside we will use two indexes i and n-i to check if the strings scramble
 * we will also use three fixed arrays of size 26 to check the freq of chars
 * 
 * Complexity
 * Time complexity: O(n^4)
 * it checks all possibility of strings in O(n^2)
 * then it checks the possibility of each substring in O(n^2)
 * Space complexity: O(n^4)
 * map will store all string combinations O(n^4) in worst case
 */
class Solution {

    Map<String, Boolean> map = new HashMap();

    public boolean isScramble(String s1, String s2) {

        int n = s1.length();
        if (s1.equals(s2))
            return true;

        int[] a = new int[26], b = new int[26], c = new int[26];
        if (map.containsKey(s1 + s2))
            return map.get(s1 + s2);

        for (int i = 1; i < n; i++) {
            int j = n - i;
            a[s1.charAt(i - 1) - 'a']++;
            b[s2.charAt(i - 1) - 'a']++;
            c[s2.charAt(j) - 'a']++;

            if (Arrays.equals(a, b) && isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i))) {
                map.put(s1 + s2, true);
                return true;
            }

            if (Arrays.equals(a, c) && isScramble(s1.substring(0, i), s2.substring(j))
                    && isScramble(s1.substring(i), s2.substring(0, j))) {
                map.put(s1 + s2, true);
                return true;
            }
        }
        map.put(s1 + s2, false);
        return false;
    }
}