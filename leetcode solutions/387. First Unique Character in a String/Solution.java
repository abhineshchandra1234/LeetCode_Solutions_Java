/**
 * 387. First Unique Character in a String
 * 
 * Intuition
 * 
 * we will first calculate freq of each char using hashmap
 * Then we will traverse hashmap and whose freq is 1 we will return its index
 * 
 * Approach
 * 
 * hashmap will have two states character as key and freq as value
 * 
 * Complexity
 * 
 * Time complexity: O(n), calculating freq
 * 
 * Space complexity: O(1), storing freq
 * 
 */
public class Solution {

    public int firstUniqChar(String s) {

        int freq[] = new int[26], n = s.length();

        // calculate freq
        for (int i = 0; i < n; i++)
            freq[s.charAt(i) - 'a']++;

        // fliter freq 1
        for (int i = 0; i < n; i++)
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        String input1 = "eeltcode";
        String input2 = "loevleetcode";
        String input3 = "aabb";
        String input4 = "abcde";

        int result1 = solution.firstUniqChar(input1);
        int result2 = solution.firstUniqChar(input2);
        int result3 = solution.firstUniqChar(input3);
        int result4 = solution.firstUniqChar(input4);

        System.out.println("First unique character in '" + input1 + "': " + result1);
        System.out.println("First unique character in '" + input2 + "': " + result2);
        System.out.println("First unique character in '" + input3 + "': " + result3);
        System.out.println("First unique character in '" + input4 + "': " + result4);
    }
}
