// 3069. Distribute Elements Into Two Arrays I

/**
 * Intuition
 * we will solve this using an extra array and simulation
 * we will have two ptrs, one will point to start of the array and store nos of
 * arr1, second will point to end of the array and store nos of arr2
 * first no will be added to arr1 and second no will be added to arr2
 * then we will simply compare both the ptrs and add all the nos in between
 * nos of arr2 are added in reverse order in arr so we will reverse it
 * finally return the arr as the ans
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        arr[0] = nums[0];
        arr[n - 1] = nums[1];

        int idx = 0, revIdx = n - 1;
        for (int i = 2; i < n; i++) {
            if (arr[idx] > arr[revIdx])
                arr[++idx] = nums[i];
            else
                arr[--revIdx] = nums[i];
        }

        for (int l = revIdx, r = n - 1; l < r; l++, r--) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }

        return arr;
    }
}