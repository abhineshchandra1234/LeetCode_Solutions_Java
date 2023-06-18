/**
 * 2101. Detonate the Maximum Bombs
 * 
 * Intuition
 * credits Sunchit
 * we will solve this problem through graph, since connected components are
 * involved.
 * We can detonate any bomb and that bomb will denote any bombs connected to it
 * and so on.
 * we need to find max detonations we can do with one bomb.
 * distance between two pts in graph is sqrt((x2-x1)^2 + (y2-y1)^2)
 * We will first create graph using adjacency list by storing all bombs and
 * thier neighbors
 * then for each bomb we will do bfs to find the detonation count and update
 * maxCount of detonation.
 * 
 * Complexity
 * Time complexity:
 * O(n^3), For every bombs we can have n^2 edges. Means each bomb is connected
 * to all other bombs.
 * 
 * Space complexity:
 * 
 * O(n^2), to store n^2 edges
 */
class Solution {
    public int maximumDetonation(int[][] bombs) {

        // build graph
        Map<Integer, List<Integer>> neighbors = buildNeighbors(bombs);

        // count detonations of each bomb and store the max
        int maxCount = 0;
        for (int startBomb = 0; startBomb < bombs.length; startBomb++) {
            // do bfs to count detonation for ith bomb
            int count = countDetonationFrom(startBomb, neighbors);
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    private Map<Integer, List<Integer>> buildNeighbors(int[][] bombs) {
        Map<Integer, List<Integer>> graph = new HashMap();

        for (int i = 0; i < bombs.length; i++) {
            List<Integer> neighbors = new ArrayList();

            long x1 = bombs[i][0];
            long y1 = bombs[i][1];
            long r1 = bombs[i][2];

            for (int j = 0; j < bombs.length; j++) {
                long x2 = bombs[j][0];
                long y2 = bombs[j][1];

                if (i != j) {
                    if ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) <= r1 * r1)
                        neighbors.add(j);
                }
            }
            graph.put(i, neighbors);
        }
        return graph;
    }

    private int countDetonationFrom(int startBomb, Map<Integer, List<Integer>> neighbors) {
        Queue<Integer> q = new LinkedList();
        q.add(startBomb);
        Set<Integer> reachable = new HashSet();
        reachable.add(startBomb);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int bomb = q.poll();
                for (int neighbor : neighbors.get(bomb)) {
                    if (!reachable.contains(neighbor)) {
                        q.add(neighbor);
                        reachable.add(neighbor);
                    }
                }
            }
        }
        return reachable.size();
    }
}