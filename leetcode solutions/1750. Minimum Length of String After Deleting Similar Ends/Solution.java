/**
 * 1750. Minimum Length of String After Deleting Similar Ends
 * 
 * Intuition
 * 
 * we will solve this problem with two ptrs
 * start ptr will remove chars from start and end ptr will remove chars from
 * end, if the chars is same at both end
 * At last returning chars between both ptrs
 * 
 * Approach
 * 
 * outer loop takes care of intersection and if chars are same
 * inner loop removes chars till the next ptr as rest of the chars are already
 * removed
 * Instead of removing chars we are just moving ptrs to signify char removal
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int minimumLength(String s) {

        int start = 0, end = s.length() - 1;

        while (start < end && s.charAt(start) == s.charAt(end)) {
            char ch = s.charAt(start);
            while (start <= end && s.charAt(start) == ch)
                start++;
            while (end >= start && s.charAt(end) == ch)
                end--;
        }
        return end - start + 1;
    }
}