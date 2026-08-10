// 1510. Stone Game IV

/**
 * Intuition
 * we will solve this problem through recursion plus memoization
 * every player can pick 1^2 , 2^2, 3^2 etc no of stones
 * so left stones will be n - 1^2 or n - 2^2 so on
 * so first alice will pick k^2 no of stones where k^2 will vary from 1 to n
 * bob will pick n - k^2 no of stones through recursion, if he loses we will
 * assign 1 to res means alice wins and return true
 * if bob wins we will assign 0 to res and return false means alice wins
 * Note - same recursion fuction will be used by both alice and bob
 * Approach
 * 
 * Complexity
 * Time complexity: O(n*sqrt(n))
 * Space complexity: O(n)
 */

class Solution {
    int[] t;

    public boolean winnerSquareGame(int n) {
        t = new int[n + 1];
        Arrays.fill(t, -1);
        return solve(n);
    }

    private boolean solve(int n) {
        if (n == 0)
            return false;
        if (t[n] != -1)
            return t[n] == 1 ? true : false;
        for (int k = 1; k * k <= n; k++) {
            if (solve(n - k * k) == false) {
                t[n] = 1;
                return true;
            }
        }
        t[n] = 0;
        return false;
    }
}