/**
 * 864. Shortest Path to Get All Keys
 * 
 * Intuition
 * 
 * credits - aryan
 * We will solve through problem through bfs
 * First we will find the start position cell from where we will start bfs.
 * We will also find the max no of keys in the grid
 * It is possible that we travel through same path to acquire another key.
 * We also need to avoid repetative computation otherwise it will run
 * infinitely.
 * to avoid this we will use keys acquired alongwith x & y coordinates in a
 * state object.
 * 
 * Approach
 * 
 * then apply simple bfs
 * push start state to queue
 * then pop the top element of queue in this case start
 * if it has acquired all the keys return the step
 * (curr.keys == (1 << max) - 1), max = 4
 * 10000 - 1 = 1111
 * Otherwise traverse in four directions
 * If it is a wall skip it
 * If it is a key store it using bit masking
 * keys |= 1 << (c - 'a'), char = c
 * 0100
 * If there is a lock check if the correponding key is acquired otherwise skip
 * it
 * (1 << (c - 'A')) & keys, lock = C
 * 0100 & 0100 = 1
 * Note - || operation is used to add something in bit masking and & operation
 * is used to find something in bit masking.
 * If the state is not visited, then add the current cell with keys acquired as
 * state to visited set.
 * Then add state to queue.
 * At the end of each level increase the step.
 * Finally return the step.
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(m*n*2^k), for each key we have two value 1 -> acquired, 0-> not acquired.
 * 
 * eg - 1,2,0010
 * 
 * Space complexity:
 * 
 * O(m*n*2^k), visited count
 * 
 */
class Solution {
    class State {
        int keys, i, j;

        State(int keys, int i, int j) {
            this.keys = keys;
            this.i = i;
            this.j = j;
        }
    }

    public int shortestPathAllKeys(String[] grid) {

        int x = -1, y = -1, m = grid.length, n = grid[0].length(), max = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    x = i;
                    y = j;
                }
                if (c >= 'a' && c <= 'f')
                    max = Math.max(c - 'a' + 1, max);
            }
        }
        State start = new State(0, x, y);
        Queue<State> q = new LinkedList();
        Set<String> visited = new HashSet();
        visited.add(0 + " " + x + " " + y);
        q.add(start);
        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                State curr = q.poll();
                if (curr.keys == (1 << max) - 1)
                    return step;
                for (int[] dir : dirs) {
                    int i = curr.i + dir[0];
                    int j = curr.j + dir[1];
                    int keys = curr.keys;
                    if (i >= 0 && i < m && j >= 0 && j < n) {
                        char c = grid[i].charAt(j);
                        if (c == '#')
                            continue;
                        if (c >= 'a' && c <= 'f')
                            keys |= 1 << (c - 'a');
                        if (c >= 'A' && c <= 'F' && (((1 << (c - 'A')) & keys) == 0))
                            continue;
                        if (!visited.contains(keys + " " + i + " " + j)) {
                            visited.add(keys + " " + i + " " + j);
                            q.add(new State(keys, i, j));
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}