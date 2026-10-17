# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will first sort the nums array based on digit sum and curr value and store in sorted array
- then we will store index for all nos in nums into a map
- then we will traverse sorted array and nums array together
- we will check if curr value is equal to expected value, if it is we will continue
- otherwise we will swap expected value and curr value and store their new index in the map
- we will also increase swap value and finally return it 

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

    public int minSwaps(int[] nums) {
        int n = nums.length;

        Integer[] sorted = new Integer[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = nums[i];
        }

        Arrays.sort(sorted, this::compareDigitSum);

        Map<Integer, Integer> valIdx = new HashMap();
        for (int i = 0; i < n; i++) {
            valIdx.put(nums[i], i);
        }

        int swap = 0;
        for (int i = 0; i < n; i++) {
            int expected = sorted[i];
            int curr = nums[i];

            if (expected == curr)
                continue;

            int idx = valIdx.get(expected);

            nums[i] = expected;
            nums[idx] = curr;

            valIdx.put(expected, i);
            valIdx.put(curr, idx);

            swap++;
        }
        return swap;
    }

    private int compareDigitSum(int num1, int num2) {
        int n1Sum = digitSum(num1);
        int n2Sum = digitSum(num2);

        if (n1Sum != n2Sum)
            return Integer.compare(n1Sum, n2Sum);

        return Integer.compare(num1, num2);
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
```