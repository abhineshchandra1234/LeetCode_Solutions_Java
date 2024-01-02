/**
 * 2610. Convert an Array Into a 2D Array With Conditions
 * 
 * Intuition
 * 
 * credits lee215
 * we will solve this problem using max freq
 * no of rows is equal to max freq
 * we will traverse nums and groups elements according to curr freq
 * Suppose 1 occur 3 times it will be placed in 1,2,3 rows
 * Suppose 2 occur 2 times it will be placed in 1,2 rows.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 * 
 */
class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {

        int[] freq = new int[nums.length + 1];

        List<List<Integer>> ans = new ArrayList();
        for (int c : nums) {
            if (freq[c] >= ans.size())
                ans.add(new ArrayList());

            // store elemt in row equal to curr freq
            ans.get(freq[c]).add(c);
            freq[c]++;
        }
        return ans;
    }
}