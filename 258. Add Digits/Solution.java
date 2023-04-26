/**
 * 258. Add Digits
 * 
 * Intuition
 * In naive approach you will run a loop till num is greater than 9 and do all
 * operations inside it.
 * or use can use math operation to do it in linear time
 * 10 -> 1, 11->2, 13->4, 18->9
 * You will notice digit sum is equal to mod of 9 res.
 * digit whose mod of 9 is 0 thier sum is 9
 * You can simply take mod if it is 0 return 9 else return actual mod
 * to avoid 0 exception you can take mod of prev no and add 1 to it. as prev no
 * sum will be 1 less than curr no.
 * From question also it is visible for single digit, no should be less than or
 * equal to 9. mod of 9 will eliminate extra num.
 * 
 * Complexity
 * Time complexity: O(1)
 * Space complexity: O(1)
 */
class Solution {
    public int addDigits(int num) {

        // if(num==0)
        // return 0;
        // return num%9==0?9:num%9;

        return 1 + (num - 1) % 9;
    }
}