/**
 * 896. Monotonic Array
 * 
 * Intuition
 * 
 * After seeing question I first thought of using two flags isInc & isDec and
 * two loops to update the flags
 * Later return res using thier or operation
 * But we can update both flags in single loop using two indepent checks
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public boolean isMonotonic(int[] nums) {

        boolean isInc = true;
        boolean isDec = true;

        for (int i = 1; i < nums.length; i++) {
            if (!isInc && !isDec)
                return false;

            if (nums[i - 1] > nums[i])
                isInc = false;

            if (nums[i - 1] < nums[i])
                isDec = false;
        }

        return isInc || isDec;
    }
}