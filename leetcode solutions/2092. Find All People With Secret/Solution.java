/**
 * 2092. Find All People With Secret
 * 
 * Intuition
 * 
 * credits oa5cuxe0To3
 * we will solve this problem using union find reset
 * we will first link 0 and firstPerson using union find as they know the secret
 * we will group people based of meetings start time and store in pool
 * Then we will divide this group into two groups one who knows secret ie
 * connected to 0 and the other who dont know the secret
 * Then we are traversing pool and people who dont know secret ie are not
 * connected 0, has thier parents reset
 * At last we will have all people link to 0 or know secret using union find
 * Then we will traverse people and those are connected to 0 or know secret is
 * added to the res.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(m∗log(m)), we are sorting meetings
 * based on start time
 * 
 * Space complexity: O(m), Storing meetings details in disjoint set
 * 
 */
class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        Arrays.sort(meetings, ((a, b) -> a[2] - b[2]));
        DSU d = new DSU(n);
        d.union(0, firstPerson);

        int i = 0;
        while (i < meetings.length) {
            int currTime = meetings[i][2];
            Set<Integer> pool = new HashSet();

            while (i < meetings.length && currTime == meetings[i][2]) {
                int[] currentMeeting = meetings[i];
                d.union(currentMeeting[0], currentMeeting[1]);
                pool.add(currentMeeting[0]);
                pool.add(currentMeeting[1]);
                i++;
            }

            for (int j : pool)
                if (!d.connected(0, j))
                    d.reset(j);
        }
        List<Integer> ans = new ArrayList();
        for (int j = 0; j < n; j++)
            if (d.connected(j, 0))
                ans.add(j);
        return ans;
    }

    class DSU {
        int rank[];
        int parent[];
        int distinctComponents;

        DSU(int n) {
            rank = new int[n + 1];
            parent = new int[n + 1];
            distinctComponents = n;
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        int findParent(int node) {
            if (parent[node] == node)
                return node;
            return parent[node] = findParent(parent[node]);
        }

        boolean union(int x, int y) {
            int px = findParent(x);
            int py = findParent(y);
            if (px == py)
                return false;
            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[px] = py;
                rank[py]++;
            }
            distinctComponents--;
            return true;
        }

        boolean united() {
            return distinctComponents == 1;
        }

        boolean connected(int p, int q) {
            return findParent(p) == findParent(q);
        }

        void reset(int p) {
            parent[p] = p;
            rank[p] = 0;
        }
    }
}