/**
 * 279. Perfect Squares
 * 
 * Intuition
 * 
 * credits zhukov
 * we will solve this problem through dp
 * Our base case is dp[0]=0, there are 0 no of perfect sqaures whose sum is 0
 * dp[n] = Math.min(dp[n], dp[n-j*j]+1), where 1<=j*j<=n
 * +1 signifies we have got 1 result
 * 
 * Approach
 * 
 * Input: n = 4
 * Output: 1
 * 1-> min(infinity, dp[3]+1) -> min(infinity, 3+1) -> 4
 * 2 -> min(infinity, dp[0]+1) -> min(infinity, 0+1) -> 1
 * 
 * we are trying to construct the res using all nos from 1 to sqrt(n)
 * 
 * Complexity
 * 
 * Time complexity: O(n∗sqrt(n)), outer loop will for n
 * times and inner loop will run for sqrt(n) times
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public int numSquares(int n) {

        int[] count = new int[n + 1];
        Arrays.fill(count, Integer.MAX_VALUE);
        count[0] = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j * j <= i; j++)
                count[i] = Math.min(count[i], count[i - j * j] + 1);

        return count[n];
    }
}