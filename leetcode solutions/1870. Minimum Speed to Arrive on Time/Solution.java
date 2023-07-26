/**
 * 1870. Minimum Speed to Arrive on Time
 * 
 * Intuition
 * 
 * we can follow naive approach and traverse speed from 1 to 10^7 to find the
 * min speed.
 * or we can binary search the speed to get the min speed
 * if the mid has timeRequired<= hour we will try to find even lesser speed.
 * if the mid has timeRequired> hour we will try to find the greater speed, as
 * the time reduces with speed.
 * we will take ceiling value of time for all the trains except the last train
 * as we can only start the journey at integer hour.
 * like 0.33 -> 1, 1.38 -> 2, 2.89 ->3..
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(nlogk), O(logk) binary search on speed, O(n) traversing dist for each speed
 * to calculate total time.
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {

        int left = 1;
        int right = (int) 1e7;
        int minSpeed = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (timeRequired(dist, mid) <= hour) {
                minSpeed = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minSpeed;
    }

    double timeRequired(int[] dist, int speed) {
        double time = 0.0;
        for (int i = 0; i < dist.length; i++) {
            double t = (double) dist[i] / (double) speed;
            time += (i == dist.length - 1 ? t : Math.ceil(t));
        }
        return time;
    }
}