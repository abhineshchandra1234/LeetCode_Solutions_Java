/**
 * 2433. Find The Original Array of Prefix Xor
 * 
 * Intuition
 * 
 * credits md2030
 * we will use the XOR property c=a^b, then a=c^b and b=a^c
 * 
 * Input: pref = [5,2,0,3,1]
 * Output: [5,7,2,3,2]
 * - pref[0] = 5.
 * - pref[1] = 5 ^ 7 = 2. || 7 = 2 ^ 5 = pref[1] ^ pref[0] = pref[i] ^ pref[i-1]
 * - pref[2] = 5 ^ 7 ^ 2 = 0. || 2 = 0 ^ 5 ^ 7 = pref[2] ^ pref[1]
 * - conclusion arr[i] = pref[i] ^ pref[i-1]
 * - pref[3] = 5 ^ 7 ^ 2 ^ 3 = 3.
 * - pref[4] = 5 ^ 7 ^ 2 ^ 3 ^ 2 = 1.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public int[] findArray(int[] pref) {

        int n = pref.length;
        int[] arr = new int[n];
        arr[0] = pref[0];

        for (int i = 1; i < n; i++)
            arr[i] = pref[i] ^ pref[i - 1];

        return arr;
    }
}