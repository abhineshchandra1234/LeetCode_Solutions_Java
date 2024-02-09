/**
 * 297. Serialize and Deserialize Binary Tree
 * 
 * Intuition
 * 
 * we use dfs to solve this problem
 * serialization
 * Base cond 1 If the root is null return "#"
 * Recursive cond If the root is not null return root.val + "," + dfs(root.left)
 * + "," + dfs(root.right)
 * deserialization
 * Split the data according to delimitor "," and add it to queue
 * Then using a helper method pop queue elements one by one using dfs
 * Base cond 1 if the data is "#" return null
 * if the data is not "#" calculate root.
 * Then calculate root.left and root.right using dfs of queue
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n), traversing each node once using dfs
 * 
 * Space complexity: O(n), storing each node in queue
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "#";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList(Arrays.asList(data.split(",")));
        return helper(q);
    }

    private TreeNode helper(Queue<String> q) {
        String s = q.poll();
        if (s.equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = helper(q);
        root.right = helper(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));