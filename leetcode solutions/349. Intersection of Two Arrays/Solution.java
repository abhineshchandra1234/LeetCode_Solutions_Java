/**
 * 349. Intersection of Two Arrays
 * 
 * Intuition
 * 
 * we will solve this problem using 2 sets as evident in the question
 * First we will add all nos of nums1 in set
 * Then we will traverse num2 and check if its no is in set, if it is add it in
 * intersect set
 * Then return all the nos of intersect set
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> s = new HashSet();
        Set<Integer> intersect = new HashSet();

        for (int no : nums1)
            s.add(no);

        for (int no : nums2) {
            if (s.contains(no))
                intersect.add(no);
        }

        int[] res = new int[intersect.size()];

        int i = 0;
        for (int no : intersect)
            res[i++] = no;

        return res;
    }
}