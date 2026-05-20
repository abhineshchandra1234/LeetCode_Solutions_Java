// 1306. Jump Game III

/**
 * Intuition
 * we will solve this problem through DFS or recursion
 * At each index we have option to go either left or right
 * we will check through recursion, if left or right is feasible, if it is
 * return true
 * base condition is if the curr index is 0 return true
 * other base condition is if are out of bounds or have already visited that
 * index, return false
 * we will mark curr index as visited by making it negative
 * Approach
 * 
 * Complexity
 * Time complexity: O(n), visiting each index once using dfs
 * Space complexity: O(n), dfs stack
 */

// Approach - 1 DFS
class Solution {
    int n;

    public boolean canReach(int[] arr, int start) {
        n = arr.length;
        return dfs(arr, start);
    }

    private boolean dfs(int[] arr, int i) {
        if (i < 0 || i >= n || arr[i] < 0)
            return false;
        if (arr[i] == 0)
            return true;

        arr[i] *= -1;
        boolean left = dfs(arr, i - arr[i]);
        boolean right = dfs(arr, i + arr[i]);
        return left || right;
    }
}

// Approach - 2 BFS

class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList();

        q.add(start);

        while (!q.isEmpty()) {
            int i = q.poll();
            if (i < 0 || i >= n || visited[i])
                continue;
            if (arr[i] == 0)
                return true;
            visited[i] = true;
            q.add(i + arr[i]);
            q.add(i - arr[i]);
        }
        return false;
    }
}