// 3129. Find All Possible Stable Binary Arrays I

/**
 * Intuition
 * this problem difficulty should be hard
 * we can create a tree for all 0s and 1s combination
 * we can start with 0 then followed by 1 and vice-versa incase of 1
 * we can have continous 0s with count min(zerosLeft,limit), similarly incase of
 * 1
 * our base case will be when we have exhausted all 0s and 1s
 * we have used memoization, to remember our result
 * our final result will be sum of startWithOne and startWithZero modulo m
 * Approach
 * 
 * Complexity
 * Time complexity: O(one*zero*limit)
 * Space complexity: O(one*zero)
 */

class Solution {
    int M = (int) 1e9 + 7;
    int[][][] t = new int[201][201][2];

    int solve(int onesLeft, int zerosLeft, int lastWasOne, int limit) {
        if (onesLeft == 0 && zerosLeft == 0)
            return 1;
        if (t[onesLeft][zerosLeft][lastWasOne] != -1)
            return t[onesLeft][zerosLeft][lastWasOne];

        int result = 0;
        if (lastWasOne == 1) { // explore 0s
            for (int len = 1; len <= Math.min(zerosLeft, limit); len++) {
                result = (result + solve(onesLeft, zerosLeft - len, 0, limit)) % M;
            }
        } else { // explore 1s
            for (int len = 1; len <= Math.min(onesLeft, limit); len++) {
                result = (result + solve(onesLeft - len, zerosLeft, 1, limit)) % M;
            }
        }
        return t[onesLeft][zerosLeft][lastWasOne] = result;
    }

    public int numberOfStableArrays(int zero, int one, int limit) {
        for (int[][] a : t)
            for (int[] b : a)
                Arrays.fill(b, -1);
        int startWithOne = solve(one, zero, 0, limit);
        int startWithZero = solve(one, zero, 1, limit);
        return (startWithOne + startWithZero) % M;
    }
}