/**
 * 2360. Longest Cycle in a Graph
 * 
 * approach-
 * we will traverse through each node
 * then we will traverse its connecting nodes through dfs
 * we will keep track of visited nodes locally through hashmap,
 * It will contain node as key and dist from source node as value.
 * When we encounter the same node we will update the result with a diff of 
 * dist 2 from the source node  - dist 1 from the source node.
 * We will use a boolean array visited to keep track of visited nodes.
 * eg - graph is 0->3->2->4 , cycle is 3->2->4.
 * dist 1 = 0->3 = 1
 * dist 2 = 0->3->2->4->3 = 4
 * cycle length = dist 2 - dist 1 = 4 - 1 = 3
 * 
 * Time - O(V+E)
 * Space - O(V+E)
 */
class Solution {
    public int longestCycle(int[] edges) {
        
        int res = -1;
        //globally visited
        boolean[] visited = new boolean[edges.length];

        for(int i=0; i<edges.length; i++) {
            if(visited[i])
                continue;
            //locally visited
            Map<Integer,Integer> map = new HashMap();
            for(int idx=i,dist=0;idx!=-1;idx=edges[idx]) {
                if(map.containsKey(idx)) {
                    res = Math.max(res,dist-map.get(idx));
                    break;
                }
                if(visited[idx])
                    break;
                visited[idx] = true;
                map.put(idx,dist++);
            }
        }
        return res;
    }
}