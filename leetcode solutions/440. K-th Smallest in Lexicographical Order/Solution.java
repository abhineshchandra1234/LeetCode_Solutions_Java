/**
 * 440. K-th Smallest in Lexicographical Order
 * 
 * Intuition
 * Given
 * two integers n and k, need to return kth lexicographically smallest no
 * we can solve this problem through trie
 * lowest lexicographically smallest no will be 1 and its subsideries
 * 1 -> next level -> 10, 11, 12, 13 (within n)
 * next lowest lexicographically smallest no will be 2 and its subsideries
 * 2 -> next level -> 20, 21 (not applicable) outside n
 * we will start with 1, count nos between level curr and curr+1
 * if the nos is less than k, means ans exist in next no
 * so subtract nos or steps from k and move to next nos
 * if the steps are more than k, ans exist in the same no
 * we can try the next level of same no and decrease k by 1
 * 
 * 
 * Approach
 * Input: n = 13, k = 2
 * Output: 10
 * 1 will already reduce 1 step
 * there are 5 steps 1, 10, 11, 12, 13 between 1 & 2
 * we would return the 2nd step ie 10
 * Math.min(n+1, prefix2), n+1 will also include the new level like - 10 and 11,
 * 12, 13
 * 
 * 
 * Complexity
 * Time complexity: O(logn^2), while loop and count steps both run for logn time
 * Space complexity: O(1)
 */

class Solution {

    public int findKthNumber(int n, int k) {

        int curr = 1;
        k--;

        while (k > 0) {
            int step = countSteps(n, curr, curr + 1);

            if (step <= k) {

                curr++;
                k -= step;
            } else {
                curr *= 10;
                k--;
            }
        }
        return curr;
    }

    private int countSteps(int n, long prefix1, long prefix2) {

        int steps = 0;
        while (prefix1 <= n) {
            steps += Math.min(n + 1, prefix2) - prefix1;
            prefix1 *= 10;
            prefix2 *= 10;
        }
        return steps;
    }
}