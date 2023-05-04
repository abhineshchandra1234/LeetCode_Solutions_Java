/**
 * 649. Dota2 Senate
 * 
 * Intuition
 * We can solve this through greedy approach
 * Each senate R must ban its closest D senate other wise D senate will ban the
 * senate R or other senate R from his team.
 * We will have two queues one for each team.
 * Each queue will store index of its respective senate
 * Then we will pop senates from each queue and push back senate with least
 * index with value index + n for next round computation.
 * curr senate needs to be cancelled by the senate after it so we add it at
 * index + n.
 * We will have max two rounds. In first round each team will cancel each other
 * out. In next round wining team will anounce itself the winner.
 * like - "RDD", R(1) cancels D(2) then D(3) cancels R(4) in round 1, only D(3)
 * is left in round 2 and annouce itself winner.
 * like - "RDDRR", R(1) cancels D(2), D(3) cancels R(4), R(5) cancels D(7),
 * remaining R(6), R(8) moves to next round and annouce itself winner.
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public String predictPartyVictory(String senate) {

        Queue<Integer> q1 = new LinkedList();
        Queue<Integer> q2 = new LinkedList();
        int n = senate.length();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R')
                q1.add(i);
            else
                q2.add(i);
        }
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int r_idx = q1.poll();
            int d_idx = q2.poll();
            if (r_idx < d_idx)
                q1.add(r_idx + n);
            else
                q2.add(d_idx + n);
        }
        return q1.size() > q2.size() ? "Radiant" : "Dire";
    }
}