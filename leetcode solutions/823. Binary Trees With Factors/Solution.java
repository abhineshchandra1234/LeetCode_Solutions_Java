/**
 * 823. Binary Trees With Factors
 * 
 * Intuition
 * 
 * this problem is easy to solve
 * we can treat every no as root and find the no of diff trees for each root
 * res will be sumation of these trees
 * radhe radhe :)
 * 
 * Approach
 * 
 * we will sort the array first
 * then run two loops, outer loop is for roots
 * inner loop will find possible factors
 * if some no factor1 from inner loop divides root completely then we will find
 * another factor2 by root/factor1
 * If the other factor2 exist we got our one factor pair otherwise 0 pair
 * no of trees of root = existing trees of root + (trees of factor1 * trees of
 * factor2)
 * dp.put(arr[i],(dp.get(arr[i]) + dp.get(arr[j]) * dp.getOrDefault(arr[i] /
 * arr[j], 0L)) % mod);
 * we sort the array to optimize the inner loop, if factor1 is greater than root
 * then its multiple will also greater than the root.
 * 
 * 16 is root
 * 2 is root with 1 diff tree
 * 8 is root with 2 diff trees 8->4->2, 8->2->4
 * 16 (trees) = 0 + 1*2 = 2
 * 
 * Complexity
 * 
 * Time complexity: O(n^2)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        long res = 0, mod = (long) 1e9 + 7;
        Arrays.sort(arr);
        HashMap<Integer, Long> dp = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            dp.put(arr[i], 1L);
            for (int j = 0; j < i; j++)
                if (arr[i] % arr[j] == 0)
                    dp.put(arr[i],
                            (dp.get(arr[i]) + dp.get(arr[j]) * dp.getOrDefault(arr[i] / arr[j], 0L)) % mod);
            res = (res + dp.get(arr[i])) % mod;
        }
        return (int) res;
    }
}