# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- credits Aryan
- Lets understand it with example
- like `[3,4,5,1,2]` we already have one combination so we return `res - 1;`
- `3` is the root and its position is fixed at `1`. So we need to calculate combination for rest `4` positions.
- left nodes are `1,2` and right nodes are `4,5`.
- `1` must come before `2`. `4` must come before `5`. `1` & `4` can come in any order. same way `2` & `5` can come in any order. Otherwise we will get diff bst.
- nodes at same level can come in any order.
```
[3,1,2,4,5]
[3,1,4,2,5]
[3,1,4,5,2]
[3,4,1,2,5]
[3,4,1,5,2]
```
- Notice `1` is always before `2` and `4` before `5`
- construct `[3,1,2,4,5]` bst and `[3,2,1,4,5]` bst, both will be different
- our goal is to get duplicate of given tree. Just way of writing it is diff.
- so for `4` positions lets arrange left nodes first you can pick right too
- `(n-1)C(left) * (ways for left) * (n-1)-(left)C(n-1)-(left) * (ways for right).`
- `(n-1)-(left)C(n-1)-(left) will always be 1.`
- `res = (n-1)C(left) * (ways for left) * 1 * (ways for right).`
- suppose we `[1,2,3]` as left node. so its no ways will be `2`. for `[1,2]` no of ways is `1`.
- to have combinations result handy we have pascal triangle.

# Complexity
- Time complexity: `O(n^2)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(n^2)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
- Note: pascal triangle is taking `O(n^2)` space & time. otherwise other operation takes `O(n)`, visiting each node once.

# Code
credits chyyyy
```
class Solution {
    long mod = (long) 1e9 + 7;

    public int numOfWays(int[] nums) {

        int len = nums.length;
        List<Integer> arr = new ArrayList();
        for (int n : nums)
            arr.add(n);
        return (int) getCombs(arr, getTriangle(len + 1)) - 1;
    }

    private long getCombs(List<Integer> nums, long[][] combs) {

        if (nums.size() <= 2)
            return 1;

        int root = nums.get(0);
        List<Integer> left = new ArrayList();
        List<Integer> right = new ArrayList();
        for (int n : nums) {
            if (n < root)
                left.add(n);
            else if (n > root)
                right.add(n);
        }
        // mod every operation to avoid overflow
        return (combs[left.size() + right.size()][left.size()] *
                (getCombs(left, combs) % mod) % mod) * getCombs(right, combs) % mod;
    }

    private long[][] getTriangle(int n) {
        // Yang Hui (Pascle) triangle
        // 4C2 = triangle[4][2] = 6
        long[][] triangle = new long[n][n];
        for (int i = 0; i < n; i++)
            triangle[i][0] = triangle[i][i] = 1;
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                triangle[i][j] = (triangle[i - 1][j] + triangle[i - 1][j - 1]) % mod;
            }
        }
        return triangle;
    }
}
```
# Code 2
```
class Solution {
    long mod = (long) (1e9 + 7);
    long[][] pt;

    public int numOfWays(int[] nums) {
        int n = nums.length;

        pt = new long[n + 1][];
        for (int i = 0; i <= n; i++) {
            pt[i] = new long[i + 1];
            Arrays.fill(pt[i], 1);

            for (int j = 1; j < i; j++) {
                pt[i][j] = (pt[i - 1][j - 1] + pt[i - 1][j]) % mod;
            }
        }

        List<Integer> l = new ArrayList();
        for (int x : nums) {
            l.add(x);
        }

        return (int) ((solve(l) - 1 + mod) % mod);
    }

    private long solve(List<Integer> nums) {
        int m = nums.size();

        if (m < 3)
            return 1;

        List<Integer> l = new ArrayList();
        List<Integer> r = new ArrayList();

        int root = nums.get(0);
        for (int i = 1; i < m; i++) {
            if (nums.get(i) < root)
                l.add(nums.get(i));
            else
                r.add(nums.get(i));
        }

        long lWays = solve(l) % mod;
        long rWays = solve(r) % mod;

        return (((lWays * rWays) % mod) * pt[m - 1][l.size()]) % mod;
    }
}
```