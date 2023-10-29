/**
 * 458. Poor Pigs
 * 
 * Intuition
 * 
 * credits mik
 * trials = minutesToTest / minutesToDie
 * each pig can have following no of trials, each trail can have any number of
 * buckets
 * But each pig can detect poison in trials+1 buckets for sure
 * If trial is 4 and buckets is 5, pig doesnt die in first 4 buckets, poison is
 * in last bucket ie 5
 * 
 * trails = 4
 * Suppose pig1 can detect poison in 5 buckets
 * let increase buckets to 6, pig1 will not be able to do it
 * Now lay bucket in 2d array
 * 1 -> 5
 * 2 -> 1
 * pig1 will check 1 row in 1 trial, pig2 will check 1 col in 1 trail
 * after traversing 1 col pig2 will die
 * pig1 will not die in 1st row
 * When pig1 traverse 2 row, it will die
 * It means 2,1 bucket is poisonous, where they both intersect and that is our
 * answer
 * 
 * 1 pig can handle 5 buckets
 * 2 pig can handle 25 buckets
 * which gives formula (trail+1)^pig = bucket
 * let say pig1 handle x dimesion, pig2 handle y dimesion there intersection is
 * our answer in 2d
 * pig3 can handle z dimension there intersection is our ans in 3d or cube or
 * one of top of another
 * 3 pigs can handle 5^3 = 125 buckets
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(1), airthmatic operation
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {

        int trials = minutesToTest / minutesToDie + 1;
        int pigs = 0;

        while (Math.pow(trials, pigs) < buckets)
            pigs++;

        return pigs;
    }
}