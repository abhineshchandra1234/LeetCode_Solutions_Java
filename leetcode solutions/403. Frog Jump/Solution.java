/**
 * 403. Frog Jump
 * 
 * Intuition
 * 
 * we will solve this through BFS
 * we know first jump will be of 1 unit.
 * Based on this we will calculate possibles jump units for all the stones.
 * All the reachable stones jump units will be updated, if the reachable stone
 * is the last stone return true.
 * At last return false
 * 
 * Input: stones = [0,1,3,5,6,8,12,17]
 * Output: true
 * Jump units
 * 0 -> 1
 * 1 -> 1-1, 1, 1+1 -> 1,2
 * reachable -> 2, 3
 * 2 -> 1-1, 1, 1+1 -> 1, 2
 * reachable -> 3, 4
 * 3 -> 2-1, 2, 2+1 -> 1, 2, 3
 * like this solve through BFS
 * 
 * Approach
 * 
 * we will not return false in between if any stone do not have jump units, as
 * intially all stones will not have jump units.
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n^2), in worst scenarios we can jump from each stone to all other stones
 * 
 * Space complexity:
 * 
 * O(n^2)
 * 
 */
class Solution {
    public boolean canCross(int[] stones) {

        HashMap<Integer, HashSet<Integer>> map = new HashMap();
        for (int i = 0; i < stones.length; i++)
            map.put(stones[i], new HashSet());

        map.get(stones[0]).add(1);

        for (int i = 0; i < stones.length; i++) {
            int currStone = stones[i];
            HashSet<Integer> jumps = map.get(currStone);
            for (int jump : jumps) {
                int pos = currStone + jump;
                if (pos == stones[stones.length - 1])
                    return true;
                if (map.containsKey(pos)) {
                    if (jump - 1 > 0)
                        map.get(pos).add(jump - 1);
                    map.get(pos).add(jump);
                    map.get(pos).add(jump + 1);
                }
            }
        }

        return false;
    }
}