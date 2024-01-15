/**
 * 2225. Find Players With Zero or One Losses
 * 
 * Intuition
 * 
 * As evident in the question, we will store losses of each player in a hashmap
 * whether it is winner or loser
 * Then we will just traverse its key set which contain both winner and loser
 * player
 * Then based on losscount add each player to respective lists at 0 and 1 index.
 * losscount is 0, player will be added in list at index 0
 * losscount is 1, player will be added in list at index 1
 * Since we need players in sorted order we have used treemap which will sort
 * all keys in hashmap ie winner and loser players
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n∗logn), sorting players in hashmap
 * 
 * Space complexity: O(n), storing players in hashmap
 * 
 */
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {

        Map<Integer, Integer> losses = new TreeMap();

        for (int[] m : matches) {
            losses.put(m[0], losses.getOrDefault(m[0], 0));
            losses.put(m[1], losses.getOrDefault(m[1], 0) + 1);
        }

        List<List<Integer>> res = Arrays.asList(new ArrayList(), new ArrayList());

        for (Integer player : losses.keySet()) {
            int lossCount = losses.get(player);
            if (lossCount <= 1)
                res.get(lossCount).add(player);
        }

        return res;
    }
}