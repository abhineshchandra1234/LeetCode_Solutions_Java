/**
 * 1688. Count of Matches in Tournament
 * 
 * Intuition
 * Approach 1
 * 
 * we will solve this problem as it is given in the question, if the teams is
 * odd or even, n/2 matches will be played and added to res
 * Then (n+1)/2 will advance to next level, it will cover both the cases for odd
 * or even
 * 
 * Approach 2
 * 
 * In one match 1 team loses, so n-1 team loses in n-1 matches and that is the
 * ans.
 * TC - O(1)
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(logn)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int numberOfMatches(int n) {

        int res = 0;
        while (n > 1) {
            res += n / 2;
            n = (n + 1) / 2;
        }
        return res;
    }
}