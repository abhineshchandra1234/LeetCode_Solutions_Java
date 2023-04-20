/**
 * 662. Maximum Width of Binary Tree
 * 
 * Intuition
 * We need to find max width between non-null left and right node at each level,
 * max width will be the count of nodes including null nodes between them.
 * If you understand this, you solved half the problem
 * We will solve this using bfs with litte tweeks
 * position of each left node will be 2*pos and right node will be 2*pos+1
 * where pos is the pos of parent
 * like - root = [1,3,2,5,3,null,9]
 * root pos -> 1
 * 3 -> 2 , 2 -> 3
 * 5 -> 4, 3 ->5 , null , 9 -> 7
 * max width is between 5 & 9 -> 7 - 4 + 1 = 4 nodes
 * We will use two ptrs at each level start will contain pos of first node and
 * end will contain pos of end node
 * At the end of each level we will find currW using above ptrs and update maxW.
 * 
 * Complexity
 * Time complexity:
 * O(n) - visiting each node once
 * 
 * Space complexity:
 * 
 * O(n) - storing each node with pos
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
    public int widthOfBinaryTree(TreeNode root) {

        Queue<TreeNode> q = new LinkedList();
        HashMap<TreeNode, Integer> map = new HashMap();
        q.add(root);
        map.put(root, 1);
        int currW = 0;
        int maxW = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int start = 0;
            int end = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                int pos = map.get(node);
                if (i == 0)
                    start = pos;
                if (i == size - 1)
                    end = pos;
                if (node.left != null) {
                    map.put(node.left, 2 * pos);
                    q.add(node.left);
                }
                if (node.right != null) {
                    map.put(node.right, 2 * pos + 1);
                    q.add(node.right);
                }
            }
            currW = end - start + 1;
            maxW = Math.max(maxW, currW);
        }
        return maxW;
    }
}