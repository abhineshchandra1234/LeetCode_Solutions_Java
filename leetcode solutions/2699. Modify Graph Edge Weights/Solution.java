/**
 * 2699. Modify Graph Edge Weights
 * 
 * Intuition
 * Given
 * we are given n nodes from 0 to n-1
 * Integer array edges, where edges[i] = [ai, bi, wi], which indicates there is
 * an edge between nodes ai and bi with weight wi
 * integer source, destination and target
 * Return
 * Integer array edges if it is possible to make shortest distance between
 * source and destination equal to target else empty array
 * 
 * Approach
 * we can solve it using Dijkstra's algorithm
 * we will find shortest path without -1 edges
 * First scenario, if the shortest path is less than the target return empty
 * array, as it is impossible to modify edges
 * Second scenario, if the shortest path is equal to the target return the edges
 * with -1 modified to infinity, we have our res, but according to question we
 * need to convert every -1 edge
 * Third scenario, if the shortest path is greater than target, we need to find
 * path using -1 edges
 * For second and third scenario, we will traverse edges
 * If the edge is not equal to -1, we will skip it
 * if the shortest distance is equal to the target, we will assign infinity to
 * -1 edge else 1
 * we will add new edge to the graph
 * if the curr shortest distance doesnt match target, we will find new shortest
 * distance
 * if the new shortest distance is less than or equal to target, we can get our
 * res, and set boolean matchesTarget value to true
 * we get our res, by assigning diff of target and new shortest distance to the
 * current edge weight
 * If matchesTarget value is true means we have got our res, we will return
 * edges else empty array
 * For second scenario we are not seperately changing edges from -1 to infinity
 * and doing it with third scenario
 * 
 * Complexity
 * Time complexity: O(E* (E*logV)), applying Dijkstra for each -1 edge
 * Space complexity: O(V+ E), graph creation
 */
class Solution {

    List<int[]>[] graph;
    int inf = (int) 2e9;

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList();

        // graph without -1 edge
        for (int[] edge : edges) {
            if (edge[2] != -1) {
                graph[edge[0]].add(new int[] { edge[1], edge[2] });
                graph[edge[1]].add(new int[] { edge[0], edge[2] });
            }
        }

        // shortest dis calculated without -1 edges
        int currShortDis = Dijkstra(n, source, destination);

        // scenario 1
        if (currShortDis < target)
            return new int[0][0];

        // scenario 2 & 3
        boolean matchesTarget = currShortDis == target;

        for (int[] edge : edges) {

            if (edge[2] != -1)
                continue;

            // we need to convert every -1 edge
            // infinity is assigned to not affect shortest distance
            edge[2] = matchesTarget ? inf : 1;
            graph[edge[0]].add(new int[] { edge[1], edge[2] });
            graph[edge[1]].add(new int[] { edge[0], edge[2] });

            if (!matchesTarget) {

                int newDis = Dijkstra(n, source, destination);

                if (newDis <= target) {
                    matchesTarget = true;
                    edge[2] += target - newDis;
                }
            }
        }

        return matchesTarget ? edges : new int[0][0];
    }

    private int Dijkstra(int n, int source, int destination) {

        int[] minDis = new int[n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Arrays.fill(minDis, inf);
        minDis[source] = 0;
        minHeap.add(new int[] { source, 0 });

        while (!minHeap.isEmpty()) {

            int[] curr = minHeap.poll();
            int u = curr[0];
            int d = curr[1];

            if (d > minDis[u])
                continue;

            for (int[] neigh : graph[u]) {

                int v = neigh[0];
                int weight = neigh[1];

                if (d + weight < minDis[v]) {

                    minDis[v] = d + weight;
                    minHeap.add(new int[] { v, minDis[v] });
                }
            }
        }
        return minDis[destination];
    }
}