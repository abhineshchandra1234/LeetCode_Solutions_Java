/**
 * 997. Find the Town Judge
 * 
 * Intuition
 * 
 * credits lee215
 * This is a directed graph problem
 * we can build a graph of all people
 * The people who has indegree - outdegree == n-1 is the judge
 * all people will trust judge indegree == n-1
 * Judge trust no one so outdegree == 0
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n), we are traversing trust and n once
 * 
 * Space complexity: O(n), graph for n people
 * 
 */
class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] count = new int[n + 1];
        for (int[] t : trust) {
            // outdegree
            count[t[0]]--;
            // indegree
            count[t[1]]++;
        }
        for (int i = 1; i <= n; i++)
            if (count[i] == n - 1)
                return i;
        return -1;
    }
}