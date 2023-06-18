/**
 * 1319. Number of Operations to Make Network Connected
 * 
 * approach-
 * we will use a disjoint set union to solve this
 * We need n-1 connections min to connect all components, if it is not return -1.
 * then we will traverse through connections and do a union of it, if their parents are not the same.
 * For each union done we will decrease the component count.
 * We do this so that no two components are connected by more than one path.
 * Then we will return component-1 as we need n-1 connections to connect all computers.
 * if it is 0 means all computers have connected no action is required.
 * 
 * Time - O(n) (union & find)
 * Space - O(n) (union & find)
 */
class Solution {
    int components;
    public class DSU {
        private int[] par;
        private int[] rank;

        public DSU(int n) {
            par = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++)
                par[i] = i;
        }

        public int find(int u) {
            if(u==par[u])
                return u;
            return par[u] = find(par[u]);
        }

        public void connect(int u, int v) {
            u = find(u);
            v = find(v);

            if(u!=v) {
                if(rank[u]>rank[v])
                    par[v] = u;
                else if(rank[u]<rank[v])
                    par[u] = v;
                else {
                    par[u] = v;
                    rank[v]++;
                }
                components--;
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        components = n;
        if(connections.length<n-1)
            return -1;
        DSU d = new DSU(n+1);
        for(int[] c:connections)
            d.connect(c[0],c[1]);

        return components-1;
    }
}