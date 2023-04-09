/**
 * 1857. Largest Color Value in a Directed Graph
 * 
 * Intuition
 * We will solve this problem using BFS and Topological sort as it given in the
 * question we need to find cycle also.
 * There can be n*n-1 paths for each node which is a huge no. like - 0->2,
 * 0->2->3, 0->2->3->4.
 * We will consider only longest paths. As the longest path will have more no of
 * nodes hence more color count.
 * For this we will pick the node who has no parent ie idegree as zero as the
 * start of the path
 * We will pass the color count from parent to child node. For this each node
 * will contain an array of size 26.
 * Again a child can have multiple parent, we will take max count for each
 * color. We will compute each parent one by one and reduce indegree by 1.
 * We will keep a visited count using parent node whose indegree is 0, the nodes
 * in a cycle will not be included in this count as there indegree will always
 * be min 1.
 * eg - suppose we have nodes 1->2->3->4 in which 2->3->4 is in cycle 3,4 will
 * have indegree 1 and 2 has indegree 2, it will not become 0 bcs computation
 * will not finish for parent node due to cyclic dependency.
 * Even if we finish computation for 1, 4 will still be dependent on 2 making
 * its indegree as min 1.
 * 
 * Approach
 * we will first build the graph and indegree array
 * Then we will build the zeroIndegree queue and add nodes whose indgree is 0.
 * We will update color count for these nodes.
 * These nodes will update color count for all the child nodes in the longest
 * path.
 * Then we will pass the count to child nodes and update maxCount.
 * we will pop zeroIndegree queue nodes and update child nodes color count. If
 * indegree of child node becomes 0 means all parent has been computed then we
 * will add it to queue.
 * We will update maxCount with Max of maxCount and max color count of a parent
 * node. The leaf node will have no child nodes and will finally update
 * maxCount.
 * 
 * Complexity
 * Time complexity: O(V+E)
 * Space complexity: O(V+E)
 */
class Solution {
    public int largestPathValue(String colors, int[][] edges) {

        // build graph and indegree array
        int n = colors.length();
        int[] indegree = new int[n];
        List<List<Integer>> graph = new ArrayList();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        // build zeroIndegree queue and update its color count
        Queue<Integer> zeroIndegree = new LinkedList();
        int[][] counts = new int[n][26];
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                zeroIndegree.add(i);
                counts[i][colors.charAt(i) - 'a']++;
            }
        }

        // pass count to child nodes and update maxCount
        int maxCount = 0;
        int visited = 0;
        while (!zeroIndegree.isEmpty()) {
            int u = zeroIndegree.poll();
            visited++;
            for (int v : graph.get(u)) {
                for (int i = 0; i < 26; i++)
                    counts[v][i] = Math.max(counts[v][i],
                            counts[u][i] + (colors.charAt(v) - 'a' == i ? 1 : 0));
                indegree[v]--;
                if (indegree[v] == 0)
                    zeroIndegree.add(v);
            }
            maxCount = Math.max(maxCount, findMax(counts[u]));
        }
        return visited == n ? maxCount : -1;
    }

    private int findMax(int[] num) {
        int max = num[0];
        for (int n : num)
            max = Math.max(max, n);
        return max;
    }
}