/**
 * 648. Replace Words
 * 
 * Intuition
 * 
 * we can easily solve this problem through trie
 * the requirement to replace with shortest length is given to confuse
 * candidate, by default you will replace it with shortest root as it will come
 * first in trie. like - r, ra are the roots. always r will be replaced. we
 * cannot have roots df, ra for a word
 * push all roots to trie
 * split the sentence into word array
 * then simply search each word in trie, once you get the word, return its root
 * if you do not get the word ie trie node is null return the word
 * if no root exist, ie you have traversed all chars of word, then also return
 * word.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n), inserting n roots of length l
 * 
 * Space complexity: O(n), storing n roots of length l
 * 
 */
class Solution {

    Trie root;

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new Trie();
        for (String word : dictionary)
            insert(word);
        StringBuilder res = new StringBuilder();
        String[] input = sentence.split(" ");
        for (String i : input) {
            res.append(search(i));
            res.append(" ");
        }
        return res.toString().trim();
    }

    class Trie {
        Trie[] children;
        boolean isEnd;
        String word;

        public Trie() {
            children = new Trie[26];
        }
    }

    public void insert(String word) {
        Trie node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null)
                node.children[i] = new Trie();
            node = node.children[i];
        }
        node.isEnd = true;
        node.word = word;
    }

    public String search(String word) {
        Trie node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null)
                return word;
            else if (node.children[i].isEnd)
                return node.children[i].word;
            else
                node = node.children[i];
        }
        return word;
    }
}