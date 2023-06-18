/**
 * 319. Bulb Switcher
 * 
 * Intuition
 * 4 -> 1, 2, 4
 * 5 -> 1, 5
 * 6 -> 1, 6
 * You can see all nos have even no of factors except square no and will get
 * turned off eventually but square no will remain on
 * 5 -> on, off
 * 4 -> on, off, on
 * 
 * Complexity
 * Time complexity: O(1)
 * Space complexity: O(1)
 */

class Solution {
    public int bulbSwitch(int n) {

        return (int) Math.sqrt(n);
    }
}