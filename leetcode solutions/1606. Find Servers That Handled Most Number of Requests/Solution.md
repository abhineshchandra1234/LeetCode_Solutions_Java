# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will first make a list of available servers in the tree set
- then we will store busy servers in a min heap, which will contain servers and their free time
- then we will create count request of size k
- then we will traverse arrival array
- if busy server free time is less than or equal to curr time, we will pop it from busy sever list and add it to available server list
- we will find target sever, if target server is busy we will find its lower bound ie next closest server
- we will increase target server count in count request
- then we will find max no of request among count request
- the we will add index of servers with max no of request to res
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
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> avlServers = new TreeSet();
        for (int i = 0; i < k; i++) {
            avlServers.add(i);
        }

        PriorityQueue<int[]> busySvr = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        int[] cntRqst = new int[k];

        for (int i = 0; i < arrival.length; i++) {
            int time = arrival[i];

            while (!busySvr.isEmpty() && busySvr.peek()[0] <= time) {
                int server = busySvr.poll()[1];
                avlServers.add(server);
            }

            if (avlServers.isEmpty()) {
                continue;
            }

            int target = i % k;

            Integer targetSvr = avlServers.ceiling(target);

            if (targetSvr == null) {
                targetSvr = avlServers.first();
            }

            avlServers.remove(targetSvr);
            busySvr.add(new int[] { time + load[i], targetSvr });

            cntRqst[targetSvr]++;
        }

        int maxNoOfRqst = 0;
        for (int c : cntRqst) {
            maxNoOfRqst = Math.max(maxNoOfRqst, c);
        }
        List<Integer> res = new ArrayList();
        for (int i = 0; i < k; i++) {
            if (cntRqst[i] == maxNoOfRqst) {
                res.add(i);
            }
        }

        return res;
    }
}
```