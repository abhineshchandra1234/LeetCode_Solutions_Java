/**
 * 977. Squares of a Sorted Array
 * 
 * Intuition
 * 
 * The question is asking us to solve in O(n) time so some extra array is needed
 * to store nos
 * To maintain O(n) time we need to store nos from end in res array, then also
 * we need to sort nos at end
 * Its good nums array is already sorted
 * if you convert all values to positive you will notice, nos are sorted on both
 * sides of mid and are lowest near mid
 * 
 * [-4,-1,0,3,10] -> [4, 1, 0, 3, 10]
 * 
 * we will use two ptrs to compare extreme ends and add it to res
 * we have used for loop instead of while loop to cover all nos, bcs there can
 * be some nos left when start<end condition breaks
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n), traversing each element once
 * 
 * Space complexity: O(n), storing nos in res array
 * 
 */
class Solution {
    public int[] sortedSquares(int[] nums) {

        int n = nums.length;
        int start = 0, end = n - 1;
        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            if (Math.abs(nums[start]) < Math.abs(nums[end])) {
                res[i] = nums[end] * nums[end];
                end--;
            } else {
                res[i] = nums[start] * nums[start];
                start++;
            }
        }
        return res;
    }
}