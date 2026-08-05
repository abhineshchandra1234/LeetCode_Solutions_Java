// 3310. Remove Methods From Project

/**
 * Intuition
 * we will solve this problem through BFS
 * we will first create a graph of directed edge using unordered map
 * Then we will apply BFS on suspicious node
 * All neighbors of suspicious node will be marked as suspicious
 * Then we will traverse all the nodes, if the curr node is suspicious and has
 * indegree greater than 0, means theres an edge from outside the group
 * we cannot remove suspicious nodes and return all the nodes
 * Otherwise we will just add all the suspicious nodes to res and return the res
 * Approach
 * 
 * Complexity
 * Time complexity: O(V+E)
 * Space complexity: O(V+E)
 */

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        Map<Integer, List<Integer>> adj = new HashMap();
        int[] inDegree = new int[n];
        boolean[] suspicious = new boolean[n];

        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];

            adj.computeIfAbsent(u, x -> new ArrayList()).add(v);
            inDegree[v]++;
        }

        Queue<Integer> q = new LinkedList();
        q.add(k);
        suspicious[k] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int neigh : adj.getOrDefault(curr, Collections.emptyList())) {
                inDegree[neigh]--;

                if (!suspicious[neigh]) {
                    suspicious[neigh] = true;
                    q.add(neigh);
                }
            }
        }

        List<Integer> res = new ArrayList();
        boolean cannotRemove = false;

        for (int i = 0; i < n; i++) {
            if (suspicious[i] && inDegree[i] > 0) {
                cannotRemove = true;
                break;
            }
            if (!suspicious[i])
                res.add(i);
        }

        if (cannotRemove) {
            List<Integer> all = new ArrayList();
            for (int i = 0; i < n; i++)
                all.add(i);
            return all;
        }

        return res;
    }
}