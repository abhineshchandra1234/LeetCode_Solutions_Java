/**
 * 1535. Find the Winner of an Array Game
 * 
 * Intuition
 * 
 * credits lee215
 * we do not need queue to push elements, we can solve this by traversing the
 * array
 * curr will point to arr[0] initially, we will compare it with other elements
 * win will maintain the win count. It will increase with each comparison
 * if the next element is greater than curr we will replace curr and reset win
 * to 0
 * If we do not find winner after one pass then winner is max(arr), as no
 * element is greater than it.
 * It is evident from the question we need to do one pass
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int getWinner(int[] arr, int k) {

        int curr = arr[0], win = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > curr) {
                curr = arr[i];
                win = 0;
            }

            if (++win == k)
                break;
        }
        return curr;
    }
}