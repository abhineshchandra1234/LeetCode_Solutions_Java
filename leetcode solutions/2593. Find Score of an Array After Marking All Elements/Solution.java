/**
 * 2593. Find Score of an Array After Marking All Elements
 * 
 * Intuition
 * we can solve this problem through heap
 * we will have a marked array
 * we will store no and its index in heap
 * we will sort no on ascending order, if they are not equal else on the basis
 * of index
 * we will pop the min nos from heap, till it is empty
 * Add its value to score, if it is not marked
 * and mark its adjacent elements, if the index is valid
 * Approach
 * 
 * Complexity
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */
class Solution {

    public long findScore(int[] nums) {

        int n = nums.length;
        boolean[] marked = new boolean[n];

        PriorityQueue<int[]> minH = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            else
                return a[1] - b[1];
        });

        for (int i = 0; i < n; i++) {
            minH.add(new int[] { nums[i], i });
        }

        long res = 0;
        while (!minH.isEmpty()) {

            int[] curr = minH.poll();
            int no = curr[0];
            int idx = curr[1];

            if (!marked[idx]) {
                res += no;
                if (idx + 1 < n)
                    marked[idx + 1] = true;
                if (idx - 1 >= 0)
                    marked[idx - 1] = true;
            }

        }

        return res;
    }
}