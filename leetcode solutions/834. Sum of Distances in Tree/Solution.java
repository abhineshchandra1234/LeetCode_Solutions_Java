/**
 * 834. Sum of Distances in Tree
 * 
 * Intuition
 * 
 * this problem is hard
 * we will solve this problem with DFS
 * In first DFS we will find correct ans for root and temp ans for rest of the
 * nodes
 * we will find count of childs for each node, node will also be child of itself
 * res[root] += res[i] + count[i]
 * res[i] represent sum of distances with i as root of its subtree
 * count[i] represent no of nodes in i subtree
 * 
 * //Calculate res for root
 * Suppose we have tree 0 -> root, 1 -> left
 * ans(0) -> [1]
 * if we have a subtree with 4 nodes and 2 as root
 * ans(2) -> [3]
 * Now how 0 answer will be impacted
 * we need to add 1 extra distance for each node of 2
 * so ans(0) +-> ans(2) + count of nodes of (2)
 * -> 1 + (3 + 4)
 * -> 1 + 7
 * -> 8
 * ans(0) -> [8] -> 1, 1, 2, 2, 2
 * 
 * In second DFS2 we will use root ans to find ans for all the nodes
 * res[i] = res[root] - count[i] + n - count[i];
 * 
 * //Calculate res for each child using root
 * Suppose we need to find res for root 2
 * res[2] = { res[0] + n - count(2) } - count(2)
 * { res[0] + n - count(2) } -> (first equation) (extra 1 dist for each 0
 * connected node)
 * - count(2) -> res[0] already has 1 dist for each 2 connected nodes, 2 as a
 * root also has 1 dist for each connected node
 * so we will remove duplicate 1 dist for res[0] for 2 childs
 * res[2] = {8 + 6 - 4} - 4 -> 10 - 4 -> 6 -> 1, 2, 1, 1, 1
 * 
 * Note: The secret lies in the equations, if you understood it, you have
 * understood the problem
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {

    int[] res, count;
    ArrayList<List<Integer>> tree;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {

        tree = new ArrayList();
        res = new int[n];
        count = new int[n];

        for (int i = 0; i < n; i++)
            tree.add(new ArrayList());

        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }

        dfs(0, -1);
        dfs2(0, -1);

        return res;
    }

    public void dfs(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre)
                continue;
            dfs(i, root);
            count[root] += count[i];
            res[root] += res[i] + count[i];
        }
        count[root]++;
    }

    public void dfs2(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre)
                continue;
            res[i] = res[root] - count[i] + count.length - count[i];
            dfs2(i, root);
        }
    }
}