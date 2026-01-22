// 3507. Minimum Pair Removal to Sort Array I

/**
 * Intuition
 * we will use simulation to solve this problem
 * we will check every time, if the list is sorted, if it is return the
 * operations count
 * Otherwise find the minPairSum index and merge the nos whose sum is minimum
 * Approach
 * 
 * Complexity
 * Time complexity: O(n^2), everytime we are checking isSorted and finding
 * minPairSum
 * Space complexity: O(1)
 */

class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList();
        for (int num : nums)
            list.add(num);

        int ops = 0;
        while (!isSorted(list)) {
            int idx = minPairSum(list);

            int merged = list.get(idx) + list.get(idx + 1);
            list.set(idx, merged);
            list.remove(idx + 1);

            ops++;
        }

        return ops;
    }

    private boolean isSorted(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1))
                return false;
        }
        return true;
    }

    private int minPairSum(List<Integer> list) {
        int minSum = Integer.MAX_VALUE;
        int idx = -1;

        for (int i = 0; i < list.size() - 1; i++) {
            int sum = list.get(i) + list.get(i + 1);
            if (sum < minSum) {
                minSum = sum;
                idx = i;
            }
        }
        return idx;
    }
}