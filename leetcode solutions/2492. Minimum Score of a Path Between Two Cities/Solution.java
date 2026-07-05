/**
 * 2492. Minimum Score of a Path Between Two Cities
 * 
 * approach-
 * This problem looks hard but can we easily solve using a disjoint set union
 * we will traverse through each road and connect it using DSU.
 * Then we will find parent for city 1.
 * Then we will traverse through roads and see if any city is connected to the
 * parent
 * If it is we will update res with its weight
 * DSU can contain cities that are not connected to the parent and has a group
 * of their own.
 * 
 * Time - O(n) (Union & find)
 * Space - O(n) (Union & find)
 */
class Solution {
    public class DSU {
        private int[] par;
        private int[] rank;

        public DSU(int n) {
            par = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++)
                par[i] = i;
        }

        // Path Compression
        public int find(int u) {
            if (u == par[u])
                return u;
            return par[u] = find(par[u]);
        }

        // Union By Rank
        public void connect(int u, int v) {
            u = find(u);
            v = find(v);
            if (rank[u] > rank[v])
                par[v] = u;
            else if (rank[u] < rank[v])
                par[u] = v;
            else {
                par[u] = v;
                rank[v]++;
            }
        }
    }

    public int minScore(int n, int[][] roads) {
        DSU d = new DSU(n + 1);
        for (int[] r : roads)
            d.connect(r[0], r[1]);
        int leader = d.find(1);

        // filter edges and update min edge weight
        int res = Integer.MAX_VALUE;
        for (int[] r : roads) {
            int u = d.find(r[0]), v = d.find(r[1]);
            if (u == leader || v == leader)
                res = Math.min(res, r[2]);
        }
        return res;
    }
}

// Approach 2

/**
 * Intuition
 * we will create a graph of all nodes
 * Then we will start dfs search from 1 node
 * it will start at 1 and end at n
 * And we will simply update res with min of res and distance
 * to avoid same node visitation again, we will use visited array
 * if any node is not visited, we will apply dfs on it too
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    public int minScore(int n, int[][] roads) {
        Map<Integer, List<int[]>> adj = new HashMap();

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int c = road[2];

            adj.computeIfAbsent(u, k -> new ArrayList()).add(new int[] { v, c });
            adj.computeIfAbsent(v, k -> new ArrayList()).add(new int[] { u, c });
        }

        // 1 based indexing
        boolean[] visited = new boolean[n + 1];
        int[] res = new int[] { Integer.MAX_VALUE };

        dfs(adj, 1, visited, res);
        return res[0];
    }

    void dfs(Map<Integer, List<int[]>> adj, int u, boolean[] visited, int[] res) {
        visited[u] = true;

        for (int[] edge : adj.get(u)) {
            int v = edge[0];
            int c = edge[1];

            res[0] = Math.min(res[0], c);

            if (!visited[v])
                dfs(adj, v, visited, res);
        }
    }
}