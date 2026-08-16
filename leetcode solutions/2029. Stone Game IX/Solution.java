// 2029. Stone Game IX

//explanation will be added soon

class Solution {
    public boolean stoneGameIX(int[] stones) {
        int c0 = 0, c1 = 0, c2 = 0;
        for (int val : stones) {
            int type = val % 3;
            if (type == 0)
                c0++;
            else if (type == 1)
                c1++;
            else
                c2++;
        }

        if (c0 % 2 == 0)
            return c1 >= 1 && c2 >= 1;

        return c1 - c2 > 2 || c2 - c1 > 2;
    }
}