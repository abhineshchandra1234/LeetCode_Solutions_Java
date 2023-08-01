/**
 * 77. Combinations
 * 
 * Intuition
 * 
 * credits fabrizio3
 * From the question it is clear that we need to apply the combinations
 * We will use recursion to solve this, top-down approach
 * we will either pick or leave the curr no, and add it to the local list
 * This operation we will do for 1,n times
 * the terminating cond will be when k becomes 0, we will add the temp list to
 * the res.
 * This way res will contain all diff combinations in form of many lists.
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(C(n,k)*k), we are applying combinations for k times
 * 
 * Space complexity:
 * 
 * O(C(n, k)), that is the total no of combinations and res size.
 * 
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> combs = new ArrayList();
        combine(combs, new ArrayList(), 1, n, k);
        return combs;
    }

    public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {

        if (k == 0) {
            combs.add(new ArrayList(comb));
            return;
        }

        for (int i = start; i <= n; i++) {
            comb.add(i);
            combine(combs, comb, i + 1, n, k - 1);
            comb.remove(comb.size() - 1);
        }
    }
}