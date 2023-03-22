/**
 * 2492. Minimum Score of a Path Between Two Cities
 * 
 * approach-
 * This problem looks hard but can we easily solve using a disjoint set union
 * we will traverse through each road and connect it using DSU.
 * Then we will find parent for city 1.
 * Then we will traverse through roads and see if any city is connected to the parent
 * If it is we will update res with its weight
 * DSU can contain cities that are not connected to the parent and has a group of their own.
 * 
 * Time - O(n) (Union & find)
 * Space - O(n) (Union & find)
 */
class Solution {
    public class DSU {
        private int[] par;
        private int[] rank;

        public DSU(int n) {
            par = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++)
                par[i] = i;
        }
        
        //Path Compression
        public int find(int u) {
            if(u==par[u])
                return u;
            return par[u] = find(par[u]);
        }
        
        //Union By Rank
        public void connect(int u,int v) {
            u = find(u);
            v = find(v);
            if(rank[u]>rank[v])
                par[v] = u;
            else if(rank[u]<rank[v])
                par[u] = v;
            else {
                par[u] = v;
                rank[v]++;
            }
        }
    }
    public int minScore(int n, int[][] roads) {
        DSU d = new DSU(n+1);
        for(int[] r:roads)
            d.connect(r[0],r[1]);
        int leader = d.find(1);

        //filter edges and update min edge weight
        int res = Integer.MAX_VALUE;
        for(int[] r: roads) {
            int u = d.find(r[0]), v = d.find(r[1]);
            if(u==leader || v==leader)
                res = Math.min(res,r[2]);
        }
        return res;
    }
}