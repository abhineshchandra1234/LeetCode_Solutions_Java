/**
 * 1287. Element Appearing More Than 25% In Sorted Array
 * 
 * Intuition
 * Approach 1 (quater ahead)
 * 
 * we need a no which exist more than the quater, so difference between its
 * leftmost position and rightmost pst must be greater than quater
 * so we will compare arr[i] & arr[i+quater], if they are equal return arr[i]
 * 
 * Approach 2 (binary search)
 * 
 * we need a no which exist more than the quater
 * we will divide the array into three parts 25%, 50%, 75%
 * if the ans exist in 25%, it must fill up 25% and beyond
 * so we will pick any no, and check if
 * rightPst - leftPst + 1 > quater
 * if it is we got our answer
 * same we will do for 50% and 75%. so total we have 3 candidates.
 * TC - O(logn), SC - O(1)
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
    public int findSpecialInteger(int[] arr) {

        int n = arr.length, t = n / 4;

        for (int i = 0; i < n - t; i++)
            if (arr[i] == arr[i + t])
                return arr[i];

        return -1;
    }
}