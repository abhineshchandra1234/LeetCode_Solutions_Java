/**
 * 1491. Average Salary Excluding the Minimum and Maximum Salary
 * 
 * Intuition
 * We will use min and max variable to solve this as its min length is 3.
 * we will subtract min and max from the total sum and take avg with n-2.
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public double average(int[] salary) {

        double sum = 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, n = salary.length;
        for (int s : salary) {
            sum += s;
            min = Math.min(min, s);
            max = Math.max(max, s);
        }
        return (sum - min - max) / (n - 2);
    }
}