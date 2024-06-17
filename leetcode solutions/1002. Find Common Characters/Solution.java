/**
 * 1002. Find Common Characters
 * 
 * Intuition
 * 
 * we need to find all common chars including duplicates
 * we can solve this using hashmap
 * we will compare the hashmap or freqmap of curr word with the last word and
 * find its intersection. This intersection will be the new last hashmap for the
 * new curr word.
 * This way we will get intersection of all words
 * finally return the resultant map chars by converting it to a list of string
 * 
 * Approach
 * 
 * Duplicate handling - Suppose if a char count is more than 1, then keep adding
 * that char to res till its freq becomes 0
 * 
 * Complexity
 * 
 * Time complexity: O(n), count and intersection takes O(1) time for airthmatic
 * operation of max size 26
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public List<String> commonChars(String[] words) {

        int[] last = count(words[0]);

        for (int i = 1; i < words.length; i++)
            last = intersection(last, count(words[i]));

        List<String> res = new ArrayList();
        for (int i = 0; i < 26; i++) {
            if (last[i] != 0) {
                char a = 'a';
                a += i;
                while (last[i] > 0) {
                    res.add(a + "");
                    last[i]--;
                }
            }
        }

        return res;
    }

    private int[] count(String word) {
        int[] temp = new int[26];
        for (char c : word.toCharArray())
            temp[c - 'a']++;
        return temp;
    }

    private int[] intersection(int[] last, int[] curr) {
        int[] temp = new int[26];
        for (int i = 0; i < 26; i++)
            temp[i] = Math.min(last[i], curr[i]);
        return temp;
    }
}