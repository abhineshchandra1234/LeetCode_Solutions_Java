/**
 * 802. Find Eventual Safe States
 * 
 * Intuition
 * 
 * credits kiranpalsingh1806
 * we will use topogical sort to solve this
 * we will first create a graph with adjacency list
 * like 0 has edge to 1,2 nodes. so 0 is dependent on 1,2 and we will add 0 as
 * edge to nodes 1,2.
 * 1-> 0, 2->0
 * We will first add nodes whose outdegree is 0 to queue.
 * Now we will pop nodes from queue and add it to safe nodes
 * Now we will decrease the out degree of its child nodes.
 * If child nodes outdegree becomes 0 add them to queue.
 * Once the queue is empty, means there are no more nodes with outdegree as 0
 * and we will stop the computation.
 * 
 * Approach
 * 
 * Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]] Output: [2,4,5,6]
 * Initially 5,6 will be added to queue, as thier outdegree is 0.
 * When we remove 5,6 from queue 2,4 outdgree becomes 0 and is added to queue.
 * when 2,4 is removed from queue, queue becomes empty with no more nodes with
 * outdgree as 0.
 * safe nodes helps to sort our nodes and adds 2,4,5,6 to res.
 * 
 * Complexity
 * 
 * Time complexity: O(V+E)
 * 
 * Space complexity: O(V+E)
 * 
 */
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        List<Integer>[] adj = new ArrayList[n];
        int[] outdegree = new int[n];
        int[] safe = new int[n];
        List<Integer> ans = new ArrayList();
        Queue<Integer> q = new LinkedList();

        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList();

        for (int i = 0; i < n; i++) {
            for (int v : graph[i]) {
                adj[v].add(i);
            }
            outdegree[i] = graph[i].length;
            if (outdegree[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            safe[u] = 1;
            for (int v : adj[u]) {
                if (--outdegree[v] == 0)
                    q.add(v);
            }
        }
        for (int i = 0; i < n; i++) {
            if (safe[i] == 1)
                ans.add(i);
        }
        return ans;
    }
}