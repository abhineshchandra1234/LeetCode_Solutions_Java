/**
 * 1647. Minimum Deletions to Make Character Frequencies Unique
 * 
 * Intuition
 * 
 * credits votrubac
 * The answer is visible in the question
 * we first calculate the frequency of all the chars then traverse chars.
 * If the frequency already exist we reduce it till it is unique or 0.
 * For every reduced char increase res.
 * we will use set to compare frequency and an array to store the frequency.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n), If all the chars have same count the second loop will run for 26*26 max
 * 
 * Space complexity:
 * 
 * O(1), we are using array of fixed length 26 to store the frequency
 * 
 */
class Solution {
    public int minDeletions(String s) {

        int cnt[] = new int[26], res = 0;
        Set<Integer> used = new HashSet();
        for (int i = 0; i < s.length(); i++)
            cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < 26; i++) {
            while (cnt[i] > 0 && !used.add(cnt[i])) {
                cnt[i]--;
                res++;
            }
        }

        return res;
    }
}