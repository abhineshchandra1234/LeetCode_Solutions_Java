/**
 * 169. Majority Element
 * 
 * Intuition
 * 
 * credits rahulvarma5297
 * we can easily solve this problem through sorting or using hashmap, but it
 * will take much space and time
 * we will use Boyer-Moore Majority Voting Algorithm to solve it in linear time
 * and O(1) space
 * Using above alogorithm we will solve it 1 traversal instead of 2
 * In this every no will cancel each other out, max cancellation will be n/2,
 * our no or candidate will survive this cancellation as it exist more than n/2
 * times
 * 
 * Approach
 * 
 * If count is 0 we store curr no as candidate
 * If the curr no is equal to candidate increase count else decrease count
 * this way nos will cancel each other out for max n/2 times
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int majorityElement(int[] nums) {

        int count = 0, candidate = 0;

        for (int num : nums) {
            if (count == 0)
                candidate = num;

            if (num == candidate)
                count++;
            else
                count--;
        }

        return candidate;
    }
}