# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- we will first calculate freq of all digits
- then for `hundread` place we can have no `1 to 9`
- for `tens` place we can have a no from `0 to 9`
- for `units` place we can have no from `0 to 8 and all even`
- then we will run three loops from start for all nos and construct the no
- these nos will be added to the res
- Finally we will sort the res and return it as an array

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: `O(1)`
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: `O(1)`
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    public int totalNumbers(int[] digits) {
        List<Integer> res = new ArrayList();
        int[] freq = new int[10];

        for (int digit : digits) {
            freq[digit]++;
        }

        for (int i = 1; i <= 9; i++) {
            if (freq[i] == 0)
                continue;
            freq[i]--;
            for (int j = 0; j <= 9; j++) {
                if (freq[j] == 0)
                    continue;
                freq[j]--;
                for (int k = 0; k <= 8; k += 2) {
                    if (freq[k] == 0)
                        continue;
                    freq[k]--;

                    int num = i * 100 + j * 10 + k;
                    res.add(num);
                    freq[k]++;
                }
                freq[j]++;
            }
            freq[i]++;
        }
        Collections.sort(res);
        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }

        return resArr.length;
    }
}
```