/**
 * 119. Pascal's Triangle II
 * 
 * Intuition
 * 
 * Ye p se pascal hai :)
 * It is similar to the problem "118. Pascal's Triangle"
 * As it is visible from the question we can solve it if we have prev array
 * which stores prev row and based on it we can calculate the curr row
 * This is the basic principal of the pascal triangle that you can solve it
 * using prev row
 * Since the rows are of varying length so list is suitable
 * In I variant too we were using prev row to calculate curr row and storing all
 * rows, here we are just updating prev row with curr row after calculation and
 * storing prev and curr rows.
 * Used same code as I variant.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n^2)
 * 
 * Space complexity: O(2n)
 * 
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> prev = new ArrayList();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> curr = new ArrayList();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    curr.add(1);
                else
                    curr.add(prev.get(j) + prev.get(j - 1));
            }
            prev = curr;
        }
        return prev;
    }
}