// 1878. Get Biggest Three Rhombus Sums in a Grid

/**
 * Intuition
 * we will traverse all grid points, and treat each point as center will try to
 * find as big rhombus as we can
 * we will add sum of this rhombus to a set, which is a ordered set and will
 * keep top 3 values
 * Later we will build answer through this set and return it
 * Approach
 * 
 * Complexity
 * Time complexity: O(m*n*n^2)
 * Space complexity: O(1)
 */

class Solution {
    public int[] getBiggestThree(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> st = new TreeSet<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                addToSet(st, grid[r][c]); // every cell is valid for rhombus of side = 0

                for (int side = 1; r - side >= 0 && r + side < m && c - side >= 0 && c + side < n; side++) {

                    int sum = 0;

                    for (int k = 0; k < side; k++) {
                        sum += grid[r - side + k][c + k]; // top to right corner
                        sum += grid[r + k][c + side - k]; // right to bottom corner
                        sum += grid[r + side - k][c - k]; // bottom to left corner
                        sum += grid[r - k][c - side + k]; // left to top corner
                    }

                    addToSet(st, sum);
                }
            }
        }

        return buildAnswer(st);
    }

    private void addToSet(TreeSet<Integer> st, int val) {
        st.add(val);
        if (st.size() > 3)
            st.pollFirst();
    }

    private int[] buildAnswer(TreeSet<Integer> st) {
        int[] res = new int[st.size()];
        int idx = 0;

        Iterator<Integer> it = st.descendingIterator();
        while (it.hasNext())
            res[idx++] = it.next();

        return res;
    }
}