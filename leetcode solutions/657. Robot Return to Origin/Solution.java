// 657. Robot Return to Origin

/**
 * Intuition
 * when robot moves up, its y axis distance increases so we increase y
 * when robot moves down, its y axis distance decreases so we decrease y
 * Similarly it will be for x axis
 * Finally we will check if x and y is 0, means robot is back to origin
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'U')
                y++;
            else if (c == 'D')
                y--;
            else if (c == 'R')
                x++;
            else if (c == 'L')
                x--;
        }

        return x == 0 && y == 0;
    }
}