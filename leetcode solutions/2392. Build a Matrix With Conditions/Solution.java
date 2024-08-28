/**
 * 2392. Build a Matrix With Conditions
 * 
 * Intuition
 * we are given positive integer k
 * we are also given 2d integer array rowConditions[i] = [abovei, belowi] and
 * colConditions[i] = [lefti, righti]
 * the two arrays contain integers from 1 to k
 * we need to construct matrix k*k, which contains nos from 1 to k exactly once,
 * and have remaining cells as 0 and also satisfy certain conditions
 * the conditions
 * the no abovei should appear strictly above of no belowi
 * the no lefti should appear strictly left of no righti
 * we need to return any matrix that satisfy above conditions, and empty matrix
 * in case of no answer
 * 
 * Approach
 * from the question it is evident that we need to order nos, so we will use
 * kahn algorithm for topological sorting
 * we will do topological sorting of rowConditions, it will tell us which no
 * will come first in rows
 * similarly we will do topological sorting of colConditions, it will tell us
 * which no will come first in cols
 * Now we will construct matrix using above data
 * we will traverse row-wise
 * we already know which no will come first through row order, for its col value
 * we will fetch index from col order from that particular no
 * to fetch index we will store col order along-with its index in hashmap
 * If there is any cycle, sorted order length will be less than k, then return
 * empty matrix
 * 
 * Complexity
 * Time complexity: O(n), topological sorting
 * Space complexity: O(n), Construct matrix
 */
class Solution {

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {

        List<Integer> order1 = helper(rowConditions, k);
        List<Integer> order2 = helper(colConditions, k);

        if (order1.size() < k || order2.size() < k)
            return new int[0][0];

        HashMap<Integer, Integer> m = new HashMap();

        for (int i = 0; i < k; i++)
            m.put(order2.get(i), i);

        int[][] ans = new int[k][k];

        for (int i = 0; i < k; i++)
            ans[i][m.get(order1.get(i))] = order1.get(i);

        return ans;
    }

    public List<Integer> helper(int[][] conditions, int k) {

        int[] deg = new int[k];
        List<Integer> order = new ArrayList();
        HashMap<Integer, List<Integer>> graph = new HashMap();
        LinkedList<Integer> q = new LinkedList();

        for (int[] c : conditions) {
            graph.computeIfAbsent(c[0] - 1, key -> new ArrayList()).add(c[1] - 1);
            deg[c[1] - 1]++;
        }

        for (int i = 0; i < k; i++) {
            if (deg[i] == 0)
                q.addLast(i);
        }

        while (!q.isEmpty()) {
            var x = q.pollFirst();
            order.add(x + 1);
            if (graph.containsKey(x)) {
                for (int y : graph.get(x)) {
                    if (--deg[y] == 0)
                        q.addLast(y);
                }
            }
        }

        return order;
    }
}