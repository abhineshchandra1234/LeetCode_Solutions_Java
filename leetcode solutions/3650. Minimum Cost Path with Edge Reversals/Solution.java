// 3650. Minimum Cost Path with Edge Reversals

/**
 * Intuition
 * we will add each node and its edges in the adjacency list
 * Then we will also add reverse edge for each node in the adjacency list
 * Then we will use dijskstra algorithm starting from node 0
 * If we have reached node n-1, return its distance
 * Otherwise visit neigh and update their distance if the new distance is less
 * than the existing one
 * Approach
 * 
 * Complexity
 * Time complexity: O(e*logv), for each vertices we are traversing its edges
 * Space complexity: O(e+v), using adjency list
 */

class Solution {

    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int minCost(int n, int[][] edges) {

        // adjacency list: node -> {neighbot, weight}
        Map<Integer, List<Pair>> adj = new HashMap();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.computeIfAbsent(u, k -> new ArrayList()).add(new Pair(v, wt));
            // reversed edge
            adj.computeIfAbsent(v, k -> new ArrayList()).add(new Pair(u, 2 * wt));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        // min-heap based on distance
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        // node, distance
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int node = cur.node;
            int d = cur.dist;

            if (d > dist[node])
                continue;

            if (node == n - 1)
                return d;

            if (!adj.containsKey(node))
                continue;

            for (Pair neigh : adj.get(node)) {
                int nextNode = neigh.node;
                int weight = neigh.dist;

                if (d + weight < dist[nextNode]) {
                    dist[nextNode] = d + weight;
                    pq.add(new Pair(nextNode, dist[nextNode]));
                }
            }
        }

        return -1;
    }
}