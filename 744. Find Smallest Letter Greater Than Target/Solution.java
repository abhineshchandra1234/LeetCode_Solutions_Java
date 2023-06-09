/**
 * 744. Find Smallest Letter Greater Than Target
 * 
 * Intuition
 * credits nrl
 * We will solve this problem through binary search
 * char will behave same like no, we can do the comparison and find the result.
 * Result can be at n so we will return letters[lo%n]
 * 
 * Complexity
 * Time complexity: O(logn)
 * Space complexity: O(1)
 */
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        int n = letters.length;
        int lo = 0, hi = n;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (letters[mid] > target)
                hi = mid;
            else
                lo = mid + 1;
        }

        return letters[lo % n];
    }
}