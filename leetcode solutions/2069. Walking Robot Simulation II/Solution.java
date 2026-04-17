// 2069. Walking Robot Simulation II

/**
 * Intuition
 * we will solve this problem through simulation
 * the robot will only move on the perimeter of the grid and not inside it
 * we will add all the positions it can move into pos alongwith its direction
 * In step we will assing curr idx with (idx+step)% pos size
 * In getPos we will return x,y cordinates from pos using curr idx
 * In getDir, again we will fetch dir from pos using curr idx
 * If dir 0 return east and so on
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Robot {
    int idx = 0;
    boolean moved = false;
    // x,y,dir
    List<int[]> pos = new ArrayList();

    public Robot(int width, int height) {
        // bottom row, e - 0
        for (int x = 0; x < width; x++) {
            pos.add(new int[] { x, 0, 0 });
        }
        // right col, n - 1
        for (int y = 1; y < height; y++) {
            pos.add(new int[] { width - 1, y, 1 });
        }
        // top row, w - 2
        for (int x = width - 2; x >= 0; x--) {
            pos.add(new int[] { x, height - 1, 2 });
        }
        // left col, s - 3
        for (int y = height - 2; y > 0; y--) {
            pos.add(new int[] { 0, y, 3 });
        }
        // dir for 0,0 after movement
        pos.get(0)[2] = 3;
    }

    public void step(int num) {
        moved = true;
        idx = (idx + num) % pos.size();
    }

    public int[] getPos() {
        return new int[] { pos.get(idx)[0], pos.get(idx)[1] };
    }

    public String getDir() {
        if (!moved)
            return "East";

        int d = pos.get(idx)[2];

        if (d == 0)
            return "East";
        else if (d == 1)
            return "North";
        else if (d == 2)
            return "West";
        return "South";
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */