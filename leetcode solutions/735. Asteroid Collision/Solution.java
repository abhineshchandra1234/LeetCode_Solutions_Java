/**
 * 735. Asteroid Collision
 * 
 * Intuition
 * 
 * we will solve this problem using stack
 * If the curr asteroid is positive or if stack is empty and asteroid is
 * negative or if stack top is negative and curr asteroid is negative then there
 * will be no collision and we can add curr asteroid to the stack
 * Collision will occur only when curr asteroid is negative and stack is not
 * empty and top is positive.
 * First scenario top is less than curr asteroid
 * keep popping it
 * Second scenario top is equal to curr
 * discard top
 * discard curr
 * Third scenario top is greater than curr
 * discard curr
 * we will flag to discard curr asteroid.
 * 
 * Approach
 * 
 * Input: asteroids = [10,2,-5]
 * Output: [10]
 * 10
 * 10, 2
 * 10
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack();

        for (int asteroid : asteroids) {
            boolean flag = true;
            while (!st.isEmpty() && (st.peek() > 0 && asteroid < 0)) {
                if (Math.abs(st.peek()) < Math.abs(asteroid)) {
                    st.pop();
                    continue;
                } else if (Math.abs(st.peek()) == Math.abs(asteroid))
                    st.pop();

                flag = false;
                break;
            }

            if (flag)
                st.push(asteroid);
        }

        int[] remainingAsteroids = new int[st.size()];
        for (int i = remainingAsteroids.length - 1; i >= 0; i--)
            remainingAsteroids[i] = st.pop();

        return remainingAsteroids;
    }
}