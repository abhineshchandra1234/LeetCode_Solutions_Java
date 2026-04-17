// 2075. Decode the Slanted Ciphertext

/**
 * Intuition
 * we will first calculate cols using row and encoded string length
 * then we will traverse encoded string col wise and add cols + 1 char in
 * encoded string to original string
 * After adding everything, blank spaces will be left which will be added at the
 * end of original string
 * we will run a loop to remove blank spaces from original string end
 * Approach
 * 
 * 
 * Complexity
 * Time complexity: O(1)
 * Space complexity: O(1)
 */

class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int l = encodedText.length();
        int cols = l / rows;

        StringBuilder orgText = new StringBuilder();

        for (int col = 0; col < cols; col++) {
            for (int j = col; j < l; j += (cols + 1)) {
                orgText.append(encodedText.charAt(j));
            }
        }

        while (orgText.length() > 0 &&
                orgText.charAt(orgText.length() - 1) == ' ') {
            orgText.deleteCharAt(orgText.length() - 1);
        }

        return orgText.toString();
    }
}
