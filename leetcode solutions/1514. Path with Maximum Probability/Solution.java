/**
 * 1514. Path with Maximum Probability
 * 
 * Intuition
 * 
 * since it is connected component we can use bfs to traverse it.
 * We will use adjacency list to create a graph.
 * Each node will contain a list of its neigh and succProb value.
 * we will have a dist array, for start we will keep initial value as 1. It will
 * contain max probability for each node.
 * we will add start to queue. then we will traverse its neigh.
 * we will use dist to calculate newProb. if newProb is greater than
 * dist[neigh], we will add neigh to queue.
 * Finally we will return dist[end]
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n*E), n = no of nodes, E = edges.length
 * 
 * Space complexity:
 * 
 * O(n+E)
 * 
 */
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        // create graph using adjacency list
        List<List<Pair<Integer, Double>>> adj = new ArrayList();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList());

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];
            adj.get(u).add(new Pair<>(v, p));
            adj.get(v).add(new Pair<>(u, p));
        }

        // dist array
        double[] dist = new double[n];
        dist[start] = 1.0;

        // Queue for BFS
        Queue<Integer> q = new LinkedList();
        q.add(start);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int curr = q.poll();
                for (Pair<Integer, Double> pair : adj.get(curr)) {
                    int node = pair.getKey();
                    double prob = pair.getValue();
                    double newProb = dist[curr] * prob;

                    if (newProb > dist[node]) {
                        dist[node] = newProb;
                        q.add(node);
                    }
                }
            }
        }
        return dist[end];
    }
}