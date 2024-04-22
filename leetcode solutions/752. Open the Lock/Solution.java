/**
 * 752. Open the Lock
 * 
 * Intuition
 * 
 * From the question it is evident we can form new string by increasing or
 * decreasing chars at each index.
 * Now how to solve this problem
 * when we inc or dec a single char a new state(differ by 1) is formed which can
 * be only reached by prev state, similarly we can create other states from new
 * state
 * So these states forms a graph which can be traversed using BFS
 * So we are using BFS to travel from start state ie 0000 to end state ie target
 * 
 * Approach
 * 
 * findNeighs is airthmatic operation so it takes O(1) time
 * checking visted strings in set takes O(1) time
 * Add start state 0000 to queue
 * pop start state and check if it matches target, if it does return level,
 * otherwise find and add its neigh to queue and repeat the process
 * you can add visited strings to a set, to avoid repetition
 * 
 * Complexity
 * 
 * Time complexity: O(n^w) strings can be formed, we have 10 choices
 * (n) for 4 wheels slots(w)
 * 
 * Space complexity: O(n^w)
 * 
 */
class Solution {
    public int openLock(String[] deadends, String target) {

        Set<String> dead = new HashSet();

        for (String d : deadends)
            dead.add(d);

        String start = "0000";
        if (dead.contains(start))
            return -1;

        Queue<String> q = new LinkedList();
        q.add(start);

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String curr = q.poll();

                if (curr.equals(target))
                    return level;

                StringBuilder str = new StringBuilder(curr);
                findNeigh(q, str, dead);
            }
            level++;
        }
        return -1;
    }

    private void findNeigh(Queue<String> q, StringBuilder str, Set<String> dead) {

        for (int i = 0; i < 4; i++) {
            char curr = str.charAt(i);

            char inc = curr == '9' ? '0' : (char) (curr + 1);
            char dec = curr == '0' ? '9' : (char) (curr - 1);

            str.setCharAt(i, inc);
            String incString = str.toString();
            if (!dead.contains(incString)) {
                q.add(incString);
                dead.add(incString);
            }

            str.setCharAt(i, dec);
            String decString = str.toString();
            if (!dead.contains(decString)) {
                q.add(decString);
                dead.add(decString);
            }

            str.setCharAt(i, curr);
        }
    }
}