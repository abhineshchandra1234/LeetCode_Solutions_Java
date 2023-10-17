/**
 * 1361. Validate Binary Tree Nodes
 * 
 * Intuition
 * 
 * credits vanAmsen
 * First lets understand the question we have been given nodes from 0 to n-1 and
 * thier left and right childs
 * Each index represent nodes
 * The basic logic for binary tree is
 * The root will have indegree as 0
 * rest nodes will have indegree as 1 and reachable
 * 
 * Approach
 * 
 * reachable will help us to find the loop and also if some node is not
 * connected with others
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1)
                indegree[leftChild[i]]++;
            if (rightChild[i] != -1)
                indegree[rightChild[i]]++;
        }
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                root = i;
        }
        if (root == -1)
            return false;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (visited[node])
                return false;
            visited[node] = true;
            if (leftChild[node] != -1)
                queue.add(leftChild[node]);
            if (rightChild[node] != -1)
                queue.add(rightChild[node]);
        }
        int trueCount = 0;
        for (boolean b : visited) {
            if (b)
                trueCount++;
        }
        return trueCount == n;
    }
}