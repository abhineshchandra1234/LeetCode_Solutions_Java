// 2196. Create Binary Tree From Descriptions

/**
 * Intuition
 * we will use a map and set to solve this
 * map will contain all the treenodes
 * set will contain all the childs
 * we will traverse desriptions and create parent and child node and store it in
 * the map
 * Then we will link parent and child node by fetching them from the map
 * we will add child to the set
 * then we will again traverse descriptions, if the set doesnt contain the
 * parent, we will return the parent as ans by fetching it from the map
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> m = new HashMap();
        Set<Integer> s = new HashSet();

        for (int[] description : descriptions) {
            int p = description[0];
            int c = description[1];
            boolean l = description[2] == 1;

            m.computeIfAbsent(p, k -> new TreeNode(k));
            m.computeIfAbsent(c, k -> new TreeNode(k));

            if (l)
                m.get(p).left = m.get(c);
            else
                m.get(p).right = m.get(c);

            s.add(c);
        }

        for (int[] description : descriptions) {
            int p = description[0];
            if (!s.contains(p))
                return m.get(p);
        }

        return null;
    }
}