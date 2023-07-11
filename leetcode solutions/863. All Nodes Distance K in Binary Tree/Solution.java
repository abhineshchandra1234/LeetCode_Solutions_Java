/**
 * 863. All Nodes Distance K in Binary Tree
 * 
 * Intuition
 * 
 * credits BingleLove
 * We will use dfs to find path between root and the target and we will also
 * store dist of every node in the path to the hashmap.
 * Then will use another dfs to add nodes to the result whose dist is equal to k
 * from the target.
 * 
 * Approach
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2 Output:
 * [7,4,1]
 * At 5 dist will be 0, then we will proceed further and will get dist 2 for 7 &
 * 4 nodes from 5.
 * At 3 dist is 1, then we will proceed further and will get dist 2 for node 1
 * from 5.
 * Note: Only nodes 3,5 falls in the valid path and hence only thier distance is
 * added in the hashmap.
 * Using dist of 3,5 all other nodes are added in the result.
 * It make sense if any nodes connects with any node in the valid path means it
 * also connects with the target, and now we need to just take care of dist.
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
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
class Solution {

    Map<TreeNode, Integer> map = new HashMap();
    List<Integer> res = new ArrayList();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        find(root, target);
        dfs(root, target, k, map.get(root));
        return res;
    }

    private int find(TreeNode root, TreeNode target) {
        if (root == null)
            return -1;
        if (root == target) {
            map.put(root, 0);
            return 0;
        }
        int left = find(root.left, target);
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }
        int right = find(root.right, target);
        if (right >= 0) {
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }

    private void dfs(TreeNode root, TreeNode target, int k, int length) {
        if (root == null)
            return;
        if (map.containsKey(root))
            length = map.get(root);
        if (length == k)
            res.add(root.val);
        dfs(root.left, target, k, length + 1);
        dfs(root.right, target, k, length + 1);
    }
}