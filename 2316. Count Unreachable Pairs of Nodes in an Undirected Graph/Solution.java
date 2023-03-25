/**
 * 2316. Count Unreachable Pairs of Nodes in an Undirected Graph
 * 
 * Approach 1-
 * We can solve this using adjacency list and DFS since al can solve both directed & undirected graph
 * First we create a graph using al, then we will traverse through each node
 * then we will use DFS to find all connected components of given node,
 * then we will use this count to find unconnected pair count using the formula (n-x)*x
 * we will add this count to the final result.
 * We will use a boolean array visited to keep track of visited nodes.
 * eg - we have connected sets of 4,2,1
 * unconnected pair count
 * 4*2 + 4*1 + 2 * 1 = 14
 * 
 * Time - O(V+E)
 * Space - O(V+E)
 * 
 * Approach 2-
 * We can solve this using a disjoint set union
 * we will use a hashmap to store the parent as key and count nodes with the same parent as value.
 * Then we will traverse map values and update the result.
 * 
 * Time - O(n)
 * Space - O(n)
 */
class Solution {
    List<List<Integer>> al = new ArrayList();
    public long countPairs(int n, int[][] edges) {
        
        for(int i=0; i<n; i++)
            al.add(new ArrayList());
        //make graph
        for(int[] edge: edges) {
            al.get(edge[0]).add(edge[1]);
            al.get(edge[1]).add(edge[0]);
        }

        long res=0, sum=n;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                //find size of connected set
                int curr = dfs(i, visited, new int[1]);
                sum -= curr;
                res += curr * sum;
            }
        }
        return res;
    }

    private int dfs(int node, boolean[] visited, int[] count) {
        if(visited[node])
            return count[0];
        visited[node] = true;
        count[0]++;
        for(int curr: al.get(node))
            dfs(curr,visited,count);
        return count[0];
    }
}