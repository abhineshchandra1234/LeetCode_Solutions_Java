// 2975. Maximum Square Area by Removing Fences From a Field

/***
 * Intuition
 * we will first sort hList and vList, this will help to find different widths
 * and heights
 * Then we will traverse through vList and find different vertical widths
 * we will store these vertical widths in a set
 * Then we will traverse through hList and find different vertical heights
 * we will check if this vertical height is in the set
 * if it is we have got one square as question demands
 * then we will compare this height with maxSide and replace it, if height is
 * more
 * Finally after all loops return square of maxSide as result
 * Approach
 * 
 * Complexity
 * Time complexity: O(n^2), finding widths and heights
 * Space complexity: O(n), storing widths and heights
 */

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {

        List<Integer> hList = new ArrayList();
        List<Integer> vList = new ArrayList();

        for (int x : hFences)
            hList.add(x);
        for (int y : vFences)
            vList.add(y);

        // add boundries
        hList.add(1);
        hList.add(m);
        vList.add(1);
        vList.add(n);

        Collections.sort(hList);
        Collections.sort(vList);

        Set<Integer> width = new HashSet();

        // all vertical widths
        for (int i = 0; i < vList.size(); i++) {
            for (int j = i + 1; j < vList.size(); j++) {
                width.add(vList.get(j) - vList.get(i));
            }
        }

        int maxSide = 0;

        // check vertical heights
        for (int i = 0; i < hList.size(); i++) {
            for (int j = i + 1; j < hList.size(); j++) {
                int height = hList.get(j) - hList.get(i);
                if (width.contains(height))
                    maxSide = Math.max(maxSide, height);
            }
        }

        if (maxSide == 0)
            return -1;

        long area = (long) maxSide * maxSide;
        int mod = (int) 1e9 + 7;
        return (int) (area % mod);
    }
}