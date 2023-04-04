/**
 * 2405. Optimal Partition of String
 * 
 * Intuition
 * We will use HashSet to solve this
 * We will start storing chars in the set and as we encounter a char that is
 * already
 * present in the set, we will reset the set, add the new char and increase the
 * partition count.
 * 
 * Approach
 * We will traverse through the string
 * If the set contains the char we will reset the set and increase the partition
 * count
 * Then we will add char in the set, if it is a repeating char it will be added
 * in the new set.
 * We return count + 1, for the remaining string, there will always be some
 * remaining string
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    public int partitionString(String s) {

        int count = 0;
        HashSet<Character> set = new HashSet();

        for (char c : s.toCharArray()) {

            if (set.contains(c)) {
                count++;
                set = new HashSet();
            }
            set.add(c);
        }

        return count + 1;
    }
}