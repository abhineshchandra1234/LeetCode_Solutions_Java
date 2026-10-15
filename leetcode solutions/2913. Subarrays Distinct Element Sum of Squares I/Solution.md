# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will solve this problem using simulation
- we will generate every possible subarray and store it in a set
- now for each addition, we will take square of size of set and add it in the res
- Finally return the res

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(n^2)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(n)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    public int sumCounts(List<Integer> nums) {

        int n = nums.size(), res = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> s = new HashSet();
            for (int j = i; j < n; j++) {
                s.add(nums.get(j));
                res += s.size() * s.size();
            }
        }

        return res;
    }
}
```