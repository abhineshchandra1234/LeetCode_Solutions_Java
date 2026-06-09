// 2161. Partition Array According to Given Pivot

/**
 * Intuition
 * we will have res array to store our res
 * we will have two ptrs for original array and two ptrs for res array
 * two ptrs of original array will point to start and end of the original array
 * two ptrs of res array will point to where nos less than pivot will be
 * inserted and nos greater than pivot will be inserted
 * two ptrs of original array will be used to traverse original array
 * two ptrs of res array will be used to compare nos with pivot
 * we will compare nos with pivot and insert them at i_ and j_ indices
 * Finally no equal to pivot will be inserted
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] res = new int[n];

        // ptrs for original array
        int i = 0, j = n - 1;
        // ptrs for res array
        int i_ = 0, j_ = n - 1;

        while (i < n && j >= 0) {
            if (nums[i] < pivot) {
                res[i_] = nums[i];
                i_++;
            }
            if (nums[j] > pivot) {
                res[j_] = nums[j];
                j_--;
            }
            i++;
            j--;
        }
        // fill equal nos to pivot
        while (i_ <= j_) {
            res[i_] = pivot;
            i_++;
        }

        return res;
    }
}