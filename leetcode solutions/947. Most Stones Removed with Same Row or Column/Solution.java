/**
 * 947. Most Stones Removed with Same Row or Column
 * 
 * Intuition
 * we are given 2d array of stones which represent stones in 2-d plane, where
 * stones[i] = [xi, yi]
 * we need to return max stones we can remove
 * our base logic max no of removed stones = n - connected component
 * Here we are reducing the connected component to 1 and removing all other
 * stones of that group, as one stone will remain in every group
 * 
 * Approach
 * we can solve this problem through DFS and graph
 * we will treat index as vertex for the graph
 * we will try all stones for each stone and if they have same row or col, we
 * will draw an edge between their indices
 * we will maintain a visited array, to mark all neighs of curr stone in DFS
 * we will traverse stones, if the curr stone is unvisited, we will apply DFS to
 * it and increase connected count
 * If its neigh is also unvisited, apply DFS to it too
 * At last return res as n - connected components
 * 
 * Complexity
 * Time complexity: O(n^2), trying each combination of stones for graph
 * Space complexity: O(n^2), edges from each stone to all stones in worst case
 */
class Solution {

    public int removeStones(int[][] stones) {

        int n = stones.length;

        Map<Integer, List<Integer>> m = new HashMap();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    m.computeIfAbsent(i, v -> new ArrayList()).add(j);
                    m.computeIfAbsent(j, v -> new ArrayList()).add(i);
                }
            }
        }

        int connectedComponents = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                connectedComponents++;
                dfs(visited, m, i);
            }
        }

        return n - connectedComponents;
    }

    private void dfs(boolean[] visited, Map<Integer, List<Integer>> m, int stone) {

        visited[stone] = true;

        if (!m.containsKey(stone))
            return;

        for (int neigh : m.get(stone)) {
            if (!visited[neigh])
                dfs(visited, m, neigh);
        }
    }
}