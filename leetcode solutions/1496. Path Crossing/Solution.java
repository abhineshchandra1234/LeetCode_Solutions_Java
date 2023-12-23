/**
 * 1496. Path Crossing
 * 
 * Intuition
 * 
 * As evident in the question we can solve this problem using set
 * We will just check if the curr pos already exist in the set if it does return
 * true
 * for north y++, south y--, east x++, west x--
 * for simplicity you can store pos as string in the set instead of the pair
 * like - x + "," + y
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public boolean isPathCrossing(String path) {

        int x = 0, y = 0;
        Set<String> visited = new HashSet();
        visited.add("0,0");

        for (char dir : path.toCharArray()) {
            if (dir == 'E')
                x++;
            else if (dir == 'W')
                x--;
            else if (dir == 'N')
                y++;
            else if (dir == 'S')
                y--;

            String currPos = x + "," + y;

            // return true if already visited else just add the pos
            if (!visited.add(currPos))
                return true;
        }

        return false;
    }
}