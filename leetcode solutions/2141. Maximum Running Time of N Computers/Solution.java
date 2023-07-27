/**
 * 2141. Maximum Running Time of N Computers
 * 
 * Intuition
 * 
 * credits lee215
 * we will solve this problem using sorting
 * The naive approach is to run all the batteries evenly and use all the power.
 * It will take sum(batteries)/n mins
 * the problem is there can be a larger battery, who when used all the time
 * still has some charge left
 * So if some battery with max(A) is greater than the average we will use that
 * battery to charge the computer
 * We will repeat the above process for all the batteries with max(A) greater
 * than average.
 * And use rest of the batteries to charge n-1 computers evenly.
 * the advantage of this approach is that big batteries will be used first and
 * maybe small batteries are never used.
 * 
 * Complexity
 * 
 * Time complexity: O(nlogn)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public long maxRunTime(int n, int[] batteries) {

        Arrays.sort(batteries);
        long sum = 0;
        for (int battery : batteries)
            sum += battery;
        int k = 0, na = batteries.length;
        while (batteries[na - 1 - k] > sum / (n - k))
            sum -= batteries[na - 1 - k++];
        return sum / (n - k);
    }
}