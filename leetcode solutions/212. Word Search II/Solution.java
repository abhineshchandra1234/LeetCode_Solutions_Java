/*
 * 212. Word Search II
 * 
 * Intuition
 * 
 * credits yavinci
 * we will solve this problem using dfs and trie
 * first we will construct trie using all words
 * then we will traverse each chars and do dfs in 4 dirs
 * Only insert func is needed in trie
 * 
 * Approach
 * 
 * To avoid same char more than once in a word change the curr char to '#' and
 * after dfs assign the char its original value
 * In dfs if we reach end of any word, add the word to res
 * we have res as set, as we can have repeating words.
 * Different chars can form words
 * 
 * Complexity
 * 
 * Time complexity: O(n*m*4^k), for every chars in board we
 * are doing dfs in 4 dirs, with each containing k nodes ie total chars
 * 
 * Space complexity: O(n*m), words length of n with m avg length
 * word to construct trie
 * 
 */
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();
        for (String word : words)
            root.insert(word, 0);
        Set<String> res = new HashSet();
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                dfs(board, root, res, i, j);

        return new ArrayList(res);
    }

    public void dfs(char[][] board, Node root, Set<String> res, int i, int j) {
        int n = board.length, m = board[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] == '#' ||
                root.nodes[board[i][j] - 'a'] == null)
            return;
        if (root.nodes[board[i][j] - 'a'].isEnd)
            res.add(root.nodes[board[i][j] - 'a'].word);

        root = root.nodes[board[i][j] - 'a'];
        char c = board[i][j];
        board[i][j] = '#';
        dfs(board, root, res, i - 1, j);
        dfs(board, root, res, i + 1, j);
        dfs(board, root, res, i, j - 1);
        dfs(board, root, res, i, j + 1);
        board[i][j] = c;
    }

    class Node {
        Node[] nodes;
        boolean isEnd;
        String word;

        Node() {
            nodes = new Node[26];
        }

        private void insert(String word, int idx) {
            int n = word.length();
            // to avoid null ptr exception for string
            // no more chars to insert
            if (idx >= n)
                return;
            int i = word.charAt(idx) - 'a';
            if (nodes[i] == null)
                nodes[i] = new Node();
            if (idx == n - 1) {
                nodes[i].isEnd = true;
                nodes[i].word = word;
            }
            nodes[i].insert(word, idx + 1);
        }

        private boolean search(String word, int idx) {
            int n = word.length();
            // all chars searched
            if (idx >= n)
                return false;
            Node node = nodes[word.charAt(idx) - 'a'];
            if (node == null)
                return false;
            if (idx == n - 1 && node.isEnd)
                return true;
            return node.search(word, idx + 1);
        }

        private boolean startsWith(String prefix, int idx) {
            int n = prefix.length();
            // all chars searched
            if (idx >= n)
                return false;
            Node node = nodes[prefix.charAt(idx) - 'a'];
            if (node == null)
                return false;
            if (idx == n - 1)
                return true;
            return node.startsWith(prefix, idx + 1);
        }
    }
}