// 3741. Minimum Distance Between Three Equal Elements II

/**
 * Intuition
 * This problem is similar to "3740. Minimum Distance Between Three Equal
 * Elements I" with same time and space complexity
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;

        Map<Integer, List<Integer>> m = new HashMap();
        for (int i = 0; i < n; i++) {
            m.computeIfAbsent(nums[i], k -> new ArrayList()).add(i);
        }

        int res = Integer.MAX_VALUE;

        for (List<Integer> l : m.values()) {
            if (l.size() >= 3) {
                for (int i = 0; i + 2 < l.size(); i++) {
                    int a = l.get(i);
                    int b = l.get(i + 1);
                    int c = l.get(i + 2);

                    int d = 2 * (c - a);

                    res = Math.min(res, d);
                }
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}