/**
 * 1704. Determine if String Halves Are Alike
 * 
 * Intuition
 * 
 * As evident in the question we will use set to solve this problem
 * we will divide the string into two parts and count vowels using set
 * If the count is equal return true else false
 * To further optimize it you can traverse using two ptrs one from start and
 * other from end, without dividing the string
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public boolean halvesAreAlike(String s) {
        HashSet<Character> set = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u',
                'A', 'E', 'I', 'O', 'U'));
        int a = 0, b = 0, n = s.length();
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            a += set.contains(s.charAt(i)) ? 1 : 0;
            b += set.contains(s.charAt(j)) ? 1 : 0;
        }
        return a == b;
    }
}