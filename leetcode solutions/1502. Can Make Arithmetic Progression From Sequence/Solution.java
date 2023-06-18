/**
 * 1502. Can Make Arithmetic Progression From Sequence
 * 
 * Intuition
 * credits Aryan
 * Airthmetic series is like a, a+d, a+2d, ..., a+(n-1)d
 * nth term = a+(n-1)d
 * Brute soln
 * Sort the array and compare adjacent nos
 * i-1 - i == i-2 - i-1
 * t - O(nlogn), s - O(1)
 * Better soln
 * min - a, max - a+(n-1)d
 * We can find min & max from arr and get d
 * We can use d to generate nos like a, a+d, a+2d and using set check if these
 * nos exist in arr
 * t - O(n), s - O(n)
 * Optimized soln
 * At every indexi we can know which no will come(arr[i]==min_val+i*d), we will
 * keep swapping the nos till we get correct no or if cond doesnt satisfy return
 * false.
 * like - 3, 9, 5, 7
 * after 3, 5 should come and correct place of 9 is 4th. so we will swap 9 & 7
 * 3, 7, 5, 9
 * now again correct place of 7 is 3rd. so we will swap 7 & 5
 * 3, 5, 7, 9
 * this is the correct sequence and we will return true.
 * t - O(n), s - O(1)
 * 
 * Approach
 * we are doing mod operation before actual calculation for d to check if d is
 * valid or not.
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {

        int n = arr.length;
        if (arr.length <= 2)
            return true;
        int min_val = Integer.MAX_VALUE, max_val = Integer.MIN_VALUE;
        for (int num : arr) {
            min_val = Math.min(min_val, num);
            max_val = Math.max(max_val, num);
        }
        if ((max_val - min_val) % (n - 1) != 0)
            return false;
        int d = (max_val - min_val) / (n - 1);
        int i = 0;
        while (i < n) {
            if (arr[i] == min_val + i * d)
                i++;
            else if ((arr[i] - min_val) % d != 0)
                return false;
            else {
                int pos = (arr[i] - min_val) / d;
                if (pos < i || arr[pos] == arr[i])
                    return false;
                swap(i, pos, arr);
            }
        }
        return true;
    }

    private void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}