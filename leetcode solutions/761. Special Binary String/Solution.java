// 761. Special Binary String

/**
 * Intuition
 * A special string will have 1 at start and 0 at the end, to follow
 * lexicographically largest
 * we are taking 1 as 1 and 0 as -1, where its sum will be 0, will be our
 * special string
 * Inner string ie start +1 till i-1, can also produce more efficient special
 * string, so we will call recursion on inner string
 * We will add processed inner string to a list
 * later we will sort the list in descending order and add all its values to res
 * Lastly return res as a string
 * Approach
 * 
 * Complexity
 * Time complexity: O(n^2), traversing string then again calling recursion for
 * inner string
 * Space complexity: O(n), storing inner strings
 */

class Solution {
    public String makeLargestSpecial(String s) {
        List<String> specials = new ArrayList<>();
        int count = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            count += (s.charAt(i) == '1') ? 1 : -1;

            if (count == 0) {
                String inner = s.substring(start + 1, i);

                String processed = "1" + makeLargestSpecial(inner) + "0";
                specials.add(processed);

                start = i + 1;
            }
        }

        Collections.sort(specials, Collections.reverseOrder());

        StringBuilder result = new StringBuilder();
        for (String str : specials) {
            result.append(str);
        }

        return result.toString();
    }
}