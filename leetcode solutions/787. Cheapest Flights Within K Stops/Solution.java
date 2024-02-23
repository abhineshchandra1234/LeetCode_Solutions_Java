/**
 * 787. Cheapest Flights Within K Stops
 * 
 * Intuition
 * 
 * credits singhabhinash
 * we will solve this problem through BFS
 * we will create a graph for all flights
 * Then use BFS to update shortest path or cost for all dsts of src near k stops
 * If dst is reachable its cost will be updated and returned otherwise it will
 * remain infinity and we will return -1.
 * Dijkstras algorithm is also used to find shortest path from source to all
 * vertices, but it has higher time complexity.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(V∗K+E), we are traversing all neighs of
 * vertex, and we are doing this k times or levels
 * 
 * Space complexity: O(V + E)
 * 
 */
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // create graph
        List<List<int[]>> adj = new ArrayList();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList());
        for (int[] flight : flights)
            adj.get(flight[0]).add(new int[] { flight[1], flight[2] });

        // bfs
        Queue<int[]> q = new LinkedList();
        q.add(new int[] { src, 0 });
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        int stops = 0;
        while (!q.isEmpty() && stops <= k) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                for (int[] neigh : adj.get(curr[0])) {
                    int price = neigh[1], neighNode = neigh[0];
                    if (price + curr[1] >= minCost[neighNode])
                        continue;
                    minCost[neighNode] = price + curr[1];
                    q.add(new int[] { neighNode, minCost[neighNode] });
                }
            }
            stops++;
        }
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}