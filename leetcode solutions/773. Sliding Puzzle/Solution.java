/**
 * 773. Sliding Puzzle
 * 
 * Intuition
 * we can solve this problem through BFS
 * we will have list of nodes for each no where they can move
 * we will convert curr state into string
 * we will add start state to queue
 * we will visit 0 no neighs and update curr state
 * we will add next states to queue, if not visited earlier using set
 * if the curr state equals target, return the current moves or else return -1
 * at the end
 * Approach
 * 
 * Complexity
 * Time complexity: O(m*n)! * O(m*n), there is m*n! configuartions like -
 * 6*5*4*3..
 * For each configuration, BFS is visiting m*n states
 * Space complexity: O(m*n)!, visited set or queue
 */
class Solution {
    public int slidingPuzzle(int[][] board) {

        int[][] dirs = new int[][] {
                { 1, 3 },
                { 0, 2, 4 },
                { 1, 5 },
                { 0, 4 },
                { 1, 3, 5 },
                { 2, 4 }
        };
        // 0, 1, 2
        // 3, 4, 5

        String tar = "123450";
        StringBuilder start = new StringBuilder();

        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                start.append(board[i][j]);
            }
        }

        Set<String> visited = new HashSet();
        Queue<String> q = new LinkedList();
        q.add(start.toString());
        visited.add(start.toString());

        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String curr = q.poll();

                if (curr.equals(tar))
                    return moves;

                int zero = curr.indexOf('0');
                for (int newPos : dirs[zero]) {
                    String nextState = swap(curr, zero, newPos);

                    if (visited.contains(nextState))
                        continue;

                    visited.add(nextState);
                    q.add(nextState);
                }
            }
            moves++;
        }
        return -1;
    }

    private String swap(String str, int i, int j) {
        char temp = str.charAt(i);
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, temp);
        return sb.toString();
    }
}