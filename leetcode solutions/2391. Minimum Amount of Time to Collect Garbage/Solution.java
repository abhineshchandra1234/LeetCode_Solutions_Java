/**
 * 2391. Minimum Amount of Time to Collect Garbage
 * 
 * Intuition
 * 
 * credits lee215
 * we need to pick all garbage, so n unit will be added to res for all n units
 * of garbage
 * we need to find last index till we need to travel for each truck, truck need
 * not travel all houses
 * calculate prefix sum for travel
 * add prefix travel distance of each type to res
 * we need three trucks for PGM garbage, and each truck will have independent
 * efforts
 * 
 * Approach
 * 
 * for garbage at house 0 no travel is required
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {

        // last index mapping
        int last[] = new int[128], res = 0;

        // add garbage sum to res
        for (int i = 0; i < garbage.length; i++) {
            res += garbage[i].length();
            // calculate last index of each garbage
            for (int j = 0; j < garbage[i].length(); j++)
                last[garbage[i].charAt(j)] = i;
        }

        // prefix sum of travel
        for (int j = 1; j < travel.length; j++)
            travel[j] += travel[j - 1];

        // add prefix travel of each type to res
        for (int c : "PGM".toCharArray())
            if (last[c] > 0)
                res += travel[last[c] - 1];
        return res;
    }
}