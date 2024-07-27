/**
 * 2976. Minimum Cost to Convert String I
 * 
 * Intuition
 * we are given two strings source and target of length n
 * we are also given char arrays original and changed and integer array cost
 * cost[i] represents cost of changing char original[i] to changed[i]
 * we start from string source and pick a char x and change it to y at a cost of
 * z, such that original[j] = x, changed[j] = y and cost[j] = z
 * we need to return the min cost to convert source to target string, if it is
 * not possible return -1
 * we can have indices i,j such that original[j]==original[i] and
 * changed[j]==changed[i]
 * 
 * 
 * Approach
 * we can consider each char as a node and have a directed edges between them
 * with a cost
 * the problem then becomes finding min cost path from each char in source to
 * corresponding char in target
 * we will apply dijkstra algorithm for all 26 chars to find shortest path to
 * each of the 26 chars
 * 
 * 
 * Complexity
 * Time complexity: O(m+n)
 * there are 26 vertices and m edges so time is O(m*log26), which is O(m)
 * we are traversing source string to calculate total cost, which is O(n)
 * Space complexity: O(m), store conversions in graph
 */

class Solution {

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

        Map<Integer, List<int[]>> graph = new HashMap();

        for (int i = 0; i < original.length; i++) {
            graph.computeIfAbsent((original[i] - 'a'), k -> new ArrayList()).add(
                    new int[] { changed[i] - 'a', cost[i] });
        }

        // calculate all chars conversions, as we have some intermediate conversions too
        long[][] minConversionCosts = new long[26][26];
        for (int i = 0; i < 26; i++) {
            minConversionCosts[i] = dijkstra(i, graph);
        }

        long totalCost = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
                long charConversionCost = minConversionCosts[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
                if (charConversionCost == -1)
                    return -1;
                totalCost += charConversionCost;
            }
        }
        return totalCost;
    }

    private long[] dijkstra(int startChar, Map<Integer, List<int[]>> graph) {

        PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<>(
                (a, b) -> {
                    return Long.compare(a.getKey(), b.getKey());
                });

        pq.add(new Pair<>(0L, startChar));
        long[] minCosts = new long[26];
        Arrays.fill(minCosts, -1L);

        while (!pq.isEmpty()) {
            Pair<Long, Integer> currPair = pq.poll();
            long currentCost = currPair.getKey();
            int currentChar = currPair.getValue();

            if (minCosts[currentChar] != -1L &&
                    minCosts[currentChar] < currentCost)
                continue;

            if (!graph.containsKey(currentChar))
                continue;
            for (int[] conversion : graph.get(currentChar)) {
                int targetChar = conversion[0];
                long conversionCost = conversion[1];
                long newTotalCost = currentCost + conversionCost;

                if (minCosts[targetChar] == -1L || newTotalCost < minCosts[targetChar]) {

                    minCosts[targetChar] = newTotalCost;
                    pq.add(new Pair<>(newTotalCost, targetChar));
                }
            }
        }

        return minCosts;
    }
}