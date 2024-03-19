/**
 * 621. Task Scheduler
 * 
 * Intuition
 * 
 * credits g27as
 * we will solve this problem through greedy approach
 * we will first try to arrange task or tasks with max freq, and fill rest of
 * the tasks in the empty slots between them
 * part = max freq - 1
 * empty slots = part * (n - (max freq count - 1))
 * available tasks = total tasks - (max freq *max freq count)
 * ideals = empty slots - available tasks
 * intervals = total tasks + ideals
 * 
 * Approach
 * 
 * Input: tasks = ["A","C","A","B","D","B"], n = 1
 * 
 * Output: 6
 * 2A,2B,1C,1D
 * A_,A -> part = 1
 * since we have 2 elements with max freq
 * AB,AB -> empty slots = 1 * (1 - (2-1)) = 0, max freq count - 1,
 * as only B is affecting n and not A
 * available task = 6 - (2*2) = 2
 * ideals = max of (0, 0 - 2) = 0
 * random order A->B->A->B->C->D or A->B->C->D->A->B
 * interval length = 6 + 0 = 6
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] counter = new int[26];
        int max = 0, maxFreq = 0;

        // calculate max freq and its count
        for (char c : tasks) {
            int idx = c - 'A';
            int freq = ++counter[idx];
            if (max == freq)
                maxFreq++;
            else if (max < freq) {
                max = freq;
                maxFreq = 1;
            }
        }

        // calculate emptyslot, available tasks & ideals
        int part = max - 1;
        int emptySlots = part * (n - (maxFreq - 1));
        int availableTasks = tasks.length - (max * maxFreq);
        int ideals = Math.max(0, emptySlots - availableTasks);

        // interval count
        return tasks.length + ideals;
    }
}