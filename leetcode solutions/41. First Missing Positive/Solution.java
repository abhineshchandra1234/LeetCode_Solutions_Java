/**
 * 41. First Missing Positive
 * 
 * Intuition
 * 
 * The logic is simple for this
 * Smallest missing positive integer will be from 1 to n, where n is the nums
 * length
 * if 1 to n are present then it would be n + 1
 * 1st Approach
 * visited array
 * if the no is in the range ie from 1 to n, mark that index as seen
 * Then simply traverse visited array and return index which is not seen, if all
 * indices are seen return n+1
 * 2nd Approach
 * Place no at correct index
 * If the no is in the range ie from 1 to n, then place it at its correct index
 * ie nums[i]-1
 * Again old value of nums[i]-1, can be in range so keep repeating the process
 * till all values are placed at correct index.
 * Then simply traverse nums and check if nums[i] = i + 1, if it is not then
 * curr index is least positive missing and return i + 1, as all nos in range
 * are already at correct index
 * if all nums[i] = i+ 1 ie we have all the nos of range return n+1
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
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }

        for (int i = 0; i < n; i++)
            if (nums[i] != i + 1)
                return i + 1;

        return n + 1;
    }
}