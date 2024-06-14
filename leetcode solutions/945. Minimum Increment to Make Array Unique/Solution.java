/**
 * 945. Minimum Increment to Make Array Unique
 * 
 * Intuition
 * 
 * Given an integer array nums, in one move we can increment any no by 1
 * we need to return min moves to make each no unique
 * Each no should be equal to prev + 1 ie req
 * no of moves to make curr unique = req - curr
 * Update req for next no as max of (req, curr)+1, as unique curr can start
 * another unique sequence
 * 
 * Approach
 * 
 * First sort the no
 * Traverse the no
 * update res with moves
 * update prev
 * return res
 * 
 * Complexity
 * 
 * Time complexity: O(nlogn)
 * 
 * Space complexity: O(logn)
 * 
 */
class Solution {

    public int minIncrementForUnique(int[] nums) {

        Arrays.sort(nums);
        int res = 0, req = 0;

        for (int no : nums) {

            res += Math.max(req - no, 0);
            req = Math.max(req, no) + 1;
        }

        return res;
    }
}