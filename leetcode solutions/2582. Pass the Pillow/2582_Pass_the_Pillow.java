//2582. Pass the Pillow
/*
 * approach -
 * We will solve this problem using boolean flag. If the flag is false it will increase i else will decrease it
 * reverse the flag when i value is n or 1.
 * 
 * Time - O(T)
 * Space - O(1)
 */

//Approach 1
class Solution {
    public int passThePillow(int n, int time) {
        
        boolean reverse = false;
        int i=1;
        for(int j=0; j<time; j++) {
            
            if(!reverse)
                i++;
            if(reverse)
                i--;
            if(i==n || i==1)
                reverse = !reverse;
        }
        return i;
    }
}

//Approach 2
/*Intuition

    given two integers n and time, return the index of the person holding the pillow after time seconds
    there n peoples standing in the line, first person in the line is holding the pillow
    after each second, pillow is passed to the next person, once the pillow reaches the end person direction is reversed
    As evident in the question, move in forward direction till there is some time left
    reverse the direction when index is out of bounds and continue moving till the time is left

Approach
Complexity

    Time complexity: O(T)

    Space complexity: O(1)

 * 
 */
class Solution {

    fun passThePillow(n: Int, time: Int): Int {

        var i = 1
        var currTime = 0
        var dir = 1

        while (currTime < time) {
            if (0 < i + dir && i + dir <= n) {
                i += dir
                currTime++
            } else {
                dir *= -1
            }
        }
        return i
    }
}
