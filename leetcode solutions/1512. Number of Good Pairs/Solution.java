/**
 * 1512. Number of Good Pairs
 * 
 * Intuition
 * 
 * tere liye :P
 * credits lee215
 * From question it is visible we need to first calculate freq of each no, then
 * apply some operation to find no of pairs
 * For each no n, count[n] pairs will be added to the res
 * Another formula is n*(n-1)/2
 * 
 * Approach
 * 
 * Input: nums = [1,1,1,1]
 * Output: 6
 * like 4 can form pairs with 3 others
 * 3 -> 2 others
 * 2 -> 1 other
 * 1 -> 0
 * total -> 3 + 2 + 1 -> 6
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public int numIdenticalPairs(int[] nums) {

        int res = 0, count[] = new int[101];
        for (int n : nums) {
            res += count[n]++;
        }
        return res;
    }
}