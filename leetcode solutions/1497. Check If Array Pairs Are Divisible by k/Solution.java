/**
 * 1497. Check If Array Pairs Are Divisible by k
 * 
 * Intuition
 * rem of each no with mod k is from 0 to k-1
 * each rem form pair either in 0 or i and k-i, where i is from 1 to k-1
 * we will store freq of rem
 * we will just check if pairs of rem exists
 * we need to check pairs till k/2 as others are already checked before
 * 
 * Approach
 * Complexity
 * Time complexity: O(n), traversing array
 * Space complexity: O(k), storing freq
 */
class Solution {

    public boolean canArrange(int[] arr, int k) {

        int[] freq = new int[k];

        // storing freq
        for (int num : arr) {
            // math formula to calculate rem for negative no also
            int rem = (num % k + k) % k;
            freq[rem]++;
        }

        // no pair formation
        if (freq[0] % 2 != 0)
            return false;

        for (int i = 1; i <= k / 2; i++) {
            if (freq[i] != freq[k - i])
                return false;
        }

        return true;
    }
}