/**
 * 207. Course Schedule
 * 
 * Intuition
 * 
 * credits justjiayu
 * we will solve this problem using topological sorting
 * we will first finish all the courses who has 0 dependency or indegree.
 * If 0 course has prerequisites 1,2 then 0 has indegree of 2.
 * then all the dependent courses indgree will reduce by 1, courses whoes
 * indegree or dependency becomes 0 will be added to queue for bfs.
 * At last return true if numcourses count is equal count of courses with
 * indegree or dependency as 0. Then only all courses can be completed.
 * If all courses have indegree greater than 0 means there is a cycle and they
 * are dependent on each other.
 * It is a very good problem to understand topological sort.
 * 
 * Approach
 * 
 * Create a graph with vertex as nodes whoes indegree or dependency is 0 and
 * edge as nodes whoes indegree or dependency is greater than 0.
 * We will keep an indegree array to store dependency for each node.
 * traverse indegree and add nodes to queue whoes indegree is 0.
 * Then traverse its children and add them to queue if thier indegree becomes 0.
 * 
 * Complexity
 * 
 * Time complexity: O(V+E)
 * 
 * Space complexity: O(V+E)
 * 
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int n = numCourses;
        int[] indegree = new int[n];
        List<List<Integer>> graph = new ArrayList();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList());

        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }

        int count = 0;
        Queue<Integer> q = new LinkedList();
        for (int i = 0; i < n; i++)
            if (indegree[i] == 0)
                q.add(i);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int current = q.poll();
                count++;
                for (int neigh : graph.get(current)) {
                    if (--indegree[neigh] == 0)
                        q.add(neigh);
                }
            }
        }
        return count == n;
    }
}