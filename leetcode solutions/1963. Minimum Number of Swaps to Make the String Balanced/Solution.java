/**
 * 1963. Minimum Number of Swaps to Make the String Balanced
 * 
 * Intuition
 * every swap will decrease 2 closing brackets
 * so we will take max closing bracket / 2 as our ans
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {

    public int minSwaps(String s) {

        int close = 0, maxClose = 0;

        for (char c : s.toCharArray()) {
            if (c == '[')
                close -= 1;
            else
                close += 1;
            maxClose = Math.max(maxClose, close);
        }

        return (maxClose + 1) / 2;
    }
}