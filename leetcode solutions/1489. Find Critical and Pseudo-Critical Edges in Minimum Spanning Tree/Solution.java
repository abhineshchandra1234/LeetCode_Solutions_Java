/**
 * 1489. Find Critical and Pseudo-Critical Edges in Minimum Spanning Tree
 * 
 * Intuition
 * 
 * nanhi si jaan kita kaam kare :P, kaam bhi acha chaiyeh aur paise bhi nahi
 * dena hai
 * we will solve this problem using Kruskal's Algorithm
 * If we provide edges in ascending order to the algorithm it return minimum
 * spanning tree with minimum weight.
 * So we will sort the edges on the basis of weight, we will also add original
 * index to it, as we need to return it in result.
 * Then we will traverse through all edges and first check critical edge, if its
 * not then check for pseudo-critical edge
 * A edge will be critical if we skip it and we either get disconnected graph or
 * weigh > mst_weigh
 * A edge will be pseudo critical if we add the curr edge to the graph still
 * weigh == mst_weigh, means it has no impact on mst_weigh
 * 
 * Complexity
 * 
 * Time complexity: O(m*m)
 * 
 * Space complexity:
 * 
 * O(m), storing the edge alongwith index.
 * 
 */
class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {

        // add index to edges for tracking and for res
        int m = edges.length;
        int[][] newEdges = new int[m][4];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                newEdges[i][j] = edges[i][j];
            }
            newEdges[i][3] = i;
        }

        // sort edges based on weight
        Arrays.sort(newEdges, (a, b) -> (a[2] - b[2]));

        // find mst weight using union-find
        DSU d = new DSU(n);
        int mst_weigh = 0;
        for (int[] edge : newEdges) {
            if (d.union(edge[0], edge[1]))
                mst_weigh += edge[2];
        }

        // create res list
        List<List<Integer>> res = new ArrayList();
        for (int i = 0; i < 2; i++)
            res.add(new ArrayList());

        // check edge for critical and pseudo-critical
        for (int i = 0; i < m; i++) {

            // try without curr edge
            DSU dIgn = new DSU(n);
            int weighIgn = 0;
            for (int j = 0; j < m; j++) {
                if (i != j && dIgn.union(newEdges[j][0], newEdges[j][1]))
                    weighIgn += newEdges[j][2];
            }

            // edge is critical if graph is disconnected
            // or total weight is greater than mst_weigh
            if (!dIgn.united() || weighIgn > mst_weigh)
                res.get(0).add(newEdges[i][3]);
            else {
                // try with curr edge
                DSU dInc = new DSU(n);
                dInc.union(newEdges[i][0], newEdges[i][1]);
                int weighInc = newEdges[i][2];
                for (int j = 0; j < m; j++) {
                    if (i != j && dInc.union(newEdges[j][0], newEdges[j][1]))
                        weighInc += newEdges[j][2];
                }
                // if weigh is same as mst_weigh, it is pseudo-critical
                if (weighInc == mst_weigh)
                    res.get(1).add(newEdges[i][3]);
            }
        }
        return res;
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