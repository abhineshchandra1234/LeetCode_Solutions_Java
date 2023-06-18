/**
 * 1579. Remove Max Number of Edges to Keep Graph Fully Traversable
 * 
 * Intuition
 * Let first understand the question.
 * It is given alice and bob should be able to traverse all nodes either through
 * common path or their own path
 * Note - they cannot use each other path for traversal
 * We will solve this using DSU. We will create two groups one for each alice
 * and bob.
 * If alice group and bob group contain all n nodes means both are able to
 * traverse all the nodes. Then we can proceed to remove any extra path if any.
 * If either of the group doesnt contain n nodes means one of them cannot
 * traverse all nodes and we will return -1.
 * to create group we can traverse all edges and do union find operation.
 * we need to priortize common path, so that we can find extra path
 * extra path = edges.length - unique paths
 * 
 * Approach
 * to avoid sorting, and reduce complexity to O(n) traverse edges for type 3
 * seperately.
 * we have used "|" operator bcs we need to compute right hand side too apart
 * from the result.
 * 
 * Complexity
 * Time complexity:
 * O(nlogn) for sorting
 * 
 * Space complexity:
 * 
 * O(n) for DSU
 */
class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {

        Arrays.sort(edges, (a, b) -> b[0] - a[0]);
        DSU dsu_alice = new DSU(n);
        DSU dsu_bob = new DSU(n);
        int edgeAdd = 0;

        for (int[] edge : edges) {
            int type = edge[0];
            int a = edge[1];
            int b = edge[2];

            switch (type) {
                case 3:
                    if (dsu_alice.union(a, b) | dsu_bob.union(a, b))
                        edgeAdd++;
                    break;
                case 2:
                    if (dsu_bob.union(a, b))
                        edgeAdd++;
                    break;
                case 1:
                    if (dsu_alice.union(a, b))
                        edgeAdd++;
                    break;
            }
        }
        return (dsu_alice.united() && dsu_bob.united()) ? edges.length - edgeAdd : -1;
    }

    class DSU {
        int rank[];
        int parent[];
        int distinctComponents;

        DSU(int n) {
            rank = new int[n + 1];
            parent = new int[n + 1];
            distinctComponents = n;
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
            distinctComponents--;
            return true;
        }

        boolean united() {
            return distinctComponents == 1;
        }
    }
}