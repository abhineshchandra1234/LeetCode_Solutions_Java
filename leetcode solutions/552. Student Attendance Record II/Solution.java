/**
 * 552. Student Attendance Record II
 * 
 * Intuition

    we will solve this problem through recursion and memoization
    It is given we cannot be absent for more than 1 day. so absent values will be (0,1)
    It is also given we cannot be consecutive late for more than 2 days. so consecutive late values will be (0,1,2)
    For each index we have three choices absent, late or present
    For each we will try all 3 choices and call recursion on next index to compute rest of the result for other indices
    we will take a total of these 3 choices solutions and save in the curr state in dp for memoization and to avoid repeated computation
    Then we will return this total as res

Approach

    If we have picked today as absent, absent+1 count will be sent to next index, since we are not late consecutively,l=0, will be sent
    If we pick today as late, absent count will remain same, consecutive late count will be sent as 1
    If we pick today as present, absent unchanged, consecutive late is broken ie l=0
    Pruning cond
    If we have already calculated curr state, return its solution
    If we have reached end of index return 1, for one possible solution
    If absent count is 0, we can proceed with next index as max it can be 1, otherwise return 0, not valid solution
    If late count is 2, return 0 as there is no valid solution, otherwise move to next index

Complexity

    Time complexity: O(n), we are traversing n*2*3 states

    Space complexity: O(n), recursive stack length for each index is n, as we are finding res for next n indices

 */
class Solution {

    int mod = (int) (1e9 + 7);

    public int checkRecord(int n) {

        Integer[][][] temp = new Integer[n][2][3];
        return helper(0, 0, 0, n, temp);
    }

    private int helper(int curr, int a, int l, int n, Integer[][][] temp) {

        if (curr == n)
            return 1;

        if (temp[curr][a][l] != null)
            return temp[curr][a][l];

        int count_a = (a == 0) ? helper(curr + 1, a + 1, 0, n, temp) : 0;
        int count_l = (l == 2) ? 0 : helper(curr + 1, a, l + 1, n, temp);
        int count_p = helper(curr + 1, a, 0, n, temp);
        int total = ((count_a + count_l) % mod + count_p) % mod;

        temp[curr][a][l] = total;
        return total;
    }
}