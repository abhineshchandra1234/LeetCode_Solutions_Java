/**
 * 1887. Reduction Operations to Make the Array Elements Equal
 * 
 * Intuition
 * 
 * credits votrubac
 * we will sort the array so that we get largest and second largest easily and
 * traverse from right-left and compare curr element with prev element
 * If they are different we need to convert all elements in right side ie n-j
 * operations
 * 
 * Approach
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
    public int reductionOperations(int[] nums) {

        int res = 0, sz = nums.length;
        Arrays.sort(nums);
        for (int j = sz - 1; j > 0; j--)
            if (nums[j - 1] != nums[j])
                res += sz - j;
        return res;
    }
}