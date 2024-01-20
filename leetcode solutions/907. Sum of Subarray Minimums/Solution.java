/**
 * 907. Sum of Subarray Minimums
 * 
 * Intuition
 * 
 * credits wxd_sjtu
 * 
 * Input: arr = [3,1,2,4]
 * Output: 17
 * for 1
 * left min dist - 2, right min dist - 3
 * total combinations - 2 * 3 -> 6 {[3,1], [3,1,2],
 * [3,1,2,4], [1], [1,2], [1,2,4]}
 * total sum of subarrays with 1 as min - 1 * 6 -> 6,
 * as 1 is added to each sub-array
 * 
 * similarly we can add subarrays sum for each no to res
 * res = (int) ((res + (long) arr[i] * left[i] * right[i]) % mod);
 * 
 * Approach
 * 
 * we will use two monotonous increasing stack, to track prev and next min
 * using prev stack we will update left min dist for each no
 * using next stack we will update right min dist for each no
 * Note - When we update left dist added element of prev stack is updated
 * when we update right dist removed element of next stack is updated.
 * 
 * Complexity
 * 
 * Time complexity: O(n), we are traversing array once
 * 
 * Space complexity: O(n), for monotonous increasing stacks & dist
 * arrays
 * 
 * 
 */
class Solution {
    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;

        // track prev and next min
        Stack<Pair> prev = new Stack();
        Stack<Pair> next = new Stack();

        // dist prev min
        int[] left = new int[n];
        // dist next min
        int[] right = new int[n];

        // initialize left and right
        for (int i = 0; i < n; i++) {
            left[i] = i + 1;
            right[i] = n - i;
        }

        // update left and right by traversing the array
        for (int i = 0; i < n; i++) {

            // update left
            // added element index is updated
            while (!prev.isEmpty() && prev.peek().value > arr[i])
                prev.pop();
            left[i] = prev.isEmpty() ? i + 1 : i - prev.peek().index;
            prev.push(new Pair(arr[i], i));

            // update right
            // removed element index is updated
            while (!next.isEmpty() && next.peek().value > arr[i]) {
                Pair x = next.pop();
                right[x.index] = i - x.index;
            }
            next.push(new Pair(arr[i], i));
        }

        // calculate res with left, right and arr
        int res = 0, mod = (int) 1e9 + 7;
        for (int i = 0; i < n; i++)
            res = (int) ((res + (long) arr[i] * left[i] * right[i]) % mod);

        return res;
    }

    class Pair {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}