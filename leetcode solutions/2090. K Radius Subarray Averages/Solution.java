/**
 * 2090. K Radius Subarray Averages
 * 
 * Intuition
 * 
 * credits kshatriyas
 * the window size at any point will be 2 * k + 1
 * If the array length is less than window size, we cannot do further
 * calculations and will return the array.
 * Eligible index for calculation will i = k, i + k < n rest all indexes will
 * contain -1.
 * 
 * Approach
 * 
 * Prefix Sum
 * we will first calculate the prefix array where prefix[i] will be equal to the
 * sum of all elements before ith index.
 * For i=k th index, arr[i] = (prefixSum[i + k + 1] - prefixSum[i - k]) /
 * windowSize
 * prefixSum[i + k + 1] will contain sum of all elements outside and inside the
 * window.
 * prefixSum[i - k] will contain sum of all elements outside the window.
 * windowSize will be fixed based on value of k
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public int[] getAverages(int[] nums, int k) {

        int n = nums.length;
        int windowSize = 2 * k + 1;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        if (n < windowSize) {
            return ans;
        }

        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++)
            prefixSum[i + 1] = prefixSum[i] + nums[i];

        for (int i = k; i + k < n; i++)
            ans[i] = (int) ((prefixSum[i + k + 1] - prefixSum[i - k]) / windowSize);

        return ans;
    }
}

/**
 * Approach
 * 
 * Sliding Window
 * We will have a window of size 2 * k + 1
 * When we come across eligible index we will update the index.
 * We will keep discarding nos not part of the window.
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int[] getAverages(int[] nums, int k) {

        int n = nums.length;
        int windowSize = 2 * k + 1;
        long windowSum = 0;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        if (n < windowSize) {
            return ans;
        }

        for (int i = 0; i < n; i++) {

            windowSum += nums[i];

            // removing last element from the window
            if (i - windowSize >= 0)
                windowSum -= nums[i - windowSize];

            // doing calculation for valid index
            if (i >= windowSize - 1)
                ans[i - k] = (int) (windowSum / windowSize);
        }

        return ans;
    }
}