/**
 * 
 * 2600. K Items With the Maximum Sum
 * 
 * Intuition
 * We will first pick numOnes as it has the highest value, then we will pick
 * numZeros and at last numNegOnes.
 * 
 * Approach
 * we will run a loop k times
 * we will first pick numOnes then numZeros and finally numNegOnes and add their
 * values to the result till they become empty.
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int sum = 0;
        while (k-- > 0) {
            if (numOnes > 0) {
                sum += 1;
                numOnes--;
            } else if (numZeros > 0) {
                numZeros--;
            } else if (numNegOnes > 0) {
                sum -= 1;
                numNegOnes--;
            }
        }
        return sum;
    }
}