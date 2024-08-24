/**
 * 564. Find the Closest Palindrome
 * 
 * Intuition
 * we are given an string n representing an integer
 * we need to return the closest integer which is a palindrome in string format
 * we can have five different scenario
 * palindrome formed by first half of n
 * 12345 -> 12321
 * palindrome formed by first half decremented by 1
 * palindrome formed by first half incremented by 1
 * 139 -> mirror 131 -> closer 141
 * nearest palindrome of the form 99, 999 etc
 * 100 -> 99
 * nearest palindrome of the form 101, 1001 etc
 * 99 -> 101, 999 -> 1001
 * we will increase the acceptance rate of this question :P
 * 
 * Approach
 * we will first determine the length of first half based on string is of even
 * or odd length
 * we will generate above 5 possibilities and add it to the list
 * we will traverse the list and find our res
 * if the diff is equal to curr diff, skip the no
 * if the diff is less than curr diff, update res with the no
 * if the diff is equal to curr diff, update res with min of res and no
 * 
 * 
 * Complexity
 * Time complexity: O(n), traversing string
 * Space complexity: O(n), building the list or taking the substring
 */

class Solution {

    public String nearestPalindromic(String n) {

        int len = n.length();

        // include mid in odd
        // skip mid in even
        int i = len % 2 == 0 ? len / 2 - 1 : len / 2;

        long firstHalf = Long.parseLong(n.substring(0, i + 1));

        List<Long> combinations = new ArrayList();
        boolean even = len % 2 == 0;

        // 5 combinations
        combinations.add(halfToPalindrome(firstHalf, even));
        combinations.add(halfToPalindrome(firstHalf + 1, even));
        combinations.add(halfToPalindrome(firstHalf - 1, even));
        // 100 -> 99
        combinations.add((long) Math.pow(10, len - 1) - 1);
        // 99 -> 101
        combinations.add((long) Math.pow(10, len) + 1);

        // we will traverse the list and find our res
        long diff = Long.MAX_VALUE, res = 0, nl = Long.parseLong(n);

        for (Long comb : combinations) {

            if (comb == nl)
                continue;

            long abs = Math.abs(comb - nl);

            if (abs < diff) {
                diff = abs;
                res = comb;
            } else if (abs == diff) {
                res = Math.min(res, comb);
            }
        }

        return String.valueOf(res);
    }

    private long halfToPalindrome(long left, boolean even) {

        long res = left;

        // res already has mid in case of odd
        if (!even)
            left = left / 10;

        while (left > 0) {
            res = res * 10 + (left % 10);
            left /= 10;
        }
        return res;
    }
}