/**
 * 1051. Height Checker
 * 
 * Intuition
 * 
 * given heights of students in increasing order
 * we need to return count of indices where height[i]!=expected[i]
 * 
 * Approach
 * 
 * while loop cond check will fail for out of bounds, so 101 size is used
 * we will create a freq map of heights
 * then we will start with lowest height and check if it consecutively exist in
 * the array as its freq
 * If it doesnt we will increase the res
 * we will keep increasing curr height till we reach the next height in the freq
 * map
 * we have to reduce freq of curr height after all the operations
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int heightChecker(int[] heights) {

        int[] freq = new int[101];

        for (int h : heights)
            freq[h]++;

        int curr = 0, res = 0;

        for (int i = 0; i < heights.length; i++) {

            while (freq[curr] == 0)
                curr++;

            if (curr != heights[i])
                res++;

            freq[curr]--;
        }

        return res;
    }
}