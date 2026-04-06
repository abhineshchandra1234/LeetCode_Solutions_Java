/**
 * 874. Walking Robot Simulation
 * 
 * Intuition
 * Given integer array of commands and 2d integer array of obstacles
 * we need to return max euclidean distance
 * we need to move the robot through obstacles and find its final point
 * we will solve this problem through simulation
 * 
 * 
 * Approach
 * we will use a simple hashing function to represent all coordinates including
 * negative ones
 * 
 * we will represent current coordinate using an integer array
 * 
 * we will have directions array as well as variables to represent directions
 * 
 * Algorithm
 * 
 * First add all hashed obstacles to the set
 * 
 * traverse through the commands
 * 
 * find the current direction
 * 
 * Move in the current direction step by step
 * 
 * If the next step is obstacle ie in set, break the loop for steps as evident
 * in the question
 * 
 * Update max Euclidean distance using curr coordinates, and at last return it
 * after parsing all commands
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {

    private static final int hashed = 60001;

    public int robotSim(int[] commands, int[][] obstacles) {

        // int n = commands.length;

        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // n, e, s, w
        int currDirec = 0; // n -> 0, e -> 1, s -> 2, w -> 3

        int[] currCoor = { 0, 0 };

        HashSet<Integer> s = new HashSet<>();

        for (int[] obstacle : obstacles) {
            s.add(helper(obstacle[0], obstacle[1]));
        }

        int res = Integer.MIN_VALUE;
        for (int command : commands) {

            if (command == -1) {
                currDirec = (currDirec + 1) % 4;
                continue;
            } else if (command == -2) {
                currDirec = (currDirec + 3) % 4;
                continue;
            }

            for (int i = 0; i < command; i++) {
                int nextX = currCoor[0] + directions[currDirec][0];
                int nextY = currCoor[1] + directions[currDirec][1];

                if (s.contains(helper(nextX, nextY)))
                    break;

                currCoor[0] = nextX;
                currCoor[1] = nextY;
            }

            res = Math.max(res, currCoor[0] * currCoor[0] + currCoor[1] * currCoor[1]);
        }

        return res;
    }

    private int helper(int x, int y) {
        return x + hashed * y;
    }
}

// Alternate code

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> obsSet = new HashSet();
        for (int[] obs : obstacles) {
            String key = obs[0] + "_" + obs[1];
            obsSet.add(key);
        }

        int x = 0;
        int y = 0;
        int maxD = 0;

        int[] dir = { 0, 1 };

        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -2)
                dir = new int[] { -dir[1], dir[0] };
            else if (commands[i] == -1)
                dir = new int[] { dir[1], -dir[0] };
            else {
                for (int step = 0; step < commands[i]; step++) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    String nextKey = newX + "_" + newY;

                    if (obsSet.contains(nextKey))
                        break;

                    x = newX;
                    y = newY;
                }
            }

            maxD = Math.max(maxD, x * x + y * y);
        }
        return maxD;
    }
}