/**
 * 1424. Diagonal Traverse II
 * 
 * Intuition
 * 1st Approach
 * 
 * As it is evident from question we need to traverse from bottom(row=n..0,
 * col=0..n) for each diagonal and add it to res
 * But how do we group elements to different or same diagonal group
 * Same diagonal group elements will have equal sum of indices ie i+j, but
 * different than other diagonal group indices sum by min 1
 * 
 * like for 2 diagonal->
 * (2,0)==2+0==2
 * (1,1)==1+1==2
 * (0,2)==0+2==2
 * 
 * 2nd Approach
 * 
 * for every element we can add its bottom and right cell to res
 * bottom will only be available for col 0 elements
 * right will be available for all cols
 * 
 * Approach
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n), traversing each element once
 * 
 * Space complexity:
 * 
 * O(n), storing each element once
 * 
 */
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {

        int n = 0, i = 0, maxKey = 0;

        // same diagonal elements have equal sum
        Map<Integer, List<Integer>> map = new HashMap();

        // bottom rows contain starting values of the diagonals
        for (int r = nums.size() - 1; r >= 0; r--) {
            for (int c = 0; c < nums.get(r).size(); c++) {
                map.putIfAbsent(r + c, new ArrayList());
                map.get(r + c).add(nums.get(r).get(c));
                // no of diagonals or groups of nos
                maxKey = Math.max(maxKey, r + c);
                // count of elements for res array size
                n++;
            }
        }

        int[] ans = new int[n];
        for (int key = 0; key <= maxKey; key++) {
            List<Integer> value = map.get(key);
            for (int v : value)
                ans[i++] = v;
        }
        return ans;
    }
}