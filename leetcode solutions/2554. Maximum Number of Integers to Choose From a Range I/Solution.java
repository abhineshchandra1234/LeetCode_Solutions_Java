/**
 * 2554. Maximum Number of Integers to Choose From a Range I
 * 
 * Intuition
 * we can solve this problem using brute force using set
 * add all banned nos in set
 * traverse through n, if the no is banned skip it
 * if the no is greater than maxSum, return count
 * after all checks increase count and reduce maxSum by the no
 * At last return count
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {

    public int maxCount(int[] banned, int n, int maxSum) {

        HashSet<Integer> s = new HashSet();
        for (int no : banned) {
            s.add(no);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (s.contains(i))
                continue;
            if (i > maxSum)
                return count;

            maxSum -= i;
            count++;
        }

        return count;
    }
}