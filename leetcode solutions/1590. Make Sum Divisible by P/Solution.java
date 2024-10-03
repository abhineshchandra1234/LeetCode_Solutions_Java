/**
 * 1590. Make Sum Divisible by P
 * 
 * Intuition
 * we need to have s%p = 0
 * in case it is not completely divisible s%p = target, target needs to be
 * removed
 * (ci - cj)%p = target
 * cj = (ci - target)%p
 * subtracting target can lead to negative value so we add p before taking
 * modulo
 * cj = (ci - target + p )%p
 * we will store prefix alongwith index in hashmap
 * we will use above formula to find needed prefix using current prefix
 * then use index of curr and needed prefix to find min length to remove
 * Approach
 * 
 * Complexity
 * Time complexity: O(n), calculating prefix
 * Space complexity: O(n), storing prefix with index
 */
class Solution {

    public int minSubarray(int[] nums, int p) {

        int n = nums.length;
        int total = 0;

        for (int num : nums) {
            total = (total + num) % p;
        }

        int target = total % p;
        if (target == 0)
            return 0;

        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, -1);

        int curr = 0;
        int res = n;

        for (int i = 0; i < n; i++) {

            curr = (curr + nums[i]) % p;

            int needed = (curr - target + p) % p;

            if (map.containsKey(needed)) {
                res = Math.min(res, i - map.get(needed));
            }

            map.put(curr, i);
        }

        return res == n ? -1 : res;
    }
}