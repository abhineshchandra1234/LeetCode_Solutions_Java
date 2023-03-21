/**
 * 2348. Number of Zero-Filled Subarrays
 * 
 * approach-
 * At every index which contains zero, we will see how many zero-filled subarrays are ending at the current index.
 * we will add the count in res
 * You will notice the count is increasing by 1 with each continuous 0. Again it will reset to 0 for non-zero num.
 * subarrays ending at 
 * 1st zero is 1 - 0
 * 2nd zero is 2 - x0, 00
 * 3rd zero is 3 - xx0, x00, 000
 * 4th zero is 4 - xxx0, xx00, x000, 0000
 * 
 * Time - O(n)
 * Space - O(1)
 */
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count=0, zeroSub=0;

        for(int n:nums) {
            if(n==0)
                count += ++zeroSub;
            else
                zeroSub = 0;
        }

        return count;
    }
}