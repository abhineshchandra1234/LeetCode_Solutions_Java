/**
 * 3016. Minimum Number of Pushes to Type Word II
 * 
 * Intuition
 * we are given a string word containing lowercase english letters
 * we need to return min no of pushes required to type the word after re-mapping
 * the keys
 * 
 * Approach
 * we will solve this problem through greedy
 * sort letters in the word based on frequencies in descending order
 * so frequently used word will be assigned at the first level
 * second frequently used word will be assigned at the second level and so on.
 * there are 8 keys, so actual press for each char is (i/8 + 1) * freq
 * for sorted chars, whose index falls between 0-7, will have level 1 with 1 key
 * press
 * for sorted chars, whose index falls between 8-15, will have level 2 with 2
 * key press and so on
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {

    public int minimumPushes(String word) {

        int[] freq = new int[26];

        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        for (int i = 0; i < 26 / 2; i++) {
            int temp = freq[i];
            freq[i] = freq[25 - i];
            freq[25 - i] = temp;
        }

        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0)
                break;
            res += (i / 8 + 1) * freq[i];
        }

        return res;
    }
}