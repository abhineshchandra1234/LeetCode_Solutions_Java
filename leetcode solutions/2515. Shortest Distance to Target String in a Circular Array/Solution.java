// 2515. Shortest Distance to Target String in a Circular Array

/**
 * Intuition
 * when we reach target we will perform below operations
 * we will calculate straight dist ie abs(i-startIndex)
 * we will calculate circular dist ie n - (i-startIndex)
 * we will take min of res, straight dist and circular dist and assign it to res
 * Finally if res is infinity we didnt get target return -1 else we will return
 * the res
 * Approach
 * 
 * Complexity
 * Time complexity: O(n*L), traversing array and comparing string
 * Space complexity: O(1)
 */

class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int sDist = Math.abs(i - startIndex);
                int cDist = n - sDist;

                res = Math.min(res, Math.min(sDist, cDist));
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}