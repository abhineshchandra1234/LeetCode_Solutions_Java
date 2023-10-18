/**
 * 2050. Parallel Courses III
 * 
 * Intuition
 * 
 * we will solve this problem using topological sorting
 * we need min time to finish all courses
 * So we will take max of total time of each of the courses, because till that
 * time rest all courses will finish and this will be our ans
 * Total time(node) = max(existing total time, node time + dependent or path 1
 * time)
 * maxTime[neigh] = Math.max(maxTime[neigh], time[neigh] + maxTime[node] );
 * radhe radhe :)
 * 
 * Approach
 * 
 * Input: n = 5, relations = [[1,5],[2,5],[3,5],[3,4],[4,5]], time = [1,2,3,4,5]
 * Output: 12
 * total time 5 = max(path(1,5), path(2,5), path(3,5), path(4,5))
 * =max(6, 7, 8, 12) = 12
 * 12 also is max total time and our ans
 * 
 * Complexity
 * 
 * Time complexity: O(E+V)
 * 
 * Space complexity: O(E+V)
 * 
 */
class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {

        List<List<Integer>> graph = new ArrayList();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList());
        }

        int[] indegree = new int[n];
        for (int[] edge : relations) {
            int x = edge[0] - 1;
            int y = edge[1] - 1;
            graph.get(x).add(y);
            indegree[y]++;
        }

        Queue<Integer> queue = new LinkedList();
        int[] maxTime = new int[n];

        for (int node = 0; node < n; node++) {
            if (indegree[node] == 0) {
                queue.add(node);
                maxTime[node] = time[node];
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neigh : graph.get(node)) {
                maxTime[neigh] = Math.max(maxTime[neigh], maxTime[node] + time[neigh]);
                indegree[neigh]--;
                if (indegree[neigh] == 0)
                    queue.add(neigh);
            }
        }

        int ans = 0;
        for (int node = 0; node < n; node++) {
            ans = Math.max(ans, maxTime[node]);
        }

        return ans;
    }
}