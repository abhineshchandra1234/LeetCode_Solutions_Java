/**
 * 131. Palindrome Partitioning
 * 
 * Intuition
 * 
 * credits y495711146
 * we will solve this problem through backtracking, as it can be divided into
 * multiple sub-problems and each sub-problem can be solved independently
 * we will take a substring from 0 to i
 * If the substring is not a palindrome we will skip to next index
 * If this substring is a palindrome we got our base solution, add this base
 * solution to step or local res
 * now we will explore all its possible extensions
 * when we reach end of the string for the base solution, we have finished
 * computation for curr index, we will add base solution as well as all possible
 * extensions solution to res from step
 * Then we will remove base and extension solutions through backtracking from
 * step or local res and proceed to next index.
 * 
 * Note - For each index, base and extension solutions will be added to the step
 * and after adding all solutions to res. Each solution will be removed from
 * step in backtracking and we will move to next index with empty step
 * 
 * Approach
 * 
 * we add a copy of step or local res to final res, as step will be used for
 * further computation of next indices
 * Three steps are involved in backtracking choose, explore and unchoose.
 * 
 * Complexity
 * 
 * Time complexity: O(n*2^n), for n chars we are generating 2^n subsets each
 * 
 * Space complexity: O(n), recursive stack length is equal to n indices
 * 
 */
class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList();

        helper(s, res, new ArrayList());
        return res;
    }

    private void helper(String s, List<List<String>> res, List<String> step) {

        if (s.length() == 0)
            res.add(new ArrayList(step));

        for (int i = 1; i <= s.length(); i++) {

            String temp = s.substring(0, i);
            if (!isPalindrome(temp))
                continue;
            // choose
            step.add(temp);
            // explore
            helper(s.substring(i), res, step);
            // un-choose
            step.remove(step.size() - 1);
        }

        return;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}