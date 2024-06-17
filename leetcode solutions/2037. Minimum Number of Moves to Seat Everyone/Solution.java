/**
 * 2037. Minimum Number of Moves to Seat Everyone
 * 
 * Intuition
 * 
 * there are n seats and students
 * Each seat and student are at a position
 * we need to return min moves to move each student to a seat
 * and no two students should have same seat
 * Initially multiple seat & students can be at same position
 * 
 * Approach
 * 
 * we will place smallest positioned student next to smallest positioned chair
 * then next smallest positioned student near next smallest positioned chair and
 * so on
 * 
 * Complexity
 * 
 * Time complexity: O(nlogn)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {

        Arrays.sort(seats);
        Arrays.sort(students);

        int sum = 0;
        for (int i = 0; i < seats.length; i++)
            sum += Math.abs(seats[i] - students[i]);

        return sum;
    }
}