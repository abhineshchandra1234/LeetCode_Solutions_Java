/**
 * 2045. Second Minimum Time to Reach Destination
 * 
 * Intuition
 * we are given n cities
 * the cities are connected by bi-directional edges, where edges[i] = [ui, vi],
 * means there is an edge between vertex ui and vi
 * we are given time minutes to travel between vertices
 * we are given change minutes after which signal changes from green to red, all
 * signals change at the same time
 * Initially the signal is green, we cannot wait at the vertex if the signal is
 * green
 * we can enter the vertex at any time but can only leave when signal is green
 * given n, edges, time and change we need to return second minimum time to
 * reach from vertex 1 to n
 * 
 * 
 * Approach
 * As it is given in the question we need to find min time, so dijkstra
 * algorithm will be applicable
 * we will find min time from source 1 to n
 * since we need to find second min, we need to maintain freq array, so when we
 * have visited same node twice and it is nth node, we will return time taken
 * one part of the question is sorted, next we need to calculate time taken to
 * reach next neighbor
 * If the time taken to reach current node is not completely divisible by
 * change, means the light is red so total time to reach next neigh is
 * time_taken = change * (time_taken / change + 1) + time;
 * Otherwise if signal is green time to reach next neigh is curr_time + time
 * 
 * 
 * Complexity
 * Time complexity: O(mlogn), where m is edges length, n is cities
 * Space complexity: O(n)
 */
class Solution {

    public int secondMinimum(int n, int[][] edges, int time, int change) {

        Map<Integer, List<Integer>> graph = new HashMap();

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, v -> new ArrayList()).add(b);
            graph.computeIfAbsent(b, v -> new ArrayList()).add(a);
        }

        int[] dist1 = new int[n + 1], dist2 = new int[n + 1], freq = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dist1[i] = dist2[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.add(new int[] { 1, 0 });
        dist1[1] = 0;

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int node = temp[0];
            int time_taken = temp[1];

            freq[node]++;

            if (freq[node] == 2 && node == n)
                return time_taken;

            if ((time_taken / change) % 2 == 1)
                time_taken = change * (time_taken / change + 1) + time;
            else
                time_taken = time_taken + time;

            if (!graph.containsKey(node))
                continue;
            for (int neigh : graph.get(node)) {
                if (freq[neigh] == 2)
                    continue;

                if (dist1[neigh] > time_taken) {
                    dist2[neigh] = dist1[neigh];
                    dist1[neigh] = time_taken;
                    pq.add(new int[] { neigh, time_taken });
                } else if (dist2[neigh] > time_taken && dist1[neigh] != time_taken) {
                    dist2[neigh] = time_taken;
                    pq.add(new int[] { neigh, time_taken });
                }
            }
        }
        return 0;
    }
}