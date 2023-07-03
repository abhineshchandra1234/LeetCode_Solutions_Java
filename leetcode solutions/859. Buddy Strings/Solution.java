/**
 * 859. Buddy Strings
 * 
 * Intuition
 * 
 * credits lee215
 * This question has two cases from top
 * If they are of unequal length return false as we need to obtain same string
 * as goal after swappings two chars of s among themselves.
 * Second case is of equal length which again has two scenarios.
 * The first scenario is same string. If all the chars are unique then we cant
 * do swap operation.
 * If we have min one duplicate char we can swap chars to obtain goal.
 * The second scenario is different string. In this string there should be
 * exactly two diff chars in s compared to goal.
 * and two diff chars of s should be equal to two diff chars of goal.
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public boolean buddyStrings(String s, String goal) {

        // Unequal length
        if (s.length() != goal.length())
            return false;

        // Equal length

        // same string(unique & duplicate chars)
        if (s.equals(goal)) {
            Set<Character> set = new HashSet();
            for (char c : s.toCharArray())
                set.add(c);
            return set.size() < s.length();
        }

        // different string
        List<Integer> diff = new ArrayList();
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) != goal.charAt(i))
                diff.add(i);

        return diff.size() == 2
                && s.charAt(diff.get(0)) == goal.charAt(diff.get(1))
                && s.charAt(diff.get(1)) == goal.charAt(diff.get(0));
    }
}