/**
 * 1579. Remove Max Number of Edges to Keep Graph Fully Traversable
 * 
 * Intuition
 * 
 * we are given n nodes of an undirected graph
 * we are also given edges array where edgei = [typei, ui, vi]
 * which represent there is a bidirectional edge of a particular type between u
 * & v
 * first type of edge can be traversed only by alice
 * second type of edge can be traversed only by bob
 * third type edge can be traversed by both
 * we need to return count of max no of edges we can remove, so that whole graph
 * is still traversable by both alice and bob
 * If above is not possible return -1
 * 
 * Approach
 * 
 * we will create two groups for alice and bob using union-find operation
 * if both have single parent ie graph is traversable, return ans = total edges
 * - unique paths else -1
 * for unique paths we need to do union of nodes of path 3 first in both the
 * groups, so that we can maximize the extra edge removal
 * we have used "|" operator bcs we need to compute right hand side too apart
 * from the result. otherwise it will return after first true condition.
 * 
 * Complexity
 * 
 * Time complexity: O(n), create union of two groups
 * 
 * Space complexity: O(n), store union
 * 
 */

class Solution {

    public int maxNumEdgesToRemove(int n, int[][] edges) {

        DSU alice = new DSU(n);
        DSU bob = new DSU(n);

        int unique = 0;
        for (int[] edge : edges)
            if (edge[0] == 3 && (alice.union(edge[1], edge[2]) | bob.union(edge[1], edge[2])))
                unique++;

        for (int[] edge : edges) {
            if (edge[0] == 1 && alice.union(edge[1], edge[2]))
                unique++;
            else if (edge[0] == 2 && bob.union(edge[1], edge[2]))
                unique++;
        }

        return alice.united() && bob.united() ? edges.length - unique : -1;

    }

    class DSU {

        int rank[];
        int parent[];
        int distinctComponent;

        DSU(int n) {
            rank = new int[n + 1];
            parent = new int[n + 1];
            distinctComponent = n;
            for (int i = 1; i <= n; i++)
                parent[i] = i;
        }

        boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py)
                return false;

            if (rank[px] < rank[py])
                parent[px] = py;
            else if (rank[px] > rank[py])
                parent[py] = px;
            else {
                parent[px] = py;
                rank[py]++;
            }

            distinctComponent--;
            return true;
        }

        int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }

        boolean united() {
            return distinctComponent == 1;
        }
    }
}