/**
 * 1971. Find if Path Exists in Graph
 * 
 * Intuition
 * 
 * Graph can be traversed using BFS, DFS or union find. Here we have used union
 * find to solve this problem
 * we have taken union of all nodes, if source and destination belong in the
 * same group ie have same parent return true else false.
 * Using DFS or BFS, first we need to create a graph, then start traversing from
 * source and see if we can reach destination.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(V+E)
 * 
 * Space complexity: O(V+E)
 * 
 */
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        DSU d = new DSU(n);

        for (int[] edge : edges)
            d.union(edge[0], edge[1]);
        return d.findParent(source) == d.findParent(destination);
    }

    class DSU {

        int rank[];
        int parent[];

        DSU(int n) {
            rank = new int[n + 1];
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++)
                parent[i] = i;
        }

        int findParent(int node) {
            if (parent[node] == node)
                return node;
            return parent[node] = findParent(parent[node]);
        }

        boolean union(int x, int y) {
            int px = findParent(x);
            int py = findParent(y);

            if (px == py)
                return false;

            if (rank[px] < rank[py])
                parent[px] = py;
            else if (rank[py] < rank[px])
                parent[py] = px;
            else {
                parent[py] = px;
                rank[px]++;
            }

            return true;
        }
    }
}