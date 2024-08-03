/**
 * 1460. Make Two Arrays Equal by Reversing Subarrays
 * 
 * Intuition
 * we are given two integer arrays of equal length target and arr
 * we can choose any non-empty subarray of arr and reverse it any no of times
 * we need to return true if we can make arr equal to target or false otherwise
 * 
 * 
 * Approach
 * Since the arrays can contain duplicates, we cannot solve it using set
 * we can solve it using sorting or hashtable, here we are using hashtable
 * we will increase freq of nos in hashtable for target nos and decrease for arr
 * nos
 * Finally check if all freqs are 0
 * 
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {

    public boolean canBeEqual(int[] target, int[] arr) {

        int[] map = new int[1001];

        for (int i = 0; i < target.length; i++) {
            map[target[i]]++;
            map[arr[i]]--;
        }

        return Arrays.equals(map, new int[1001]);
    }
}