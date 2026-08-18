// 3471. Find the Largest Almost Missing Integer

/**
 * Intuition
 * we will solve this problem through brute force
 * if n==k, we will return the largest of the whole array, even if it exist
 * multiple times, it will only belong to one subarray of size n
 * if k==1, we need to return the largest of whole array, it will exist once in
 * subarray of size 1
 * if 1<k<n, return first or last no, whichever is greatest and occurs only
 * once, if they occur more than one time return -1
 * rest of the nos between 1 and n indices will occur in more than one subarray
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        // return largest of whole array
        if (n == k) {
            int res = nums[0];
            for (int x : nums)
                res = Math.max(res, x);
            return res;
        }

        int[] freq = new int[51];
        for (int x : nums)
            freq[x]++;

        // return largest of single occurance
        if (k == 1) {
            for (int i = 50; i >= 0; i--)
                if (freq[i] == 1)
                    return i;
            return -1;
        }

        // for 1<k<n
        int res = -1;
        if (freq[nums[0]] == 1)
            res = Math.max(res, nums[0]);
        if (freq[nums[n - 1]] == 1)
            res = Math.max(res, nums[n - 1]);

        return res;
    }
}