/**
 * 2616. Minimize the Maximum Difference of Pairs
 * 
 * Intuition
 * 
 * credits lee215
 * we need to return the minimum maximum difference among all pairs
 * to do this we need to keep the difference as minimum as possible among all
 * pairs
 * we will first sort the nums array.
 * the min diff will be zero and max diff will be nums[n - 1] - nums[0]
 * we will apply binary serach on this range
 * we will greedily choose mid as minimum maximum difference and see how many
 * pairs are less than or equal to it
 * if the no of pairs>=p means mid has enough pairs and we will reduce the
 * search size by assigning mid to right else we will assign mid + 1 to left and
 * increase the search size.
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(nlogn), sorting
 * 
 * Space complexity:
 * 
 * O(1)
 * 
 */
class Solution {
    public int minimizeMax(int[] nums, int p) {

        Arrays.sort(nums);
        int n = nums.length, left = 0, right = nums[n - 1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2, k = 0;
            for (int i = 1; i < n && k < p; i++) {
                if (nums[i] - nums[i - 1] <= mid) {
                    k++;
                    i++;
                }
            }
            if (k >= p)
                right = mid;
            else
                left = mid + 1;

        }
        return left;
    }
}