/*
1110. Delete Nodes And Return Forest

Intuition

    we are given a root of the tree with distinct values
    we are also given an array to_delete to deletes nodes from the tree
    we need to return an list of roots of the tree of disjoints unions of nodes after above operation
    type of to_delete and res is missing

Approach

    we will solve this problem using post-order traversal through BFS
    there are few scenarios we need to cover
    First convert to_delete to set for O(1) access
    If the curr left or right node is in to_delete, disconnect it from curr
    if the curr is in to_delete, add its left and right child to res, no need to de-link or you can do it, as further wrong scenarios is not covered in the question
    there is one exception not covered, if the initial root is not in to_delete, algorithm will skip it, we need to add it in the res at the end

Complexity

    Time complexity: O(n)

    Space complexity: O(n)

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
    fun delNodes(root: TreeNode?, to_delete: IntArray): List<TreeNode?> {

        if (root == null) return ArrayList()

        var set = to_delete.toHashSet()

        var q = ArrayDeque<TreeNode>()

        q.add(root)

        var res = ArrayList<TreeNode>()

        while (!q.isEmpty()) {
            var curr = q.removeFirst()

            if (curr.left != null) {
                q.addLast(curr.left)
                if (set.contains(curr.left.`val`)) curr.left = null
            }

            if (curr.right != null) {
                q.addLast(curr.right)
                if (set.contains(curr.right.`val`)) curr.right = null
            }

            if (set.contains(curr.`val`)) {
                if (curr.left != null) res.add(curr.left)
                if (curr.right != null) res.add(curr.right)
            }
        }

        if (!set.contains(root.`val`)) res.add(root)

        return res
    }
}
