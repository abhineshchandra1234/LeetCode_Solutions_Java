/**
 * 1601. Maximum Number of Achievable Transfer Requests
 * 
 * Intuition
 * 
 * Sayari :P Hazaaron khwahishen aisi ke har khwahish pe dam nikle Bohat niklay
 * mere armaan, lekin phir bhi kam nikle
 * credits - CHEN0426
 * If we dry run the question we will find for each buildings in the valid
 * combination, indegree is 0.
 * Means no of employees moving out is the same no coming in.
 * like for Input: n = 5, requests = [[0,1],[1,0],[0,1],[1,2],[2,0],[3,4]]
 * if we traverse all buildings and do not choose 3,4 buildings. 0,1,2 building
 * will form a valid combination.
 * For each request we have a choice to pick or not. It is like a knapsack
 * problem.
 * If we get valid combination we are updating ans with Max of valid building
 * count.
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(2^n), n is no of request
 * 
 * Space complexity:
 * 
 * O(2^n), recursive call stack
 * 
 */
class Solution {

    int max = 0;

    public int maximumRequests(int n, int[][] requests) {
        helper(requests, 0, new int[n], 0);
        return max;
    }

    private void helper(int[][] requests, int index, int[] count, int num) {
        // Traverse all n buildings to see if they are all 0. (means balanced)
        if (index == requests.length) {
            for (int i : count)
                if (i != 0)
                    return;
            max = Math.max(max, num);
            return;
        }
        // Choose this request
        count[requests[index][0]]++;
        count[requests[index][1]]--;
        helper(requests, index + 1, count, num + 1);
        count[requests[index][0]]--;
        count[requests[index][1]]++;

        // Not Choose the request
        helper(requests, index + 1, count, num);
    }
}