// 2463. Minimum Total Distance Traveled

/**
 * Intuition
 * we will first sort robot and factory array based on their positions or index
 * we do this so that we can send robot to nearest factory
 * we have taken multiple index for each robot based on their limit
 * we taken recursion now for further computation
 * we have taken first robot and first factory and took their diff in takeFac
 * and used recursion to solve next robot and next factory
 * In skipFac we have skipped the curr factory and took the next factory
 * At last we are taking the min of takeFac and skipFac
 * Approach
 * 
 * Complexity
 * Time complexity: O(m*n)
 * Space complexity: O(m*n)
 */

class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        int m = robot.size();

        List<Integer> pos = new ArrayList();
        for (int[] f : factory) {
            int idx = f[0];
            int limit = f[1];
            for (int j = 0; j < limit; j++)
                pos.add(idx);
        }

        int n = pos.size();
        long[][] memo = new long[m + 1][n + 1];
        for (long[] row : memo)
            Arrays.fill(row, -1);

        return solve(0, 0, robot, pos, memo);
    }

    private long solve(int ri, int fi, List<Integer> robot, List<Integer> pos, long[][] memo) {
        if (ri >= robot.size())
            return 0;
        if (fi >= pos.size())
            return (long) 1e12;
        if (memo[ri][fi] != -1)
            return memo[ri][fi];

        long takeFac = Math.abs(robot.get(ri) - pos.get(fi)) +
                solve(ri + 1, fi + 1, robot, pos, memo);
        long skipFac = solve(ri, fi + 1, robot, pos, memo);

        return memo[ri][fi] = Math.min(takeFac, skipFac);
    }
}