/**
 * 1208. Get Equal Substrings Within Budget
 * 
 * Intuition
 * 
 * we will solve this problem through sliding window
 * we will expand the window by adding sum of curr nos to curr_cost
 * we will keep shrinking the window till the curr_cost is greater than maxCost
 * Now we have suitable window whose curr_cost<=maxCost, we will update the res
 * with its length
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
    public int equalSubstring(String s, String t, int maxCost) {

        int n = s.length();
        int curr_cost = 0, res = 0;

        for (int end = 0, start = 0; end < n; end++) {

            curr_cost += Math.abs(s.charAt(end) - t.charAt(end));

            while (curr_cost > maxCost) {
                curr_cost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }

            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}