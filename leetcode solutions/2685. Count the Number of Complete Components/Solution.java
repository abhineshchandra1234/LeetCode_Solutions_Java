// 2685. Count the Number of Complete Components

/**
 * Intuition
 * we will solve this problem using DFS
 * we will have a visited array for n nodes
 * we will traverse visited array, if curr node is visited we will skip
 * otherwise call dfs on curr node
 * each node will have 2 edges
 * we have info array which will save no of edges and vertices
 * if (v*v-1)/2 is equal to no of edges, then increase res by 1
 * means we have got 1 complete connected component
 * Later return res
 * Approach
 * 
 * Complexity
 * Time complexity: O(V+E)
 * Space complexity: O(V+E)
 */

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap();
        int res = 0;
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList()).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            int[] info = new int[2];
            dfs(i, adj, visited, info);

            if (info[0] * (info[0] - 1) == info[1])
                res++;
        }
        return res;
    }

    private void dfs(int i, Map<Integer, List<Integer>> adj, boolean[] visited, int[] info) {
        visited[i] = true;
        info[0]++;
        info[1] += adj.getOrDefault(i, new ArrayList()).size();

        for (int nigh : adj.getOrDefault(i, new ArrayList<>())) {
            if (!visited[nigh])
                dfs(nigh, adj, visited, info);
        }
    }
}