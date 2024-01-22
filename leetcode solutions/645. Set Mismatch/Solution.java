/**
 * 645. Set Mismatch
 * 
 * Intuition
 * 
 * As evident in the question we will find duplicate no using set
 * we will find missing no by
 * expected sum - (actual sum - duplicate no)
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n), traversing array once
 * 
 * Space complexity: O(n), using set
 * 
 */
class Solution {
    public int[] findErrorNums(int[] nums) {

        int[] res = new int[2];

        int sum = 0;
        HashSet<Integer> set = new HashSet();
        for (int num : nums) {
            sum += num;
            if (!set.add(num))
                res[0] = num;
        }

        int n = nums.length;
        int expSum = n * (n + 1) / 2;
        res[1] = expSum - (sum - res[0]);
        return res;
    }
}