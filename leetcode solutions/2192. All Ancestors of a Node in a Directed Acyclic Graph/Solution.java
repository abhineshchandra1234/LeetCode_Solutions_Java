/**
 * 2192. All Ancestors of a Node in a Directed Acyclic Graph
 * 
 * Intuition
 * 
 * we are given a positive integer n, representing n nodes in the graph from 0
 * to n-1
 * we are also given integer array edges, where edges[i] = [fromi, toi],
 * represents unidirectional edge from fromi to toi
 * we need to return a list answer where answeri is the anscestors of ith node
 * sorted in ascending order
 * From the question it is evident that we first need to create a graph
 * then we need to travel each node and its neighs and add them to res using dfs
 * to avoid repeated traversal we need a new visted array for each node to track
 * its ancestr properly.
 * we need sorted anscestor, for this we need to sort all ancestors, for all
 * nodes individually, there is no optimized way.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n^2*logn), we are traversing node and its neigh O(n), we
 * are sorting ancestors O(nlogn)
 * 
 * Space complexity: O(n^2), storing graph
 * 
 */
class Solution {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {

        List<List<Integer>> graph = new ArrayList();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        List<List<Integer>> res = new ArrayList();
        for (int i = 0; i < n; i++)
            res.add(new ArrayList());

        for (int i = 0; i < n; i++)
            dfs(res, new boolean[n], i, i, graph);

        for (int i = 0; i < n; i++)
            Collections.sort(res.get(i));

        return res;
    }

    private void dfs(List<List<Integer>> res, boolean[] visited, int parent, int curr, List<List<Integer>> graph) {
        visited[curr] = true;

        for (int des : graph.get(curr)) {
            if (!visited[des]) {
                res.get(des).add(parent);
                dfs(res, visited, parent, des, graph);
            }
        }
    }
}