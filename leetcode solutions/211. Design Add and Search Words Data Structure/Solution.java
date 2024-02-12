/**
 * 211. Design Add and Search Words Data Structure
 * 
 * Intuition
 * 
 * It has similar implementation as of
 * 208. Implement Trie (Prefix Tree)
 * We will just tweak the search function to accomodate the dot char
 * we will search all 26 options for every non-null node
 * When we reach end of string instead of returning false, we will return isEnd
 * we do this as we are not checking isEnd in case of dot char as we do with
 * other chars
 * if all nodes are null for dot character then return false
 * means there are no more child nodes
 * eg - we have "ba" in database and we are searching "b.."
 * 
 * Approach
 * Complexity
 * 
 * Time complexity:
 * insert - O(n)
 * search - O(26^n), for every dot character, there will be 26
 * suitable options
 * startsWith - O(n)
 * 
 * Space complexity:
 * insert - O(n)
 * search - O(1)
 * startsWith - O(1)
 * 
 */
class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        root.insert(word, 0);
    }

    public boolean search(String word) {
        return root.search(word, 0);
    }

    class Node {
        Node[] nodes;
        boolean isEnd;

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
            if (idx == n - 1)
                nodes[i].isEnd = true;
            nodes[i].insert(word, idx + 1);
        }

        private boolean search(String word, int idx) {
            int n = word.length();
            // all chars searched
            if (idx >= n)
                return isEnd;
            char c = word.charAt(idx);
            if (c == '.') {
                for (Node node : nodes)
                    if (node != null && node.search(word, idx + 1))
                        return true;
                return false;
            }
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

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
