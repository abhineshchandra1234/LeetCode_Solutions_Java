/**
 * 264. Ugly Number II
 * 
 * Intuition
 * we are given an integer n
 * we need to return nth ugly no
 * we can generate next set of ugly nos, by multiplying current ugly no with
 * prime factors
 * we will maintain nos in sorted order, pop the min no and generate next set of
 * ugly nos
 * if we do this n times, we get nth ugly no at last as res
 * 1 is the least ugly no, and our start value
 * Approach
 * 
 * Complexity
 * Time complexity: O(n*logm), n is the index, m is size of set
 * Space complexity: O(m)
 */
class Solution {

    public int nthUglyNumber(int n) {

        TreeSet<Long> s = new TreeSet();
        s.add(1L);

        Long curr = 1L;
        for (int i = 0; i < n; i++) {
            curr = s.pollFirst();
            s.add(curr * 2);
            s.add(curr * 3);
            s.add(curr * 5);
        }

        return curr.intValue();
    }
}