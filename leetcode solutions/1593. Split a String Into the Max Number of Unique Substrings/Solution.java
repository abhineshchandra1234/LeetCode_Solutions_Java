/**
 * 1593. Split a String Into the Max Number of Unique Substrings
 * 
 * Intuition
 * we can solve this problem through recursion and backtracking
 * we will traverse through the index of string
 * Inner loop will also traverse the index of string
 * we will take substring between these two indices and find res of rest of the
 * string
 * we will keep doing this by increasing both pointers till we have traversed
 * whole string
 * maxCount = Math.max(maxCount, 1 + backtrack(s, end, seen));
 * we will also add curr substring to set, for unique substrings requirements
 * And since curr subtring is already calculated, we will remove it from set
 * Approach
 * 
 * Complexity
 * Time complexity: O(n*2^n), we are traversing string, we can generate 2^n
 * substrings
 * Space complexity: O(n)
 */

class Solution {

    public int maxUniqueSplit(String s) {

        Set<String> seen = new HashSet();

        return backtrack(s, 0, seen);
    }

    private int backtrack(String s, int start, Set<String> seen) {

        if (start == s.length())
            return 0;

        int max = 0;

        for (int end = start + 1; end <= s.length(); end++) {

            String substring = s.substring(start, end);
            if (!seen.contains(substring)) {
                seen.add(substring);
                max = Math.max(max, 1 + backtrack(s, end, seen));
                seen.remove(substring);
            }
        }

        return max;
    }

}