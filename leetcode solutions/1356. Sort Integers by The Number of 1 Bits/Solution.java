/**
 * 1356. Sort Integers by The Number of 1 Bits
 * 
 * Intuition
 * 
 * we need to count no of bits and sort nos first on basis of bits then its
 * value
 * 
 * 11 -> 3 bits
 * 16 -> 1 bit
 * 8 -> 1 bit
 * 4 -> 1 bit
 * 
 * one way to sorts is arr[i] + 10001 + bitCount
 * Doing this we will get no out of scope of nos till 10000 but it has one issue
 * it does not divide nos into different bit group
 * despite 16 being greater it will come after 11 which is not correct
 * arr[i] = countBit(arr[i]) * 10001 + arr[i];
 * It will divide the no into different bit group and help us in sorting first
 * on basis of bits then its value.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(nlogn)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int[] sortByBits(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++)
            arr[i] = countBit(arr[i]) * 10001 + arr[i];
        Arrays.sort(arr);
        for (int i = 0; i < n; i++)
            arr[i] %= 10001;
        return arr;
    }

    private int countBit(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>= 1;
        }
        return res;
    }
}