// 1871. Jump Game VII

/**
 * Intuition
 * we will add index to queue
 * index left range would be from max idx + minJump, farthest + 1, we can have
 * conflicting range for 0 and 1 index with ranges [2,5] and [3,6]
 * here 2,3,4,5 is already evaluated for index 0, we will start evaluation from
 * farthest+1 ie 6, otherwise it will go in loop and repeat indices
 * index right range would be from min idx + maxJump, n - 1
 * we will check if index between left and right range is 0 and not visited,
 * before adding them to queue
 * the base condition is, if the curr idx is n-1 return true
 * if the queue is empty, still we didnt reach last index, return false
 * Approach
 * 
 * Complexity
 * Time complexity: O(n), visiting each index once
 * Space complexity: O(n), storing indices in queue
 */

class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        Queue<Integer> q = new LinkedList();
        q.add(0);

        int[] v = new int[n];
        v[0] = 1;
        int farthest = 0;

        while (!q.isEmpty()) {
            int idx = q.poll();

            if (idx == n - 1)
                return true;

            int l = Math.max(idx + minJump, farthest + 1);
            int r = Math.min(idx + maxJump, n - 1);

            for (int k = l; k <= r; k++) {
                if (s.charAt(k) == '0' && v[k] == 0) {
                    v[k] = 1;
                    q.add(k);
                }
            }
            farthest = Math.max(farthest, r);
        }
        return false;
    }
}