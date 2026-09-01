// 3568. Minimum Moves to Clean the Classroom

/**
 * Intuition
 * we will solve this problem using BFS and bit masking
 * we will start BFS from start cell
 * for each level we will increase moves
 * if curr mask is equal to all collected we will return moves
 * if energy left is 0 we will move to next cell
 * then we will move to its neighs
 * if the neigh is out of bounds move to next cell
 * if curr cell is X move to next cell
 * next energy will be equal to curr energy - 1
 * next mask will be equal to curr mask
 * if curr cell is r, reset the next energy
 * if curr cell is l, upadte the next mask
 * if curr state is not visited mark it as true and add it to queue
 * Finally return -1, if no moves are possible
 * Approach
 * 
 * Complexity
 * Time complexity: O(m⋅n⋅E⋅2^k), no of states
 * Space complexity: O(m⋅n⋅E⋅2^k)
 */

class Solution {
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

    static class State {
        int row;
        int col;
        int energyLeft;
        int collectedMask;

        State(int row, int col, int energyLeft, int collectedMask) {
            this.row = row;
            this.col = col;
            this.energyLeft = energyLeft;
            this.collectedMask = collectedMask;
        }
    }

    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int maxEnergy = energy;

        int[][] litterBit = new int[20][20];
        int litterCount = 0;
        int startRow = 0;
        int startCol = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                litterBit[r][c] = -1;
                if (classroom[r].charAt(c) == 'S') {
                    startRow = r;
                    startCol = c;
                } else if (classroom[r].charAt(c) == 'L') {
                    litterBit[r][c] = litterCount;
                    litterCount++;
                }
            }
        }

        int allCollected = (1 << litterCount) - 1;
        if (litterCount == 0)
            return 0;

        boolean[][][][] seen = new boolean[m][n][maxEnergy + 1][1 << litterCount];

        Queue<State> q = new LinkedList();
        q.add(new State(startRow, startCol, maxEnergy, 0));
        seen[startRow][startCol][maxEnergy][0] = true;

        int moves = 0;

        while (!q.isEmpty()) {
            int currSize = q.size();
            while (currSize-- > 0) {
                State curr = q.poll();

                if (curr.collectedMask == allCollected)
                    return moves;
                if (curr.energyLeft == 0)
                    continue;

                for (int[] dir : dirs) {
                    int nextRow = curr.row + dir[0];
                    int nextCol = curr.col + dir[1];

                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n)
                        continue;

                    char cell = classroom[nextRow].charAt(nextCol);
                    if (cell == 'X')
                        continue;

                    int nextEnergy = curr.energyLeft - 1;
                    int nextMask = curr.collectedMask;

                    if (cell == 'R')
                        nextEnergy = maxEnergy;
                    else if (cell == 'L')
                        nextMask |= (1 << litterBit[nextRow][nextCol]);

                    if (!seen[nextRow][nextCol][nextEnergy][nextMask]) {
                        seen[nextRow][nextCol][nextEnergy][nextMask] = true;
                        q.add(new State(nextRow, nextCol, nextEnergy, nextMask));
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}