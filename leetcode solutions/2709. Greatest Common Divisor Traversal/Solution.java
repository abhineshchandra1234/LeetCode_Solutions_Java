/**
 * 2709. Greatest Common Divisor Traversal
 * 
 * Intuition
 * 
 * prime no - no whose factor is 1 or itself
 * prime factorization - breaking down any nos to multiple of its prime factor.
 * like - 12 -> 2*2*3
 * For each no we are finding all its prime factors
 * Once prime factors exceeds sqrt(n), it starts repeating itself. like - 2*8,
 * 8*2. So we check prime factors till sqrt(n)
 * Then we are doing union of prime factor and curr no index
 * Suppose for a factorial which divides multiple no, take union of new no index
 * with just factorial index.
 * like - 2 -> 4, 8, 12
 * We dont need to do union of 12 with 4, 8 just do union with 2
 * Then remove all instance of prime factor from curr no
 * like - 2*2*3 = 12
 * Remove all instances of curr prime factor or 2
 * If rest of the no is greater than 1 then again do union of rest of no and
 * curr no index
 * like - 2*2*3 = 12, if we remove 2, 3 will be invalid for 12, clearly 3 and 12
 * are connected with common factorial 3
 * At last return true if all indices are connected ie all nos are connected ie
 * all nos have common factorial
 * 
 * Approach
 * 
 * Requirement for i < j is there to confuse us.
 * 
 * Complexity
 * 
 * Time complexity: O(n∗sqrt(n)), traversing each no and
 * doing thier prime factorization
 * 
 * Space complexity: O(n), union of indices for all nos
 * 
 */
class Solution {
    public boolean canTraverseAllPairs(int[] nums) {

        int n = nums.length;
        DSU d = new DSU(n);

        int m = Arrays.stream(nums).max().orElse(0);
        int[] first = new int[m + 1];
        Arrays.fill(first, -1);

        for (int i = 0; i < n; i++) {
            // prime factorization
            for (int prime = 2; prime * prime <= nums[i]; prime++) {
                if (nums[i] % prime != 0)
                    continue;

                // union prime index and nums[i] index
                if (first[prime] != -1)
                    d.union(first[prime], i);
                else
                    first[prime] = i;
                // remove all instances of found prime
                while (nums[i] % prime == 0)
                    nums[i] /= prime;
            }
            // union rest of the nums[i] with curr nums[i] index
            // 2*2*3 = 12, remove 2, 3 will be invalid
            if (nums[i] > 1) {
                if (first[nums[i]] != -1)
                    d.union(first[nums[i]], i);
                else
                    first[nums[i]] = i;
            }
        }
        // all nos are connected by atleast one factorial
        return d.united();
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
    }
}