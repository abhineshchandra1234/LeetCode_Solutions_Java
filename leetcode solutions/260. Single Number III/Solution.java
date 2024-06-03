/**
 * 260. Single Number III
 * 
 * Intuition
 * 
 * This question is tricky and not easy
 * the simplest evident solution is to use XOR and solve it
 * but how can we solve using xor
 * we will divide all the nos in two groups using the different righmost 1 bit
 * of unique nos
 * Then we will do xor in both groups and we will get unique no for each group
 * which is our answer
 * one group will resemble first unique no and second group will resemble second
 * unique no, and all the pairs will be in same group and cancel each other out
 * 
 * Approach
 * 
 * if xor bit is 0, means that bit is same in both unique nos, else if bit is 1
 * means they are different
 * we can easily find this bit by doing xor of xor & different combinations of 1
 * then we will simply divide nos into groups which has ith bit as 1 or 0
 * 
 * Input: nums = [1,2,1,3,2,5]
 * Output: [3,5]
 * 3 -> 011
 * 5 -> 101
 * res -> 110
 * group 1 (1) or res[0] -> 1, 1, 2, 2, 3 -> 3
 * group 2 (0) or res[1] -> 5 -> 5
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int[] singleNumber(int[] nums) {

        int xor = 0;
        for (int n : nums)
            xor ^= n;

        int diffBit = 1;

        while ((diffBit & xor) == 0)
            diffBit <<= 1;

        int[] res = new int[2];

        for (int n : nums) {
            if ((n & diffBit) == 0)
                res[0] ^= n;
            else
                res[1] ^= n;
        }

        return res;
    }
}