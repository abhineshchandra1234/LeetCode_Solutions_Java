/**
 * 310. Minimum Height Trees
 * 
 * Intuition
 * 
 * we will solve this problem through topological sorting
 * There can be 1 or 2 roots max for MHTs.
 * If there are 3 nodes, we need to again calculate MHTs and discard one of them
 * we will keep discarding leaves till we get less than 2 nodes, and that will
 * be our answer
 * 
 * Approach
 * 
 * we will first create a graph
 * nodes whose edges or indegree is 1 are leaves
 * we will run a loop till nodes are greater than 2
 * we will discard leave count from nodes count
 * Then we will traverse leaves, and remove edges from its vertex, if the vertex
 * has indegree or edges 1, it is a leave node and will be added in newLeaf
 * At last we will assign newLeaf to leave and continue the process.
 * Finally we will get 2 or 1 root.
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 1)
            return Collections.singletonList(0);

        List<List<Integer>> adj = new ArrayList();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList();
        for (int i = 0; i < n; i++)
            if (adj.get(i).size() == 1)
                leaves.add(i);

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaf = new ArrayList();
            for (int i : leaves) {
                int j = adj.get(i).get(0);
                adj.get(j).remove(Integer.valueOf(i));
                if (adj.get(j).size() == 1)
                    newLeaf.add(j);
            }
            leaves = newLeaf;
        }

        return leaves;
    }
}