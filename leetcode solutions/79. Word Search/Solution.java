/**
 * 79. Word Search
 * 
 * Intuition
 * 
 * we will solve this problem through dfs
 * For each char we will apply dfs in all 4 dirs, if it is found we will return
 * true
 * we will return false at the end after parsing every char
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public boolean exist(char[][] board, String word) {

        int n = board.length, m = board[0].length;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (dfs(i, j, board, word, 0))
                    return true;

        return false;
    }

    private boolean dfs(int x, int y, char[][] board, String word, int count) {

        if (count == word.length())
            return true;

        int n = board.length, m = board[0].length;

        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != word.charAt(count))
            return false;

        char temp = board[x][y];
        board[x][y] = '*';

        boolean found = dfs(x + 1, y, board, word, count + 1)
                || dfs(x - 1, y, board, word, count + 1)
                || dfs(x, y + 1, board, word, count + 1)
                || dfs(x, y - 1, board, word, count + 1);

        board[x][y] = temp;

        return found;
    }
}