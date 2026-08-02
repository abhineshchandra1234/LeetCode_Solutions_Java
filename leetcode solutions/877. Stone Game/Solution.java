// 877. Stone Game

/**
 * Intuition
 * we will solve this problem using dp
 * we will have two ptrs one poiting to start and other pointing to end
 * if alice picks from start bob will pick from start (i+1,j) or end (i+1,j)
 * next alice will pick from start (i+2,j) or end (i+1,j-1)
 * we will take min of above two options,as both are playing optimally
 * similar will be the case when alice picks from end
 * we will take max of start and end and return as res
 * Approach
 * 
 * Complexity
 * Time complexity: O(n^2)
 * Space complexity: O(n^2)
 */

class Solution {
    int n;
    int[][] t = new int[501][501];

    public boolean stoneGame(int[] piles) {
        n = piles.length;
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        int sum = 0;
        for (int p : piles) {
            sum += p;
        }

        int aScore = solve(piles, 0, n - 1);
        return aScore > sum / 2;
    }

    private int solve(int[] piles, int i, int j) {
        if (i > j)
            return 0;

        if (t[i][j] != -1)
            return t[i][j];

        int chose_i = piles[i] + Math.min(solve(piles, i + 2, j),
                solve(piles, i + 1, j - 1));
        int chose_j = piles[j] + Math.min(solve(piles, i, j - 2),
                solve(piles, i + 1, j - 1));

        return t[i][j] = Math.max(chose_i, chose_j);
    }
}