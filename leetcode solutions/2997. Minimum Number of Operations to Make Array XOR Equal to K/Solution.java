/**
 * 2997. Minimum Number of Operations to Make Array XOR Equal to K
 * 
 * Intuition
 * 
 * we know in XOR similar elements cancel each other out
 * so we will do xor of k with all the elements, similar elements or bits in k
 * will be cancelled out
 * the remaining 1 bits in k needs to be flipped and is our answer.
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
    public int minOperations(int[] nums, int k) {

        for (int no : nums)
            k ^= no;
        return Integer.bitCount(k);
    }
}