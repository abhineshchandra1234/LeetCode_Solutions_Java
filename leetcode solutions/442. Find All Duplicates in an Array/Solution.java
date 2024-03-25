/**
 * 442. Find All Duplicates in an Array
 * 
 * Intuition
 * 
 * we can uniquely identify each no with its index
 * If we come across any no we will convert its index to -ve
 * So no which appear twice will already be -ve and will be added in the res
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
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> res = new ArrayList();
        for (int no : nums) {
            int temp = Math.abs(no);
            if (nums[temp - 1] > 0)
                nums[temp - 1] *= -1;
            else
                res.add(temp);
        }
        return res;
    }
}