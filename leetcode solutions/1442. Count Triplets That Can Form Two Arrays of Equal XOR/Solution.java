/**
 * 1442. Count Triplets That Can Form Two Arrays of Equal XOR
 * 
 * Intuition
 * 
 * It is given that j and k can be equal
 * Since two parts are equal, thier xor will be equal to 0
 * For every index we will find xor of all succeding nos from i+1 and curr no,
 * if they xor is zero.
 * The no of triplets count will be k-i. As j&k can take any place between k-i
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n^2), for each index we are taking xor of all nos
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int countTriplets(int[] arr) {

        int n = arr.length, count = 0;

        for (int i = 0; i < n; i++) {
            int value = arr[i];
            for (int k = i + 1; k < n; k++) {
                value ^= arr[k];

                if (value == 0)
                    count += k - i;
            }
        }

        return count;
    }
}