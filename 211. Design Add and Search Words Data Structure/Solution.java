/**
 * 211. Design Add and Search Words Data Structure
 * 
 * approach-
 * It has similar logic as 208. Implement Trie (Prefix Tree)
 * search method will be modified a little
 * 
 * search-
 * when we encounter dot char we will use recursion to solve this.
 * we will check all 26 chars if it leads to a word, we will use pos to traverse word
 * eg - search - b.t, words - bar, bmt
 * In the above example you can see after 'b' there is a dot.
 * first we search through 'a' we get false, we will not return this value
 * we will keep searching through 'm' we get true, we will return this value
 * And suppose if all 26 chars doesnt return true then finally we will return false.
 * eg - search - b., words - b
 * 
 * Time - O(n*n)
 * Space - O(n*n)
 */
class WordDictionary {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isWord = false;
    }
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode temp = root;
        for(char c:word.toCharArray()) {
            int i = c-'a';
            if(temp.child[i]==null)
                temp.child[i] = new TrieNode();
            temp = temp.child[i];
        }
        temp.isWord = true;
    }

    public boolean search(String word) {
        TrieNode temp = root;
        return helper(temp,0,word);
    }

    public boolean helper(TrieNode temp,int pos,String word) {
        for(int i=pos;i<word.length();i++) {
            if(word.charAt(i)=='.') {
                for(int j=0;j<26;j++) {
                    if(temp.child[j]!=null) {
                        if(helper(temp.child[j],i+1,word))
                            return true;
                    }
                }
                return false;
            }
            else {
                int in = word.charAt(i)-'a';
                if(temp.child[in]!=null)
                    temp = temp.child[in];
                else
                    return false;
            }
        }
        return temp.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */