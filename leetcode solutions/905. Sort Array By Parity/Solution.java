/**
 * 905. Sort Array By Parity
 * 
 * Intuition
 * 
 * credits lee215
 * It is easier to solve with help of extra array, but how to do it in-place
 * We will use two ptrs, one ptr will parse the array, other ptr will point to
 * index at front where we can place even no
 * As soon we encounter even no it will swap with the front index
 * Front index can point to even or odd no it doesnt matter.
 * So if it is even no at front index it will eventually:P come fwd otherwise if
 * it is odd no it is supposed to be at the back
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
    public int[] sortArrayByParity(int[] nums) {

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] % 2 == 0) {
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j] = temp;
            }
        }

        return nums;
    }
}