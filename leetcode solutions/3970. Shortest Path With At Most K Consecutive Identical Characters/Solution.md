# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will solve this problem using Dijkstra's Algorithm
- First we will construct a graph with u -> v, wt
- we will have res array which will store k value for nth node
- a min heap will store distance, node and count
- if distance is greater than res node count, skip it
- if the node is n-1, return the distance
- if graph doesnt contain the node, skip it
- Inside the bfs we will traverse the neighbours
- if curr node and neigh is same increase the count by 1
- if count is greater than k skip it
- if the new distance is less than neighbour node count, add new distance to neighbour node
- Update neighbour node in min heap
- Finally return -1, if above conditions fails

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(nlogn)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(n)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {

        Map<Integer, List<int[]>> adj = new HashMap();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.computeIfAbsent(u, x -> new ArrayList()).add(new int[] { v, wt });
        }

        int[][] res = new int[n][k + 1];
        for (int[] row : res) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        res[0][1] = 0;
        pq.add(new int[] { 0, 0, 1 });

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0];
            int node = top[1];
            int count = top[2];

            if (d > res[node][count])
                continue;

            if (node == n - 1)
                return d;

            if (!adj.containsKey(node))
                continue;

            for (int[] vec : adj.get(node)) {
                int adjNode = vec[0];
                int wt = vec[1];

                int newCount = (labels.charAt(adjNode) == labels.charAt(node)) ? count + 1 : 1;

                if (newCount > k)
                    continue;

                int newDist = d + wt;
                if (newDist < res[adjNode][newCount]) {
                    res[adjNode][newCount] = newDist;
                    pq.add(new int[] { newDist, adjNode, newCount });
                }
            }
        }
        return -1;
    }
}
```