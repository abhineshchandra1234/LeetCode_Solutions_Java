/**
 * 1376. Time Needed to Inform All Employees
 * 
 * Intuition
 * By looking at the question I was able to tell we can solve this using bfs.
 * we will have max time var, we will traverse first the superviser then we will
 * add subordinates in bfs queue and update max time.
 * Note we need to add supervisor time and subordinate time while adding
 * subordinate to bfs queue.
 * To find subordinate for each supervisor we will use graph for its mapping
 * which can be implemented using adjacency list.
 * the time needed to inform all employees is equal to the max time needed to
 * inform a employee.
 * 
 * Approach
 * we will add subordinate and (supervisor + subordinate time ) array to bfs
 * queue.
 * 
 * Complexity
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList();
        for (int i = 0; i < n; i++)
            if (manager[i] != -1)
                graph[manager[i]].add(i);

        // Since it's a tree, we don't need `visited` array
        Queue<int[]> q = new LinkedList();
        q.add(new int[] { headID, 0 });
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] top = q.poll();
                int u = top[0], w = top[1];
                ans = Math.max(ans, w);
                for (int v : graph[u])
                    q.add(new int[] { v, w + informTime[u] });
            }
        }
        return ans;
    }
}