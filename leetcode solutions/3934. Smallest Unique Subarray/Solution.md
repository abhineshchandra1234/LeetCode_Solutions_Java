# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will try different sub array length ie k
- we will create hash of first subarray of length k
- we will move the window one no at a time
- we will update the hash by removing the outgoing no and adding the incoming no
- we will store all the hash in a map and count their frequencies
- if any hash has frequency 1, isPossible returns true
- if any unique subarray exist we will try a smaller length r = m-1
- otherwise a larger length l = m+1
- Finally return res which stores the smallest length found

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

    long base = (long) (1e5 + 7);
    long mod = (long) (1e9 + 7);

    public int smallestUniqueSubarray(int[] nums) {
        int l = 1, r = nums.length;
        int res = nums.length;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (isPossible(nums, m)) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }

    private boolean isPossible(int[] nums, int k) {
        int n = nums.length;
        HashMap<Long, Integer> map = new HashMap();

        long hash = 0;
        long power = 1;

        for (int i = 0; i < k; i++) {
            hash = (hash * base + nums[i]) % mod;
            if (i < k - 1) {
                power = (power * base) % mod;
            }
        }

        map.put(hash, 1);

        for (int i = k; i < n; i++) {
            hash = (hash - nums[i - k] * power % mod + mod) % mod;
            hash = (hash * base + nums[i]) % mod;

            map.put(hash, map.getOrDefault(hash, 0) + 1);
        }

        for (int val : map.values()) {
            if (val == 1)
                return true;
        }

        return false;
    }
}
```