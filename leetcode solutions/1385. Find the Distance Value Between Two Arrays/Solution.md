# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will first sort array 2
- then we will traverse arr1, and for each arr1 find the lower bound in arr2
- if the lower bound index is 0, all nos will be greater than arr1[i]
- if the lower bound index is n, all nos will be smaller than arr1[i]
- if the lower bound is in middle, we will check if there are nos both greater and smaller than arr1[i]
- In all above cases count will be increased by 1
- finally return count

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(nlogn)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(1)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);

        int count = 0;
        int n = arr2.length;

        for (int i = 0; i < arr1.length; i++) {
            int j = lowerBound(arr2, arr1[i]);

            //all nos are greater than or equal to arr1[i]
            if (j == 0) {
                if (arr2[0] - arr1[i] > d) {
                    count++;
                }
            }
            //all nos are smaller than arr1[i]
            else if (j >= n) {
                if (arr1[i] - arr2[n - 1] > d) {
                    count++;
                }
            }
            else {
                if (arr2[j] - arr1[i] > d && arr1[i] - arr2[j - 1] > d) {
                    count++;
                }
            }
        }
        return count;
    }

    private int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
```