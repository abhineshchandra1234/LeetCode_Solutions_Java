/**
 * 1137. N-th Tribonacci Number
 * 
 * Intuition
 * 
 * any nth no in the series is the sum of prev three nos
 * our base values will be nos from 0 to 2
 * we can use three variables representing base values to solve this problem by
 * running a loop from 3..n and updating the variables
 * we can also use a fixed size array of size 3 representing base values to
 * calculate new no, new no will be stored at i%3 to keep array size in check.
 * 
 * Note - It is confusing to update three variables so fixed sized array is
 * better approach
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int tribonacci(int n) {

        int dp[] = { 0, 1, 1 };
        for (int i = 3; i <= n; i++)
            dp[i % 3] = dp[0] + dp[1] + dp[2];
        return dp[n % 3];
    }
}