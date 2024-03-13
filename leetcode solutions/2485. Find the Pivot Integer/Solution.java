/**
 * 2485. Find the Pivot Integer
 * 
 * Intuition
 * 
 * As evident in the question we can solve it using prefix sum
 * we will first take prefix sum from left to right
 * Then we will take prefix sum from right to left, if the prefix sum occurs
 * again for same index, that is our pivot
 * we will optimize above approach using two ptrs
 * one ptr will calculate left sum and second ptr will calculate right sum
 * we will increase the ptr whose sum is less
 * when left sum is equal to right sum and thier next index are same we got
 * pivot at next index, and we will return it
 * if 1..x == x..n then 1..x-1 == x+1..n
 * 
 * Input: n = 8
 * Output: 6
 * left sum = 1 + 2 + 3 + 4 + 5 + 6 = 21
 * right sum = 6 + 7 + 8 = 21
 * left sum - x == right sum - x == 15
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
    public int pivotInteger(int n) {

        if (n == 1)
            return n;

        int left = 1, right = n;
        int sumLeft = left, sumRight = right;
        while (left < right) {
            if (sumLeft < sumRight)
                sumLeft += ++left;
            else
                sumRight += --right;

            // pivot cond
            if (sumLeft == sumRight && left + 1 == right - 1)
                return left + 1;
        }

        return -1;
    }
}