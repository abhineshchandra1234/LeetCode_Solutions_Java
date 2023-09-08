/**
 * 118. Pascal's Triangle
 * 
 * Intuition
 * 
 * credits mzchen
 * we will see pascal triangle behaviour and implement it
 * First and last element of each row is 1.
 * 
 * 1 -> 0 -> 1
 * 3 -> 0 -> 1, 3 -> 1
 * 5 -> 0 -> 1, 5 -> 1
 * 
 * Each row size is equal to row no
 * for each element between 1 and i-1 of each row
 * 
 * r[i][j] = r[i-1][j-1] + r[i-1][j]
 * 
 * Thats it your pascal triangle is solved
 * radhe radhe
 * 
 * Approach
 * 
 * run two loops one for pascal size and other loop to update its elements.
 * 
 * Complexity
 * 
 * Time complexity: O(n^2)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> r = new ArrayList();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    row.add(1);
                else {
                    int prev1 = r.get(i - 1).get(j - 1);
                    int prev2 = r.get(i - 1).get(j);
                    row.add(prev1 + prev2);
                }
            }
            r.add(row);
        }
        return r;
    }
}