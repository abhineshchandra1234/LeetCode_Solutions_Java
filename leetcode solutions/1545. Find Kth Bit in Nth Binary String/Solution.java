/**
 * 1545. Find Kth Bit in Nth Binary String
 * 
 * Intuition
 * String n and n-1 are same before their length/2
 * if we have k value less than length/2, we can get answer from previous string
 * using recursion without calculating from start, as they will have same index
 * if the k value is equal to length/2, then 1 will be returned
 * if k value is greater than length/2, then curr char will be equal to length -
 * k char index of previous or curr string
 * Again we can apply recursion here using n - 1 string otherwise we need to
 * calculate from start
 * At last flip the bit and return it
 * Approach
 * 
 * Complexity
 * Time complexity: O(n), we are traversing n level for recursion
 * Space complexity: O(n), recursive stack
 */
class Solution {
    public char findKthBit(int n, int k) {

        if (n == 1)
            return '0';

        int length = 1 << n;

        if (k < length / 2)
            return findKthBit(n - 1, k);

        else if (k == length / 2)
            return '1';

        else {
            char bit = findKthBit(n - 1, length - k);
            return (bit == '0') ? '1' : '0';
        }
    }
}