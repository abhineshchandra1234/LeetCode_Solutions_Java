/**
 * 2038. Remove Colored Pieces if Both Neighbors are the Same Color
 * 
 * Intuition
 * 
 * credits lokeshsenthilkumar
 * we will find all the chars who is equal to i-1 & i+1 chars
 * Based on it we can get count of A & B
 * Inorder for ALice to win count of A > B
 * So count A & B to get the res
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
    public boolean winnerOfGame(String colors) {

        int a = 0, b = 0;

        for (int i = 1; i < colors.length() - 1; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1) && colors.charAt(i) == colors.charAt(i + 1)) {
                if (colors.charAt(i) == 'A')
                    a++;
                else
                    b++;
            }
        }

        return a > b;
    }
}