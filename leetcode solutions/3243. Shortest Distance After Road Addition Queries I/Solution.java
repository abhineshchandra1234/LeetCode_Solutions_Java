/**
 * 3243. Shortest Distance After Road Addition Queries I
 * 
 * Intuition
 * brute force is the solution here
 * we will first construct graph, using one-directional path
 * Then we will traverse queries, for each query add the new path in the graph
 * and apply bfs to find the distance between 0 and n-1 nodes using the new
 * graph
 * to avoid repetition of nodes, keep a visited set
 * In bfs add node and distance, and for each new node increase distance by 1
 * Approach
 * 
 * Complexity
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */
class Solution {

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {

        List<List<Integer>> graph = new ArrayList();
        List<Integer> ans = new ArrayList();

        for (int i = 0; i < n - 1; i++) {
            graph.add(new ArrayList());
            graph.get(i).add(i + 1);
        }

        for (int[] query : queries) {
            graph.get(query[0]).add(query[1]);
            ans.add(bfs(n, graph));
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public int bfs(int n, List<List<Integer>> graph) {
        Queue<int[]> q = new LinkedList();
        q.add(new int[] { 0, 0 });
        Set<Integer> vis = new HashSet();
        vis.add(0);

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curr = node[0];
            int dis = node[1];

            if (curr == n - 1)
                return dis;

            for (int neig : graph.get(curr)) {
                if (!vis.contains(neig)) {
                    q.add(new int[] { neig, dis + 1 });
                    vis.add(neig);
                }
            }
        }

        return -1;
    }
}