/**
 * 2215. Find the Difference of Two Arrays
 * 
 * Intuition
 * If you are thinking of using set, you are right :) that is the answer
 * same old party, add numbers to set and check if no is present in another set
 * if not, add it to the res.
 * But you can further optimise it by traversing set instead of arrays for
 * making comparison to avoid duplicates.
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        HashSet<Integer> s1 = new HashSet();
        HashSet<Integer> s2 = new HashSet();

        for (int n : nums1)
            s1.add(n);
        for (int n : nums2)
            s2.add(n);

        List<List<Integer>> res = new ArrayList();
        res.add(new ArrayList());
        res.add(new ArrayList());

        for (int n : s1) {
            if (!s2.contains(n))
                res.get(0).add(n);
        }
        for (int n : s2) {
            if (!s1.contains(n))
                res.get(1).add(n);
        }
        return res;
    }
}