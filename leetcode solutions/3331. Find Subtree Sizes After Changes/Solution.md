# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we are first building a graph using adjacency list
- then we are assigning eavry node subtree size to 1
- we use last array to track nearest ancestor for each character
- In dfs we check if ancestor has same character as curr node
- if it exists, update curr node parent to that ancestor

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(n)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(n)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    private Map<Integer, List<Integer>> adj = new HashMap();
    private int[] resSize;
    private int[] last;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        for (int i = 1; i < n; i++) {
            int u = parent[i];
            int v = i;
            adj.computeIfAbsent(u, k -> new ArrayList()).add(v);
        }

        resSize = new int[n];
        Arrays.fill(resSize, 1);

        last = new int[26];
        Arrays.fill(last, -1);

        dfs(0, s, parent);

        return resSize;
    }

    private void dfs(int currNode, String s, int[] parent) {
        int c = s.charAt(currNode) - 'a';
        int nearAnc = last[c];
        last[c] = currNode;

        for (int child : adj.getOrDefault(currNode, Collections.emptyList())) {
            dfs(child, s, parent);
        }

        last[c] = nearAnc;

        if (currNode != 0) {
            int newPar = parent[currNode];
            if (nearAnc != -1) {
                newPar = nearAnc;
            }
            parent[currNode] = newPar;
            resSize[newPar] += resSize[currNode];
        }
    }
}
```