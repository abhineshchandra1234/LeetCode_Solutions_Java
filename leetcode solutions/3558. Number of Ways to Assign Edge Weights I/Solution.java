// 3558. Number of Ways to Assign Edge Weights I

/**
 * Intuition
 * we will first create a graph using adjacency list
 * then we would find max depth of the graph using dfs
 * then we will just return no of ways whose total sum is odd
 * total no of ways is 2^max depth and total no of odd ways is 2^max depth - 1
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    long mod = (long) (1e9 + 7);

    public int assignEdgeWeights(int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.computeIfAbsent(u, k -> new ArrayList()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList()).add(u);
        }
        int maxDepth = getMaxDepth(adj, 1, 0);
        return (int) power(2, maxDepth - 1);
    }

    private int getMaxDepth(Map<Integer, List<Integer>> adj, int node, int parent) {
        int depth = 0;
        for (int neigh : adj.getOrDefault(node, new ArrayList<>())) {
            if (neigh == parent)
                continue;
            depth = Math.max(depth, getMaxDepth(adj, neigh, node) + 1);
        }
        return depth;
    }

    private long power(long base, long exponent) {
        if (exponent == 0)
            return 1;
        long half = power(base, exponent / 2);
        long res = (half * half) % mod;
        if (exponent % 2 == 1)
            res = (res * base) % mod;
        return res;
    }
}