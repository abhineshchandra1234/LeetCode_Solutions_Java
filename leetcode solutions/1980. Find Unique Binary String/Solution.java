/**
 * 1980. Find Unique Binary String
 * 
 * Intuition
 * 
 * credits ashucrma
 * we can solve this problem using Cantor's diagonal argument
 * It states that if we have a set of n binary strings of same length, and if we
 * create a new string by fliping the diagonal elements (ith bit of ith string)
 * of n strings we get a new string that is different from n strings
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
    public String findDifferentBinaryString(String[] nums) {

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++)
            ans.append(nums[i].charAt(i) == '0' ? '1' : '0');
        return ans.toString();
    }
}