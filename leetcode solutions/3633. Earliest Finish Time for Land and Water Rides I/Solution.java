// 3633. Earliest Finish Time for Land and Water Rides I

/**
 * Intuition
 * tourist can either take land and then water or water then land
 * our res will be min of above two options
 * we will use a solve function to compute both options
 * lets take first option land and then water
 * we will find finish1 which will min of finish1 and sum of start and
 * destination for land rides
 * we need min time so we do above operation
 * we can finish next ride in max of water ride or finish1 plus duartion of
 * water ride
 * like we would wait before start of next ride or we can immediately start next
 * ride
 * then we would find min finish among these second rides and return it
 * then we will similarly calculate water then land ride
 * lastly return min of land then water ride and water then land ride
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int land_water = solve(
                landStartTime,
                landDuration,
                waterStartTime,
                waterDuration);
        int water_land = solve(
                waterStartTime,
                waterDuration,
                landStartTime,
                landDuration);
        return Math.min(land_water, water_land);
    }

    private int solve(int[] start1, int[] duration1, int[] start2, int[] duration2) {
        int finish1 = Integer.MAX_VALUE;
        for (int i = 0; i < start1.length; i++)
            finish1 = Math.min(finish1, start1[i] + duration1[i]);

        int finish2 = Integer.MAX_VALUE;
        for (int i = 0; i < start2.length; i++)
            finish2 = Math.min(finish2,
                    Math.max(start2[i], finish1) + duration2[i]);
        return finish2;
    }
}