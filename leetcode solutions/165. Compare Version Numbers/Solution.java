/**
 * 165. Compare Version Numbers
 * 
 * Intuition
 * 
 * we need to compare each char of both versions and whoesever int value is more
 * has greater version no
 * we are assuming next level as 0 if there are no more levels in shorter
 * version number.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n), traversing each char
 * 
 * Space complexity: O(n), using array to compare chars
 * 
 */
class Solution {
    public int compareVersion(String version1, String version2) {

        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");

        int length = Math.max(levels1.length, levels2.length);

        for (int i = 0; i < length; i++) {
            Integer v1 = i < levels1.length ? Integer.valueOf(levels1[i]) : 0;
            Integer v2 = i < levels2.length ? Integer.valueOf(levels2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0)
                return compare;
        }

        return 0;
    }
}