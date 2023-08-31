/**
 * 1326. Minimum Number of Taps to Open to Water a Garden
 * 
 * Intuition
 * 
 * we will solve this problem through greedy approach
 * the question says we have garden from 0 to n and we have tap from 0 to n.
 * Each tap range is given like 1,4,5 etc, we need to find min no of taps to
 * cover entire garden
 * It is similar to 45. Jump Game II & 1024. Video Stitching
 * 
 * Approach
 * 
 * We will first find taps that cover min 0 and max range, after traversing
 * whole list
 * once we got that we will increase open count
 * For next loop we will set min to max.
 * So that we can find taps which cover min to n. we already have tap count for
 * 0 to min.
 * If max becomes equals to n we will break the loop means we covered entire
 * garden
 * If we could not cover entire garden the terminating cond is min will be equal
 * to max and return -1
 * Finally return open.
 * 
 * eg - suppose we have garden of length n =10
 * Suppose we got first tap will covers min 0 and max 5
 * For next iteration min will be 5
 * we got second tap which covers min 4 and max 10
 * we got our answer as 2.
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int minTaps(int n, int[] ranges) {

        int min = 0;
        int max = 0;
        int open = 0;
        while (max < n) {
            for (int i = 0; i < ranges.length; i++) {
                if (i - ranges[i] <= min && i + ranges[i] > max)
                    max = i + ranges[i];
            }
            if (min == max)
                return -1;
            open++;
            min = max;
        }
        return open;
    }
}