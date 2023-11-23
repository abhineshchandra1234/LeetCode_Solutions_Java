/**
 * 1630. Arithmetic Subarrays
 * 
 * Aproach 1 (Sorting)
 * 
 * As evident For each query, you will sort the list, then compare if all the
 * intervals is equal to a[1]-a[0]
 * TC - O(m∗n∗logn), SC - O(n)
 * 
 * Approach 2 (Without Sorting)
 * 
 * For each query you will find interval by max-min/n-1
 * aithmetic array will have equal interval between its nos
 * we will generate arithmetic array using min + i*interval, if it is equals to
 * num return true else false.
 * there will be n-1 equal increments between max and min in arithmetic array.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n∗n), traverse each query and each query can be of max n length
 * 
 * Space complexity:
 * 
 * O(n), set size to store nums
 * 
 */
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        List<Boolean> res = new ArrayList();

        // compute each query
        for (int i = 0; i < l.length; i++)
            res.add(isArithmeticSeq(nums, l[i], r[i]));
        return res;
    }

    private boolean isArithmeticSeq(int[] nums, int start, int end) {

        // arithmetic seq by default for 2 length
        if (end - start < 2)
            return true;

        // add nums to set
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet();
        for (int i = start; i <= end; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            set.add(nums[i]);
        }

        // interval exist or not
        if ((max - min) % (end - start) != 0)
            return false;

        // calculate interval
        int interval = (max - min) / (end - start);

        // generate aithmetic array using interval and compare with nums
        for (int i = 1; i <= end - start; i++)
            if (!set.contains(min + i * interval))
                return false;

        return true;
    }
}