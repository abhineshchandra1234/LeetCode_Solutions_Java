// 3761. Minimum Absolute Distance Between Mirror Pairs

/**
 * Intuition
 * we will traverse nums and for each curr no we will check if that no exist in
 * map
 * If it does we got a reversed no at earlier index
 * we will calculate diff and update res with min of res and diff
 * For each curr no we will store its reverse and index in the map
 * At last we will return res
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap();
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i]))
                res = Math.min(res, i - map.get(nums[i]));
            map.put(reverse(nums[i]), i);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int reverse(int n) {
        int rev = 0;
        while (n > 0) {
            int rem = n % 10;
            rev = rev * 10 + rem;
            n /= 10;
        }
        return rev;
    }
}