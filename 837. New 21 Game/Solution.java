/**
 * 837. New 21 Game
 * 
 * Intuition
 * First of all what is this :P. First find the person who created this question
 * and give my blessings also.
 * We will solve this problem using dp
 * The questions says alice has to start from 0 points and she can pick any
 * points from 1 to W.
 * If the score ie points sum exceed k she has to stop picking coins.
 * Now we have to return probabilty for the score<=n.
 * Max score she can reach is k-1 + W
 * Suppose she is at k-1 score if she picks 1 point she will reach k and she
 * cannot pick anymore. if she picks W point she will reach k-1 + W and she
 * cannot pick anymore.
 * Input: n = 21, k = 17, maxPts = 10
 * d[21] is the probality to reach 21 score.
 * we can reach d[21] from d[11] by picking max point 10.
 * It covers cond i-W>=0 and make our calculation easier
 * d[21] = d[20]*p(1) + d[19]*p(2) + d[18]*p(3) +.. +d[11]*p(10)
 * since all have equal probability
 * d[21] = d[20]*1/W + d[19]*1/W +.. +d[11]*1/W
 * d[21] = 1/W*(d[20]+ d[19]+.. +d[11])
 * Now alice is not allowed to pick points above score k
 * so we will remove dp[17] to dp[20]
 * this covers cond i<k
 * so our result will be d[21] = 1/W*(d[16]+ d[15]+.. +d[11])
 * till k-1 alice has the option to pick points so we will build our sum but
 * from k or above alice cannot pick anymore points and we will remove extra
 * sum.
 * c = 1/W
 * D[16] start = c * (D[6] + D[7] +..+D[15]) = c*D[15]
 * D[16] end = c * (D[7]+ D[8]+..+D[15]) = c*(D[15]-D[6])
 * D[17] start = c * (D[7] +D[8]+..+D[16]) = c*D[16]
 * D[17] end = c * (D[8]+D[9]+..+D[16]) = c*(D[16]-D[7])
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public double new21Game(int n, int k, int W) {

        if (k == 0 || n >= k + W)
            return 1;
        double dp[] = new double[n + 1], Wsum = 1, res = 0;
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = Wsum / W;
            if (i < k)
                Wsum += dp[i];
            else
                res += dp[i];

            if (i - W >= 0)
                Wsum -= dp[i - W];
        }
        return res;
    }
}