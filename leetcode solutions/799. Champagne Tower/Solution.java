/**
 * 799. Champagne Tower
 * 
 * Intuition
 * 
 * credits prashant404
 * It is like a pascal triangle
 * End glasses will have equal champagne and will receive champagne from 1 glass
 * Middle glasses will receive champagne from two glasses
 * The row and glasses are 0 indexed and question is following the same
 * we just need to return how much champagne does jth glass in ith row contain.
 * excess for any glass is n-1.
 * this excess will be distrubted equally to left and right glass as n-1/2.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity:
 * 
 * O(R^2), each row has varied no of glasses and we need traverse them
 * 
 * Space complexity:
 * 
 * O(R), max prev and curr row is stored
 * 
 */
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {

        if (poured == 0)
            return 0;

        var prevRow = new ArrayList<>(List.of((double) poured));

        while (query_row-- > 0) {
            var champagneInEnds = Math.max(0, (prevRow.get(0) - 1) / 2);
            var currentRow = new ArrayList<>(List.of(champagneInEnds));

            for (var i = 1; i < prevRow.size(); i++)
                currentRow.add(Math.max(0, (prevRow.get(i - 1) - 1) / 2) +
                        Math.max(0, (prevRow.get(i) - 1) / 2));

            currentRow.add(champagneInEnds);
            prevRow = currentRow;
        }

        return Math.min(1, prevRow.get(query_glass));
    }
}