/*
1530. Number of Good Leaf Nodes Pairs

Intuition
we are given root and integer distance
we need to return count of good leaf node pairs
a pair of leaf node is said to be good, if the shortest distance between them is less than or equal to distance
If we do BFS for each leaf node, and are able to reach another leaf node, then distance between them is equal to the level
If the level or distance is less than or equal to target, increase count by 1
At last return count/2 as we need pair counts

Approach
we will solve this using graph and BFS
First construct graph between prev and curr node
If curr node is leaf add it to a set
Now we will do BFS of leaf nodes set
we will use condition for BFS as that level is less than or equal to given distance
we will traverse all nodes at given level
we will maintain a visited set for each BFS to avoid repetition of nodes
if the curr node is not the source node and is leaf increase count
Add its neighs to queue, if not visited and repeat operation
Finally return count/2

Complexity
Time complexity: O(n^2), leaf nodes can be max n and traversing its neighs
Space complexity: O(n), graph
*/
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {

    fun countPairs(root: TreeNode?, distance: Int): Int {

        val adj = mutableMapOf<TreeNode, MutableList<TreeNode>>()
        val leafSet = mutableSetOf<TreeNode>()

        makeGraph(root, null, adj, leafSet)

        var count = 0

        for (leaf in leafSet) {
            val q = ArrayDeque<TreeNode>()
            val visited = mutableSetOf<TreeNode>()

            q.add(leaf)
            visited.add(leaf)

            for (level in 0..distance) {
                for (i in 0 until q.size) {
                    val curr = q.removeFirst()
                    if (curr != leaf && leafSet.contains(curr)) count++

                    for (neigh in adj.getOrDefault(curr, mutableListOf())) {
                        if (neigh !in visited) {
                            q.add(neigh)
                            visited.add(neigh)
                        }
                    }
                }
            }
        }

        return count / 2
    }

    fun makeGraph(
        root: TreeNode?,
        prev: TreeNode?,
        adj: MutableMap<TreeNode, MutableList<TreeNode>>,
        leafSet: MutableSet<TreeNode>
    ) {

        if (root == null) return

        if (root.left == null && root.right == null) leafSet.add(root)

        if (prev != null) {
            adj.computeIfAbsent(root) { mutableListOf() }.add(prev)
            adj.computeIfAbsent(prev) { mutableListOf() }.add(root)
        }

        makeGraph(root.left, root, adj, leafSet)
        makeGraph(root.right, root, adj, leafSet)
    }
}