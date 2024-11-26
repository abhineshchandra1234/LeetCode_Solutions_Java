/**
 * 2924. Find Champion II
 * 
 * Intuition
 * we can solve this problem through indegree
 * we need to find indegree for all nodes
 * if more than one node has indegree 0, we will return -1
 * otherwise if we have only one champion, we will return that node
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {

    public int findChampion(int n, int[][] edges) {

        int[] indegree = new int[n];
        int champ = -1;
        int count = 0;

        for (int[] edge : edges)
            indegree[edge[1]]++;

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                champ = i;
                count++;
            }
        }

        return count > 1 ? -1 : champ;
    }
}