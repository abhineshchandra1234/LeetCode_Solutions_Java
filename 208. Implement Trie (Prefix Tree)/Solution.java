/**
 * 208. Implement Trie (Prefix Tree)
 * 
 * approach-
 * We will solve this by creating a TrieNode object.
 * TrieNode object will contain a self-refrencing array of size 26
 * and a boolean isWord to mark the end of the word.
 * 
 * insert-
 * we will prase through each char of word, and find its index
 * if there is no TrieNode at that particular index we will create one and move TrieNode to its children
 * At last we will mark isWord as true, we use it as we can have words like bed, bedrock
 * Time - O(n)
 * Space - O(n)
 * 
 * search -
 * we will parse through the char and find index
 * If index is null return false else move TrieNode to its children.
 * At last return true if isWord is true, we can have word like apple, and searching app.
 * Time - O(n)
 * 
 * startsWith - 
 * has same logic has search.
 * At last we will return true, bcs we havent reached end of the word bcs we are searching prefix.
 * we can use same words example as above
 * Time - O(n)
 */
class Trie {
    TrieNode root;
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode it = root;
        for(char c : word.toCharArray()) {
            int i = c - 'a';
            if(it.children[i]==null) {
                it.children[i] = new TrieNode();
            }
            it  = it.children[i];
        }
        it.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode it = root;
        for(char c: word.toCharArray()) {
            int i = c - 'a';
            if(it.children[i]!=null) {
                it = it.children[i];
            }
            else
                return false;
        }
        return it.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode it = root;
        for(char c: prefix.toCharArray()) {
            int i = c - 'a';
            if(it.children[i]!=null) {
                it = it.children[i];
            }
            else
                return false;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */