/**
 * 238. Product of Array Except Self
 * 
 * Intuition
 * 
 * credits dead_lock
 * Brute Force
 * First Approach - For each no we will find product of all nos except self
 * using two loops
 * TC - O(n^2)
 * Second Approach - Find product of all nos then for each no just divide
 * product with self
 * TC - O(n)
 * Optimal Approach
 * First Approach - take two arrays to store prefix product and suffix product
 * for each index
 * Traverse array from left to right find prefix product for each index and
 * store in prefix product array
 * Similarly calculate suffix product by traversing array from right to left
 * Then again traverse array and for each no res would be product of prefix and
 * suffix
 * TC - O(n), SC - O(n)
 * Second Approach - Same prefix and suffix principal is followed
 * Find prefix using var curr and store in res array by traversing array from
 * left to right
 * Find suffix by reseting var curr and multiplying it in res to get final value
 * by traversing array from right to left.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */

// Java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        int curr = 1;
        for (int i = 0; i < n; i++) {
            res[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= curr;
            curr *= nums[i];
        }
        return res;
    }
}

// Java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] p = new int[n];
        int[] s = new int[n];

        p[0] = 1;
        s[n - 1] = 1;

        // prefix
        for (int i = 1; i < n; i++) {
            p[i] = p[i - 1] * nums[i - 1];
        }

        // suffix
        for (int i = n - 2; i >= 0; i--) {
            s[i] = s[i + 1] * nums[i + 1];
        }

        // ans
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = p[i] * s[i];
        }
        return ans;
    }
}

// kotlin

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        
        var n = nums.size
        var ans = IntArray(n) {1}

        var curr = 1
        for(i in 0 until n) {
            ans[i] *= curr
            curr *= nums[i]
        }

        curr = 1
        for(i in n-1 downTo 0) {
            ans[i] *= curr
            curr *= nums[i]
        }

        return ans
    }
}