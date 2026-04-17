// 3296. Minimum Number of Seconds to Make Mountain Height Zero

/**
 * Intuition
 * we will solve this problem through binary search
 * we will check if mid time is enough, if it is we will reduce right to mid-1,
 * to check for even lower time
 * lowest time will be 1 and heighest time will be maxTime * mountainHeight *
 * (mountainHeight + 1) / 2, (sum of n terms), as per the question
 * In the check function we will traverse through worker times and see how much
 * height they are able to reduce
 * If the total height is greater or equal to max height return true else false
 * Approach
 * 
 * Complexity
 * Time complexity: O(n*logn)
 * Space complexity: O(1)
 */

class Solution {
    private boolean check(long mid, int[] workerTimes, int mH) {
        long h = 0;

        for (int t : workerTimes) {
            h += (long) (Math.sqrt(2.0 * mid / t + 0.25) - 0.5);

            if (h >= mH) {
                return true;
            }
        }

        return h >= mH;
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int maxTime = 0;
        for (int t : workerTimes)
            maxTime = Math.max(maxTime, t);

        long l = 1;
        long r = (long) maxTime * mountainHeight * (mountainHeight + 1) / 2;

        long result = 0;

        while (l <= r) {
            long mid = l + (r - l) / 2;

            if (check(mid, workerTimes, mountainHeight)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;
    }
}