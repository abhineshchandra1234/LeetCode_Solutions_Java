/**
 * 785. Is Graph Bipartite?
 * 
 * Intuition
 * To split all nodes to two sets A & B.
 * We need to color set A with color A and set B with color B
 * The graph will be Bipartite if ends of each edge is of opposite
 * color.
 * We could traverse connected components through bfs, dfs or disjoint
 * set
 * color neighs with opp color if not colored yet
 * Ignore neigh already colored with opp color
 * Declare graph cant be Bipartite if any neigh has same color
 * I am not clear about disjoint approach will add later
 * 
 * Complexity
 * Time complexity: O(V+E)
 * Space complexity: O(V)
 */

class Solution {
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int[] colors = new int[n];

        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !validColor(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean validColor(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != 0)
            return colors[node] == color;
        colors[node] = color;
        for (int next : graph[node]) {
            if (!validColor(graph, colors, -color, next))
                return false;
        }
        return true;
    }
}