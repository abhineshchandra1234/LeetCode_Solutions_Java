/*
 * 2187. Minimum Time to Complete Trips
 * 
 * approach -
 * we will solve this using binary search
 * min time will be 1 and max time to complete totalTrips will be min*totalTrips
 * we will find mid time and total trips covered by each bus during this time
 * we will compare total trips covered in mid time with given totalTrips and find the solution.
 * 
 * Time - O(nlogn)
 * Space - O(1)
 */
class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        
        long left = 1;
        long min = time[0];

        for(int t: time)
            min = Math.min(min,t);
        
        long right = totalTrips*min;

        while(left<right) {
            long mid = left + (right-left)/2;
            long total = helper(time,mid);

            if(total<totalTrips)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }

    private long helper(int[] time, long mid) {
        long total = 0;
        for(int t: time)
            total += mid/(long)t;
        return total;
    }
}