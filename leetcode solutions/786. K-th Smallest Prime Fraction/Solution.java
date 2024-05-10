/**
 * 786. K-th Smallest Prime Fraction
 * 
 * Intuition
 * Given
 * 
 * we have a sorted array of prime nos
 * we are also given a no k
 * 
 * Target
 * 
 * Out of all the fraction combinations of prime nos, we need to return kth
 * smallest fraction's numerator and denominator
 * 
 * Solution
 * 
 * Approach 1
 * we can simply add all possible fraction combination, with thier numerator and
 * denominator in a max heap of size k
 * The top element of the heap will be our answer
 * It takes O(n^2) time, lets optimize it
 * Approach 2
 * we will use first smallest to find the kth smallest
 * we will find first smallest by dividing all nos with the last no and storing
 * them in the min heap alongwith thier indices
 * top element will be the first smallest
 * then we will find the next smallest by dividing nos at index i & j-1, where i
 * is the numerator and j is the denominator indices of the first or prev
 * smallest fraction
 * we will keep doing this till we reach kth smallest
 * Finally we will pop top element of min heap and return it as res
 * 
 * Note : First smallest = smallest / largest
 * Second smallest = smallest / largest - 1
 * Third smallest = smallest / largest - 2
 * we just need indices of first smallest
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(nlogn)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        int n = arr.length;

        PriorityQueue<double[]> minHeap = new PriorityQueue<>((a, b) -> Double.compare(a[0], b[0]));

        for (int i = 0; i < n; i++)
            minHeap.add(new double[] { 1.0 * arr[i] / arr[n - 1], (double) i, (double) n - 1 });

        int count = 1;
        while (count < k) {
            double[] l = minHeap.poll();
            int i = (int) l[1];
            int j = (int) l[2] - 1;
            minHeap.add(new double[] { 1.0 * arr[i] / arr[j], (double) i, (double) j });
            count++;
        }

        double[] l = minHeap.poll();
        int i = (int) l[1];
        int j = (int) l[2];

        return new int[] { arr[i], arr[j] };
    }
}