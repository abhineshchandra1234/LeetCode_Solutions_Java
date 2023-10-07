/**
 * 1420. Build Array Where You Can Find The Maximum Exactly K Comparisons
 * 
 * Intuition
 * 
 * credits mik
 * It is a version of longest increasing sub-sequence
 * we will solve this problem using bottom-up approach using recursion and we
 * will use memoization to avoid repeated calculations
 * For every index you will can put any no from 1 to max or m
 * if we reach idx n and cost is K we got one valid case
 * if the curr element is greater than maxSofar we got new max and it will
 * increase the cost for the next idx calculation
 * If the curr element is lower or equal, maxSoFar & cost will remain unchanged
 * for next idx calculation.
 * Finally we will return result at (0,0,0) as result will be first calculated
 * at (n,k,m) then upwards.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity:
 * 
 * O(m*n*k), dp states
 * 
 * Space complexity:
 * 
 * O(m*n*k), dp space
 * 
 */
class Solution {
    int N, M, K;
    int mod = (int) 1e9 + 7;
    Integer[][][] t;

    public int numOfArrays(int n, int m, int k) {
        N = n;
        M = m;
        K = k;
        t = new Integer[51][51][101];
        return solve(0, 0, 0);
    }

    public int solve(int idx, int searchCost, int maxSoFar) {
        if (idx == N) {
            if (searchCost == K) {
                return 1;
            }
            return 0;
        }

        if (t[idx][searchCost][maxSoFar] != null)
            return t[idx][searchCost][maxSoFar];

        int result = 0;

        for (int i = 1; i <= M; i++) {
            if (i > maxSoFar)
                result = (result + solve(idx + 1, searchCost + 1, i)) % mod;
            else
                result = (result + solve(idx + 1, searchCost, maxSoFar)) % mod;
        }

        return t[idx][searchCost][maxSoFar] = result % mod;
    }
}