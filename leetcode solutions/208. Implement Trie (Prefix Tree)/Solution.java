/**
 * 208. Implement Trie (Prefix Tree)
 * 
 * Intuition
 * 
 * we will solve this problem by creating a class Node which has attribute like
 * self referencing array of size 26 and isEnd boolean variable to mark the end
 * of the word
 * It will contain methods like insert, search and startsWith
 * It will store strings in these node
 * insert
 * For every char a new node will be created, when we reach end of string, isEnd
 * will be marked as true to signify end of word
 * search
 * For every char we will see if a node exist else return false
 * If we reach end of string and node exist and isEnd is true, we found our word
 * startsWith
 * For every char we will see if a node exist else return false
 * If we reach end of string and node exist return true
 * we are using recursion to do insert, search and startsWith operations
 * 
 * Approach
 * 
 * we are using idx to do operations
 * we are checking for its validity to avoid null ptr exception thrown by string
 * 
 * Complexity
 * 
 * Time complexity:
 * insert - O(n)
 * search - O(n)
 * startsWith - O(n)
 * 
 * Space complexity:
 * insert - O(n)
 * search - O(1)
 * startsWith - O(1)
 * 
 */
class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        root.insert(word, 0);
    }

    public boolean search(String word) {
        return root.search(word, 0);
    }

    public boolean startsWith(String prefix) {
        return root.startsWith(prefix, 0);
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

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */