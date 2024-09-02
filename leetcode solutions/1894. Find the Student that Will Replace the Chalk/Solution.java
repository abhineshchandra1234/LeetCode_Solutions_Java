/**
 * 1894. Find the Student that Will Replace the Chalk
 * 
 * Intuition
 * there are n students
 * we are given integer array chalk, which represent no of chalks ith student
 * will consume
 * we are also given integer k, which represent total chalks to consume
 * 
 * Approach
 * If one iteration requires 10 chalks, and there are 25 chalks in total
 * 
 * After 2 iterations, 25%10 = 5, chalks will be left
 * 
 * if student one requires 3, student two requires 4
 * 
 * So student 2 is the first to require more chalks, we will return its index
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {

    public int chalkReplacer(int[] chalk, int k) {

        long sum = 0;
        int n = chalk.length;
        for (int i = 0; i < n; i++) {
            sum += chalk[i];
            if (sum > k)
                break;
        }

        k = k % (int) sum;

        for (int i = 0; i < n; i++) {
            if (k < chalk[i])
                return i;

            k = k - chalk[i];
        }

        return 0;
    }
}