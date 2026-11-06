# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we have first sorted logs
- Then we have created time idx on top of queries, and sorted it too
- then we have created map and res array of size q
- then we are traversing time idx, then we are calculating start and end using the curr time
- we will expand window till log arrival time is less than or equal to end
- we will update map with curr server id and its count
- we will shrink window till log arrival time is less than start
- we will update map with decreasing count of curr server id
- we will update res with n - map count, map count represents logs size in the valid window
- Finally return res

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(nlogn)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(n)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = logs.length;

        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        int q = queries.length;
        int[][] timeIdx = new int[q][2];
        for (int i = 0; i < q; i++) {
            timeIdx[i][0] = queries[i];
            timeIdx[i][1] = i;
        }

        Arrays.sort(timeIdx, (a, b) -> a[0] - b[0]);

        Map<Integer, Integer> mp = new HashMap();
        int[] res = new int[q];

        int i = 0, j = 0;
        for (int[] pair : timeIdx) {
            int currTime = pair[0];
            int idx = pair[1];

            int start = currTime - x;
            int end = currTime;

            while (j < m && logs[j][1] <= end) {
                int serverId = logs[j][0];
                mp.put(serverId, mp.getOrDefault(serverId, 0) + 1);
                j++;
            }

            while (i < m && logs[i][1] < start) {
                int serverId = logs[i][0];
                mp.put(serverId, mp.get(serverId) - 1);
                if (mp.get(serverId) == 0) {
                    mp.remove(serverId);
                }
                i++;
            }

            res[idx] = n - mp.size();
        }
        return res;
    }
}
```