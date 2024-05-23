/**
 * 78. Subsets
 * 
 * Intuition
 * 
 * we generally solve subset problem using backtracking
 * we generally need to use index, res, curr arr
 * we will also use temp list to find each subset
 * For each index we have a choice either to pick that no or skip it
 * we will call recursive function for each index, inside the recursive function
 * we will have a loop from curr idx till last idx
 * we will add curr no in temp list and call recursion on next index
 * then we will remove curr no or last no from the temp list and move to the
 * next index or no
 * we will add temp list to res at the start of the recursive function for each
 * index.
 * 
 * Note - This similar concept of backtracking can be applied to subsets,
 * permutations, combination sums, Palindrome Partitioning etc.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(2^n), we are generating 2^n subsets and copying subsets
 * of avg length n into res
 * 
 * Space complexity: O(n), recursive stack length is equal to n indices
 * 
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList();
        helper(res, new ArrayList(), nums, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
        res.add(new ArrayList(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(res, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}