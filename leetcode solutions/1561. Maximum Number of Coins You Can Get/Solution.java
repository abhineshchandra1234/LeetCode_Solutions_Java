/**
 * 1561. Maximum Number of Coins You Can Get
 * 
 * Intuition
 * 
 * credits lee215
 * we need to pick any three piles give max to alice, min to bob and keep middle
 * to ourself.
 * To maximize our share we need to sort the array
 * then give piles from lowest 1/3 part to bob, from rest 2/3 part we can assign
 * greatest to alice and keep min for ourself alternatively.
 * SSSMLMLML
 * 
 * Approach 1 (math)
 * 
 * you can use aithmatic operation and beign from 1/3rd index and assign to self
 * after every 2 index.
 * for (int i = piles.length / 3; i < piles.length; i += 2)
 * 
 * Approach 2 (deque)
 * 
 * you can add sorted array to deque
 * then remove element from last for alice
 * then again remove element from last for ourselves
 * then remove element from start for bob
 * 
 * Approach
 * Complexity
 * 
 * Time complexity:
 * 
 * O(nlogn), sorting
 * 
 * Space complexity:
 * 
 * O(logn), sorting
 * 
 */
class Solution {
    public int maxCoins(int[] piles) {

        Arrays.sort(piles);
        int ans = 0;

        for (int i = piles.length / 3; i < piles.length; i += 2)
            ans += piles[i];

        return ans;
    }
}