// 3600. Maximize Spanning Tree Stability with Upgrades

/**
 * Intuition
 * we have used disjoint set here to construct spanning tree
 * First we are checking cycle between edges using DSU
 * Then we have taken binary search range from 1 to 2e5, For 2e5 it can happen
 * we need to upgrade it, which will become twice its strength
 * then we are simply applying binary search on mid, to check if spanning tree
 * is possible on mid
 * In the check function we are seeing if m==1, means we need to include the
 * edge, if curr edge strength is less than mid, we are returning false
 * otherwise adding it to the tree
 * if m==0, means its optional to include it
 * if curr edge strength is equal or greater than mid, add it to the tree
 * Otherwise if curr edge twice strength is equal or greater than mid, we will
 * add it to upgradeCandidates means we can optionally add it
 * No we are traversing upgradeCandidates, if the curr edge parents are not
 * equal and we have some k upgrades left, we will add it to the spanning tree
 * Now we simply traverse all nodes, if all are connected return true else false
 * for function check. connection we are checking with DSU.
 * Approach
 * 
 * Complexity
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */

class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public boolean union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent) {
            return false;
        }

        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else if (rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        } else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }

        return true;
    }
}

class Solution {

    private boolean check(int n, int[][] edges, int k, int mid) {
        DSU dsu = new DSU(n);

        List<int[]> upgradeCandidates = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int s = edge[2];
            int m = edge[3];

            if (m == 1) {
                if (s < mid) {
                    return false;
                }
                dsu.union(u, v);
            } else {
                if (s >= mid) {
                    dsu.union(u, v);
                } else if (2 * s >= mid) {
                    upgradeCandidates.add(new int[] { u, v });
                }
            }
        }

        for (int[] edge : upgradeCandidates) {
            int u = edge[0];
            int v = edge[1];

            if (dsu.find(u) != dsu.find(v)) {
                if (k <= 0) {
                    return false;
                }
                dsu.union(u, v);
                k--;
            }
        }

        int root = dsu.find(0);

        for (int node = 1; node < n; node++) {
            if (dsu.find(node) != root) {
                return false;
            }
        }

        return true;
    }

    public int maxStability(int n, int[][] edges, int k) {

        DSU dsu = new DSU(n);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int m = edge[3];

            if (m == 1) {
                if (dsu.find(u) == dsu.find(v)) {
                    return -1;
                }
                dsu.union(u, v);
            }
        }

        int result = -1;
        int l = 1;
        int r = (int) 2e5;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (check(n, edges, k, mid)) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return result;
    }
}