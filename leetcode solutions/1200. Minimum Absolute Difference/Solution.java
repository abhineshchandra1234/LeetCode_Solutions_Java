// 1200. Minimum Absolute Difference

/**
 * Intuition
 * First sort the array, this way difference would be minimum among consecutive
 * elements
 * Then find the minDiff
 * Then add the pairs whose difference is equal to minDiff
 * Approach
 * 
 * Complexity
 * Time complexity: O(nlogn), sorting
 * Space complexity: O(logn), sorting
 */

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);
        int n = arr.length;
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList();

        for (int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff < minDiff) {
                minDiff = diff;
                res = new ArrayList();
                res.add(Arrays.asList(arr[i - 1], arr[i]));
            } else if (diff == minDiff) {
                res.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return res;
    }
}