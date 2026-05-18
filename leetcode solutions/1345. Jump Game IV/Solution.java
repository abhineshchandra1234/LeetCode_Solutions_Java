// 1345. Jump Game IV

/**
 * Intuition
 * we will solve this problem through BFS
 * we will add curr left, right and equal nos in graph
 * then we will traverse graph, if the curr no is equal to n-1 return steps
 * For equal nos, we will have hashmap, which will have mapping of no and its
 * indices
 * after every level of traversal, we will increase steps
 * we will remove mapping of curr after every level traversal to avoid
 * repetition and tle
 * Approach
 * 
 * Complexity
 * Time complexity: O(n), will visit every node once
 * Space complexity: O(n), storing nodes in graph
 */

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return 0;
        boolean visited[] = new boolean[n];
        HashMap<Integer, List<Integer>> m = new HashMap();

        for (int i = 0; i < n; i++)
            m.computeIfAbsent(arr[i], k -> new ArrayList()).add(i);

        Queue<Integer> q = new LinkedList();
        q.add(0);
        visited[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int curr = q.poll();
                if (curr == n - 1)
                    return steps;
                int left = curr - 1;
                int right = curr + 1;

                if (left >= 0 && !visited[left]) {
                    q.add(left);
                    visited[left] = true;
                }

                if (right < n && !visited[right]) {
                    q.add(right);
                    visited[right] = true;
                }
                if (!m.containsKey(arr[curr]))
                    continue;
                // arr[i]==arr[j]
                for (int idx : m.get(arr[curr])) {
                    if (!visited[idx]) {
                        q.add(idx);
                        visited[idx] = true;
                    }
                }

                m.remove(arr[curr]);
            }
            steps++;
        }
        return -1;
    }
}