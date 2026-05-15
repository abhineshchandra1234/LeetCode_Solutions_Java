// 167. Two Sum II - Input Array Is Sorted

/**
 * Intuition
 * we will solve this problem through two ptrs
 * one ptr will point to start and other ptr will point to end of numbers array
 * we will find sum by taking sum of curr ptrs
 * if the sum is equal to target, return indexes by increasing by 1
 * if the sum is less than target, increase start ptr meaning we want greater
 * value
 * if the sum is more than target, decrease end ptr meaning we want lesser
 * value.
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int sum = numbers[start] + numbers[end];

            if (sum == target)
                return new int[] { start + 1, end + 1 };
            else if (sum < target)
                start++;
            else
                end--;
        }
        return new int[] {};
    }
}