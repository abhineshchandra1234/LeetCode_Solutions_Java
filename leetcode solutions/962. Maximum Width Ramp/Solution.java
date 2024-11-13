/**
 * 962. Maximum Width Ramp
 * 
 * Intuition
 * we will solve this problem through monotonic stack
 * we will add elements indices in decreasing order in the stack, min no index
 * will be at the top of the stack
 * then we will traverse nums from back, if the curr no is greater than peek
 * update the ramp with their indices difference
 * Finally return ramp at the end
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public int maxWidthRamp(int[] nums) {

        int n = nums.length;
        Stack<Integer> s = new Stack();

        for (int i = 0; i < n; i++) {
            if (s.isEmpty() || nums[s.peek()] > nums[i])
                s.push(i);
        }

        int res = 0;
        for (int j = n - 1; j >= 0; j--) {
            while (!s.isEmpty() && nums[s.peek()] <= nums[j]) {
                res = Math.max(res, j - s.peek());
                s.pop();
            }
        }

        return res;
    }
}