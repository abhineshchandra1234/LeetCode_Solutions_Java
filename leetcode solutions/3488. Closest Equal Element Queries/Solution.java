// 3488. Closest Equal Element Queries

/**
 * Intuition
 * we will first store all indices for all nos in a map
 * Then we are traversing query
 * then we are seeing list of the element in the map
 * if the list size is 1 means we have only 1 occurence of curr element, we will
 * add -1 to res
 * If the list size is more than 1, then we find the right neighbor and take min
 * of its straight distance and circular distance
 * then we again to this for left neighbor
 * At last we add min of all distances to the res
 * Approach
 * 
 * Complexity
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        Map<Integer, List<Integer>> mp = new HashMap<>();

        // store indices
        for (int i = 0; i < n; i++) {
            mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();

        for (int qi : queries) { // O(Q)
            int element = nums[qi];
            List<Integer> vec = mp.get(element);

            int sz = vec.size();

            // no more occurrence
            if (sz == 1) {
                result.add(-1);
                continue;
            }

            int pos = Collections.binarySearch(vec, qi);
            int res = Integer.MAX_VALUE;

            // Right neighbor
            int right = vec.get((pos + 1) % sz);
            int d = Math.abs(qi - right);
            int circularDist = n - d;
            res = Math.min(res, Math.min(d, circularDist));

            // Left neighbor
            int left = vec.get((pos - 1 + sz) % sz);
            d = Math.abs(qi - left);
            circularDist = n - d;
            res = Math.min(res, Math.min(d, circularDist));

            result.add(res);
        }

        return result;
    }
}