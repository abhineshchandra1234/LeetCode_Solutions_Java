# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will solve this using cumulative product
- we will have a count variable n, which will keep count of nos added
- if curr no is equal to zero, we will clear the res list and count var, bcs cumalative product till curr no will be zero also we need cumalative product from next no
- if curr no is not zero we will multiply curr with n-1 and add it in the res
- if k>n we will return 0, as the res is empty
- if k==n return prod of n-1
- res for k nos will be equal to prod of `n-1/n-1-k` 

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(1)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(n)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class ProductOfNumbers {
    private List<Integer> nums;
    private int n;

    public ProductOfNumbers() {
        nums = new ArrayList();
        n = 0;
    }

    public void add(int num) {
        if (num == 0) {
            nums.clear();
            n = 0;
        } else {
            if (nums.isEmpty()) {
                nums.add(num);
            } else {
                nums.add(nums.get(n - 1) * num);
            }
            n++;
        }
    }

    public int getProduct(int k) {
        if (k > n) {
            return 0;
        } else if (k == n) {
            return nums.get(n - 1);
        }

        return nums.get(n - 1) / nums.get(n - k - 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
```