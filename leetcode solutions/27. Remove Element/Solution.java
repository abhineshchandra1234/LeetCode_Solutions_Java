// 27. Remove Element
/**
 * Intuition
 * we will traverse array, if the current element is not equal to val, add it to
 * start of the array otherwise skip it
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 **/

// kotlin
class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {

        var k = 0

        for (i in nums.indices) {
            if (nums[i] != `val`) {
                nums[k++] = nums[i]
            }
        }

        return k
    }
}

    // Java
class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}