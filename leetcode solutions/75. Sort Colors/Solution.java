/**
 * 75. Sort Colors
 * 
 * Intuition
 * 
 * given an array nums which contain objects of different colors
 * we need to sort them in place
 * we can sort it using counting sort but that will take 2 passes
 * we will bring all 0s at first and all 2s at last
 * so we will be left with 1s in the middle and hence we will get a sorted array
 * in one pass
 * 
 * Approach
 * 
 * we will traverse all nos
 * we will have two ptrs, one pointing at start and other at end
 * if the curr nos is 2 and its index is less than sec as greater index are
 * already sorted by sec,
 * we will swap curr no with sec, and reduce sec
 * If the curr no is 0 and its index is more than first as smaller index are
 * already sorted by first
 * we will swap curr no with first and increase first
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public void sortColors(int[] nums) {

        int n = nums.length;
        int first = 0, sec = n - 1;
        for (int i = 0; i < n; i++) {
            while (nums[i] == 2 && i < sec)
                swap(i, sec--, nums);
            while (nums[i] == 0 && i > first)
                swap(i, first++, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}