/**
 * 2251. Number of Flowers in Full Bloom
 * 
 * Intuition
 * 
 * Brute Approach
 * Pick people arrival time and if it comes under range of flower[i], then we
 * got 1 valid flower. TC - O(mn)
 * Optimised Approach
 * Suppose we have three flowers which have start time less than or equal to
 * arrival time of people.
 * Then we have 3 valid flowers
 * Now suppose out of these one flower end time is less than arrival time, so by
 * the time people reach that flower will be dead.
 * formula = no of valid start - no of valid end
 * start value will be less than or equal to arrival time for valid flowers
 * end value will be strictly less than arrival time for valid flowers
 * we can find no of valid start and end value through binary search if they are
 * sorted.
 * 
 * Approach
 * 
 * arrival time = 7
 * s = [1,3,9,4] -> 1,3,4 pairs are valid
 * e = [6,7,12,13] -> 6 ie [1,6] is invalid, [3,7],[4,13] are valid
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(nlogn), we are sorting start and end array
 * 
 * Space complexity:
 * 
 * O(n), space for start and end array
 * 
 */
class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {

        int n = flowers.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int[] res = new int[people.length];

        for (int i = 0; i < people.length; i++) {
            int t = people[i];
            int started = binarySearchUpperBound(start, t);
            int ended = binarySearchLowerBound(end, t);
            res[i] = started - ended;
        }
        return res;
    }

    private int binarySearchUpperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    private int binarySearchLowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}