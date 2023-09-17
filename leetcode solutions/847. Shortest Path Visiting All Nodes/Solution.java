/**
 * 847. Shortest Path Visiting All Nodes
 * 
 * Intuition
 * 
 * we will solve this problem using BFS + bit manipulation
 * In BFS we can visit each node once using visited set.
 * Here we can visite each node multiple times and also we cannot go in loop
 * We will keep track of all the nodes visited using bits, if we encounter same
 * state at any node we will skip that node.
 * for every new node we will increase shortest path by 1.
 * 
 * Approach
 * 
 * we have used queue to parse each node and its neigh
 * we have used an array to mark the visited state for each node
 * each node in queue and array will contain an visited state.
 * 
 * Complexity
 * 
 * Time complexity: O(n*2^n)
 * 
 * Space complexity: O(n*2^n)
 * 
 */
class Solution {
    public int shortestPathLength(int[][] graph) {

        if (graph.length == 1)
            return 0;
        int finalState = (1 << graph.length) - 1;

        Queue<int[]> q = new LinkedList();

        for (int i = 0; i < graph.length; i++)
            q.add(new int[] { i, 1 << i });

        int[][] visitedMap = new int[graph.length][finalState + 1];

        int shortestPath = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            shortestPath++;
            for (int i = 0; i < size; i++) {
                int[] head = q.poll();
                int nodeId = head[0];
                int visitedNodeBitState = head[1];
                for (int neigh : graph[nodeId]) {
                    int newVisitedNodeBitState = visitedNodeBitState | (1 << neigh);

                    if (visitedMap[neigh][newVisitedNodeBitState] == 1)
                        continue;
                    visitedMap[neigh][newVisitedNodeBitState] = 1;
                    if (newVisitedNodeBitState == finalState)
                        return shortestPath;
                    q.add(new int[] { neigh, newVisitedNodeBitState });
                }
            }
        }
        return -1;
    }
}