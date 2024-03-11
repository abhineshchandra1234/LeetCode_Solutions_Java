/**
 * 791. Custom Sort String
 * 
 * Intuition
 * 
 * we will first mark all chars in s using hash array
 * Then we will traverse order, if order chars are present in s, we will add
 * them to StringBuilder
 * This way we will get a sorted s in StringBuilder
 * Finally we will traverse the remaining chars in hash array and add them to
 * StringBuilder
 * Finally return res as StringBuilder converted to string
 * 
 * Approach
 * 
 * only order chars are unique, s can contain duplicate chars
 * we will add all instances of a chars of s in StringBuilder at once
 * we will use freq of chars of s to mark them or count thier duplicate
 * instances
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public String customSortString(String order, String s) {

        int[] count = new int[26];
        // mark s chars
        for (char c : s.toCharArray())
            count[c - 'a']++;

        // sort s based on order
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray())
            while (count[c - 'a']-- > 0)
                sb.append(c);

        // add remaining chars
        for (char i = 'a'; i <= 'z'; i++)
            while (count[i - 'a']-- > 0)
                sb.append(i);

        return sb.toString();
    }
}