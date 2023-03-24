/**
 * 1466. Reorder Routes to Make All Paths Lead to the City Zero
 * 
 * approach-
 * we will solve this problem using dfs and adjacency list since it is a directed graph
 * It is given that all cities form a tree with 0 as the root.
 * we will consider all a cities as parents and store a path from a to b as +ve and b to a -ve in the list.
 * then we will start traversing from 0 and will traverse all its children. If the path is +ve we need to change it
 * otherwise we will ignore it.
 * We will also use a boolean array to keep track of visited cities.
 * eg - 0 -> 1,2,3,4,-5
 *      1 -> 6,7,8,-0
 *      5 -> 0
 * Here we are going from 0 to 1,2,3,4 city. So we need to change 4 paths.
 * again we are going from 1 to 6,7,8 cities. So above we have changed 1 to point to 0, 
 * Still 6,7,8 is in the opposite dir of 1 and we need to change 3 paths to point to the correct dir.
 * Path can be from parent to child (positive) and child to parent (negative) like 0 & 5.
 * Note: we are storing the +ve path so that we can change it, and we are storing the -ve path
 * so that we can know that there is a path between those cities, and we can use it to traverse other cities. like 0 & 5.
 * It is easier to understand with the help of a tree.
 * Time - O(n)
 * Space - O(n)
 */
class Solution {
    public int minReorder(int n, int[][] connections) {
        
        List<List<Integer>> al = new ArrayList();
        for(int i=0; i<n; i++)
            al.add(new ArrayList());
        for(int[] c: connections) {
            al.get(c[0]).add(c[1]);
            al.get(c[1]).add(-c[0]);
        }
        return dfs(al,new boolean[n],0);
    }

    private int dfs(List<List<Integer>> al, boolean[] visited, int from) {
        int change = 0;
        visited[from] = true;
        for(int to:al.get(from)) {
            if(!visited[Math.abs(to)])
                change += dfs(al,visited,Math.abs(to)) + (to>0?1:0);
        }
        return change;
    }
}