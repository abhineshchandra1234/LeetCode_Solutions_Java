/**
 * 912. Sort an Array
 * 
 * Intuition
 * we are given integer array nums, we need to sort the array in ascending order
 * and return it
 * 
 * Approach
 * we will use merge sort to solve this problem
 * merge sort has the best time in case of large datasets ie O(nlogn)
 * most sorting algorithm has time complexity of O(n^2) for large datasets
 * 
 * Complexity
 * Time complexity: O(nlogn)
 * Space complexity: O(n), temp array for merging
 */
class Solution {

    public int[] sortArray(int[] nums) {

        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int l, int r) {

        if (l < r) {
            int m = l + (r - l) / 2;
            sort(nums, l, m);
            sort(nums, m + 1, r);
            merge(nums, l, m, r);
        }
    }

    private void merge(int[] nums, int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - (m + 1) + 1;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = nums[l + i];
        for (int j = 0; j < n2; j++)
            R[j] = nums[m + 1 + j];

        int i = 0, j = 0;

        int k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                nums[k] = L[i];
                i++;
            } else {
                nums[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            nums[k] = L[i];
            k++;
            i++;
        }

        while (j < n2) {
            nums[k] = R[j];
            k++;
            j++;
        }
    }
}