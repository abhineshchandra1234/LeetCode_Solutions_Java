/**
 * 547. Number of Provinces
 * 
 * Intuition
 * we will solve this problem through dfs.
 * It would have same time complexity as other methods but we need not create a
 * graph for traversal.
 * we will traverse through each node and its neighbors and increase count.
 * we will also mark curr node and its neighbors as visited to form a province.
 * 
 * Complexity
 * Time complexity:
 * O(n*n), each node is visited once
 * 
 * Space complexity:
 * 
 * O(n), visited node count
 */
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, int[] visited, int i) {
        int n = isConnected.length;
        for (int j = 0; j < n; j++) {
            if (isConnected[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(isConnected, visited, j);
            }
        }
    }
}