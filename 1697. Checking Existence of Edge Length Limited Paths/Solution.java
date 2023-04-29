/**
 * 1697. Checking Existence of Edge Length Limited Paths
 * 
 * Intuition
 * For connected component we use bfs, dfs & union.
 * Here for every query we will need to do bfs and dfs to construct graph, which
 * is not good
 * We can use union find to construct graph and build on top of it for each new
 * query.
 * In the question we have been given for each query we need to check if there
 * is a path between the nodes and all edges in the path is less than target.
 * we can easily solve this by taking union of all nodes whose edges are less
 * than target.
 * If the nodes given in the query has same parent ie they belong to same group
 * whose edge is less than target, then we can return true.
 * To optimise it we have sorted queries based on target and nodes based on
 * thier edges, to help in calculating bigger results.
 * each query has different target, same with nodes
 * we have added extra column of index to query to help us store result.
 * 
 * Complexity
 * Time complexity: O(nlogn)
 * O(nlogn) + O(V+E)
 * 
 * For sorting and traversing queries and edges
 * 
 * DSU takes O(1) time
 * 
 * Space complexity: O(n)
 * 
 * For DSU
 */
class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {

        DSU dsu = new DSU(n);
        for (int i = 0; i < queries.length; i++)
            queries[i] = new int[] { queries[i][0], queries[i][1], queries[i][2], i };
        Arrays.sort(queries, (a, b) -> (a[2] - b[2]));
        Arrays.sort(edgeList, (a, b) -> (a[2] - b[2]));
        int i = 0;
        boolean[] res = new boolean[queries.length];
        for (int[] q : queries) {
            while (i < edgeList.length && edgeList[i][2] < q[2]) {
                dsu.union(edgeList[i][0], edgeList[i][1]);
                i++;
            }
            if (dsu.findParent(q[0]) == dsu.findParent(q[1]))
                res[q[3]] = true;
        }
        return res;
    }

    class DSU {
        int rank[];
        int parent[];

        DSU(int n) {
            rank = new int[n + 1];
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
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
            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[px] = py;
                rank[py]++;
            }
            return true;
        }
    }
}