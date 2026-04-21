// 1722. Minimize Hamming Distance After Swap Operations

/**
 * Intuition
 * we will create a DSU for all indices
 * indices in the same component can swap with each other
 * each indices will have frequency too, after each swap its frequency will
 * reduce by 1
 * Then we will simply traverse source array
 * we will find parent of curr index
 * then we will find target in parent component
 * if the target is there swap is possible, reduce frequency of target
 * if the target is not there swap is not possible, increase the hamming
 * distance or diff by 1
 * Finally return hamming distance or diff
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    int[] parent;
    int[] rank;

    // Find with path compression
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union by rank
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY)
            return;

        if (rank[rootX] < rank[rootY]) {
            int temp = rootX;
            rootX = rootY;
            rootY = temp;
        }

        parent[rootY] = rootX;

        if (rank[rootX] == rank[rootY]) {
            rank[rootX]++;
        }
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Union of allowedSwaps
        for (int[] edge : allowedSwaps) {
            union(edge[0], edge[1]);
        }

        // group -> (value -> freq)
        Map<Integer, Map<Integer, Integer>> groupFreq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = find(i);

            groupFreq.putIfAbsent(root, new HashMap<>());
            Map<Integer, Integer> freqMap = groupFreq.get(root);

            freqMap.put(source[i], freqMap.getOrDefault(source[i], 0) + 1);
        }

        int hammingDistance = 0;

        for (int i = 0; i < n; i++) {
            int root = find(i);
            Map<Integer, Integer> freqMap = groupFreq.get(root);

            if (freqMap.getOrDefault(target[i], 0) > 0) {
                freqMap.put(target[i], freqMap.get(target[i]) - 1);
            } else {
                hammingDistance++;
            }
        }

        return hammingDistance;
    }
}