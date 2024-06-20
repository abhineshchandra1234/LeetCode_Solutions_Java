/**
 * 1552. Magnetic Force Between Two Balls
 * 
 * Intuition
 * 
 * we are given positions of n baskets
 * we are also have given m balls
 * we need to maintain maximum force between any 2 balls and return it
 * magnetic force between two balls at positions x and y is |x- y|
 * It is a maximization problem, which can be solved using binary search max
 * algo
 * Maximum force between 2 balls can be (maxPos - minPos)/(m-1)
 * But in order to return this solution we need to have baskets at suitable
 * positions, otherwise we will get much lower value
 * So we will check feasibilty of force using binary search and try to maximize
 * it
 * the range will be from min force of 1 to max force of (maxPos - minPos)/(m-1)
 * 
 * Approach
 * 
 * we will first sort positions, so that we can later check feasibility
 * Then we will apply binary search maximization algo on low and high forces and
 * return ans
 * For checking feasility, we will pass mid as maximized force
 * we will start from first postion and just check if we have m forces greater
 * than mid
 * if difference of last and curr is greater than mid, update last and it is a
 * suitable soln
 * If above condition satisfies return true, else false
 * 
 * Complexity
 * 
 * Time complexity: O(nlogn), sorting or binary search
 * 
 * Space complexity: O(logn), sorting
 * 
 */
class Solution {
    public int maxDistance(int[] positions, int m) {

        int n = positions.length;
        Arrays.sort(positions);
        int l = 1;
        int h = (positions[n - 1] - positions[0]) / (m - 1);
        int ans = 1;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (feasible(mid, positions, m)) {
                ans = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }

        }

        return ans;
    }

    private boolean feasible(int mid, int[] positions, int m) {
        int cnt = 1;
        int last = positions[0];
        for (int i = 0; i < positions.length; i++) {
            if (positions[i] - last >= mid) {
                cnt++;
                last = positions[i];
            }
            if (cnt >= m) {
                return true;
            }

        }
        return false;
    }
}