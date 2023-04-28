/**
 * 839. Similar String Groups
 * 
 * Intuition
 * A word will be added in the group if it is atleast similar to one word in the
 * group.
 * To check if two strings are similar the disimilar char count will be either 2
 * or 0.
 * We will solve this using dfs. We will traverse through nodes and from each
 * node traverse n-1 nodes.
 * For each new node we will increase group count and will mark all its similar
 * neighbour node as visited.
 * Note if the node doesnt match it is not mark as visited and it helps to
 * increase group count.
 * 
 * Approach
 * strs = ["tars","rats","arts","star"]
 * first tars is marked as visited and group count is increased. since tars and
 * rats are similar rats is marked as visited.
 * Then rats and arts are compared. Since arts is similar it is mark as visited.
 * Then arts and star is compared. star is not marked as visited as it is not
 * similar and it helps in increasing group count when parsed.
 * 
 * Complexity
 * Time complexity:
 * O(n^2*m)
 * 
 * We are visting each node from there all n-1 nodes. O(n^2)
 * 
 * To find if two strings are similar O(m)
 * 
 * Space complexity:
 * 
 * O(n^2)
 * recursion call stack
 */
class Solution {
    public int numSimilarGroups(String[] strs) {

        int groups = 0, n = strs.length;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (vis[i])
                continue;
            groups++;
            dfs(i, strs, vis);
        }
        return groups;
    }

    void dfs(int i, String[] strs, boolean[] vis) {
        vis[i] = true;
        for (int j = 0; j < strs.length; j++) {
            if (vis[j])
                continue;
            if (isSimilar(strs[i], strs[j]))
                dfs(j, strs, vis);
        }
    }

    boolean isSimilar(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                count++;
        }
        return (count == 2 || count == 0);
    }
}