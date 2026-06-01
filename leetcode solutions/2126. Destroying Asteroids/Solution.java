// 2126. Destroying Asteroids

/**
 * Intuition
 * we will solve this problem through greedy approach
 * At each step we will find the lowest asteroid, if the lowest asteroid can
 * destroy the planet, rest will also do so
 * we will sort asteroid in ascending order
 * then we will traverse asteroid, if its mass is more it will destroy planet
 * return false
 * otherwise add asteroid mass to the planet
 * Approach
 * 
 * Complexity
 * Time complexity: O(nlogn), sorting
 * Space complexity: O(logn), sorting
 */

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currMass = mass;
        for (int asteroid : asteroids) {
            if (currMass < asteroid)
                return false;
            currMass += asteroid;
        }
        return true;
    }
}