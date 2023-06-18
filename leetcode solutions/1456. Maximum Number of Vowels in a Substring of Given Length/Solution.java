/**
 * 1456. Maximum Number of Vowels in a Substring of Given Length
 * 
 * Intuition
 * We will maintain a sliding window of size k, where start is i-k & end is i.
 * We will have a var to maintain count of vowels inside the window
 * We will use this var to update max_count on each iteration or sliding.
 * If the curr char is vowel we will increase the var count by 1
 * We will decrease the var by 1 if i-k which is outside the window is vowel,
 * this way we are discarding vowels count outside the window as we slide.
 * like - s = "abciiidef", k = 3
 * till index 2 vowel count is 1
 * on index 3, vowel count is 2 but a is outside win so we discard it, vowel
 * count becomes 1.
 * on index 4, vowel count becomes 2, ab is outside the window, a is already
 * computed and b is not vowel, so vowel count will not change.
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public int maxVowels(String s, int k) {

        HashSet<Character> vowels = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int max_count = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i)))
                count++;
            // outside window
            if (i >= k && vowels.contains(s.charAt(i - k)))
                count--;
            max_count = Math.max(max_count, count);
        }
        return max_count;
    }
}