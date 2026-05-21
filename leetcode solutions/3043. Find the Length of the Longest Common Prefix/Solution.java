// 3043. Find the Length of the Longest Common Prefix

/**
 * Intuition
 * we will first traverse arr1, store all nos and its variants in a set
 * then we will traverse arr2, and for each no, we will check all its variants
 * in a set
 * if the set contain a variant for arr2, we will update the res with max of res
 * and no of digits of the variant
 * Approach
 * 
 * Complexity
 * Time complexity: O(nlog10n), there are n nos and we are calculating length of
 * each no
 * Space complexity: O(nlog10n), there are n nos and each no has log10n diffrent
 * forms stored in set
 */

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> s = new HashSet();

        for (int num : arr1) {
            while (!s.contains(num) && num > 0) {
                s.add(num);
                num /= 10;
            }
        }

        int res = 0;
        for (int num : arr2) {
            while (!s.contains(num) && num > 0)
                num /= 10;
            if (num > 0)
                res = Math.max(res, (int) (Math.log10(num) + 1));
        }

        return res;
    }
}

/**
 * Intuition 2
 * we can also use trie to solve this
 * Insert nos of arr1 in trie
 * Then just traverse nos in arr2, and search the nos in trie, it will return
 * the length of longest common prefix
 * 
 * Complexity 2
 * Time complexity: O(n*l), there are n nos, l is the avg length of each no
 * Space complexity: O(n*l), we are storing n nos and its variants of l avg
 * length
 */

class TrieNode {
    TrieNode[] children = new TrieNode[10]; // 0, 1, 2...9
}

class Solution {

    public TrieNode getTrieNode() {
        return new TrieNode();
    }

    public void insert(int num, TrieNode root) {
        TrieNode crawl = root;
        String numStr = Integer.toString(num);

        for (char ch : numStr.toCharArray()) {
            int idx = ch - '0';
            if (crawl.children[idx] == null) {
                crawl.children[idx] = getTrieNode();
            }
            crawl = crawl.children[idx];
        }
    }

    // Returns the length of the longest prefix
    public int search(int num, TrieNode root) {
        TrieNode crawl = root;
        String numStr = Integer.toString(num);
        int length = 0;

        for (char ch : numStr.toCharArray()) {
            int idx = ch - '0';
            if (crawl.children[idx] != null) {
                length++;
                crawl = crawl.children[idx];
            } else {
                break;
            }
        }

        return length;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode root = getTrieNode(); // TRIE

        // Insert all elements of arr1 into the trie
        for (int num : arr1) {
            insert(num, root);
        }

        int result = 0;
        // Search for the longest common prefix in arr2
        for (int num : arr2) {
            result = Math.max(result, search(num, root));
        }

        return result;
    }
}