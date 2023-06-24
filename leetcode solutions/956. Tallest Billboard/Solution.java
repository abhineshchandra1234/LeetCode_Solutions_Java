/**
 * 956. Tallest Billboard
 * Intuition
 * 
 * credits aryan
 * It is a 0/1 knapsack problem. We have option to not pick a rod or to pick a
 * rod and add it to left or right stand.
 * We will solve it first through naive recursion approach in which we will have
 * above three options.
 * We will take max of these options and return it.
 * But it will lead to TLE, so will optimize it
 * 
 * Complexity
 * 
 * Time complexity: O(i*s1*s2) ->20*5k*5k
 * 
 * Space complexity: O(i*s1*s2) -> recursive stack
 * 
 */
class Solution {
    public int tallestBillboard(int[] rods) {

        return solve(0, 0, 0, rods);
    }

    int solve(int i, int s1, int s2, int[] rods) {

        int n = rods.length;
        if (i == n) {
            if (s1 == s2)
                return s1;
            return 0;
        }

        int op1 = solve(i + 1, s1, s2, rods);
        int op2 = solve(i + 1, s1 + rods[i], s2, rods);
        int op3 = solve(i + 1, s1, s2 + rods[i], rods);

        return Math.max(op1, Math.max(op2, op3));
    }
}

/**
 * 
 * Intuition 2
 * 
 * we will optimize it first by reducing states and then by avoiding repetative
 * computation by using dp.
 * we can use diff of s1 - s2. Instead of s1 & s2
 * If we add rod to left stand diff will be s1+rod[i] - s2 = diff + rod[i]
 * If we add rod to right stand diff will be
 * 
 * s1 - (s2+rod[i])
 * s1 - s2 - rod[i]
 * diff - rod[i]
 * 
 * the three option will remain same and we will return the max of it.
 * 
 * Approach
 * 
 * we are using hashing concept also here by adding 5k to diff
 * s1 - s2 can be -5k where s1 is 0 and s2 is 5k
 * before hashing -5k<=diff<=5k
 * after hashing 0<=diff<=2*5k
 * we need to pick the rod once in either op1 or op2.
 * If we pick it again in op2, it will be add more to result as it was already
 * selected.
 * if diff==0 then we dont want to add more to the result so we return 0.
 * else we add -infinity to result to make it invalid.
 * 
 * Complexity
 * 
 * Time complexity: O(i*s) ->20*2*5k
 * 
 * Space complexity: O(i*s)
 * 
 * Just use dp to determine it
 */
class Solution {

    Integer[][] dp;
    int offset = 5000;

    public int tallestBillboard(int[] rods) {

        dp = new Integer[21][2 * offset + 1];
        int ans = solve(0, 0, rods);
        if (ans < 0)
            return 0;
        return ans;
    }

    int solve(int i, int diff, int[] rods) {
        if (i == rods.length) {
            if (diff == 0)
                return 0;
            return Integer.MIN_VALUE;
        }

        if (dp[i][diff + offset] != null)
            return dp[i][diff + offset];

        int op1 = solve(i + 1, diff, rods);
        int op2 = rods[i] + solve(i + 1, diff + rods[i], rods);
        int op3 = solve(i + 1, diff - rods[i], rods);
        return dp[i][diff + offset] = Math.max(op1, Math.max(op2, op3));
    }
}
