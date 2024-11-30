/**
 * 2097. Valid Arrangement of Pairs
 * 
 * Intuition
 * we can solve this problem through Hierholzer's Algorithm
 * we will use this algorithm to find euler path,
 * In euler path we visit all edges only once, but start and end at different
 * vertices
 * According to alogirthm, start node is equal to outdgree-indgree==1
 * 
 * Approach
 * First construct graph, and also find indegree and outdegree
 * using indegree and outdegree find start node
 * Push start node to stack
 * we will use dfs for each node
 * use top node of the stack and add all its neigh to stack and remove them from
 * graph
 * if the top node has no neighs, computation for it is done, add it to euler
 * path and pop it from stack
 * later reverse the euler path and return it, as start node will be at bottom
 * of stack
 * 
 * Complexity
 * Time complexity: O(V+E), DFS
 * For each configuration, BFS is visiting m*n states
 * Space complexity: O(V+E), Graph
 */
class Solution {

    public int[][] validArrangement(int[][] pairs) {

        Map<Integer, List<Integer>> g = new HashMap();
        Map<Integer, Integer> indegree = new HashMap();
        Map<Integer, Integer> outdegree = new HashMap();

        for (int[] pair : pairs) {
            int u = pair[0];
            int v = pair[1];

            g.computeIfAbsent(u, k -> new ArrayList()).add(v);
            outdegree.put(u, outdegree.getOrDefault(u, 0) + 1);
            indegree.put(v, indegree.getOrDefault(v, 0) + 1);
        }

        int start = pairs[0][0];
        for (int node : g.keySet()) {
            if (outdegree.getOrDefault(node, 0) - indegree.getOrDefault(node, 0) == 1) {
                start = node;
                break;
            }
        }

        List<Integer> path = new ArrayList();
        Stack<Integer> s = new Stack();
        s.push(start);

        while (!s.isEmpty()) {
            int curr = s.peek();
            if (g.containsKey(curr) && !g.get(curr).isEmpty()) {
                int neigh = g.get(curr).remove(g.get(curr).size() - 1);
                s.push(neigh);
            } else {
                path.add(curr);
                s.pop();
            }
        }

        Collections.reverse(path);
        int[][] res = new int[path.size() - 1][2];

        for (int i = 0; i < path.size() - 1; i++) {
            res[i][0] = path.get(i);
            res[i][1] = path.get(i + 1);
        }

        return res;
    }
}