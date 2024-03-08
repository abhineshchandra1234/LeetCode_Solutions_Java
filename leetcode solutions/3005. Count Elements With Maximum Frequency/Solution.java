/**
 * 3005. Count Elements With Maximum Frequency
 * 
 * 
 * Intuition
 * 
 * we will first calculate freq and maxFreq
 * Then take sum of all frequencies equal to maxFreq
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
    public int maxFrequencyElements(int[] nums) {

        int freq[] = new int[101], max = 0, count = 0;

        for (int no : nums) {
            freq[no]++;
            max = Math.max(max, freq[no]);
        }

        for (int f : freq)
            if (f == max)
                count += f;

        return count;
    }
}