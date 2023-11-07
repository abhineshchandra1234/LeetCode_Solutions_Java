/**
 * 1921. Eliminate Maximum Number of Monsters
 * 
 * Intuition
 * 
 * we can solve this problem through sorting
 * we will calculate arr[i] = dist[i]/speed[i] arrival time for each monster and
 * sort it, since we need to kill monster arriving first
 * if some monster arrive before or at the time we reload we lost otherwise we
 * will increase the monster count
 * First monster will always take some time and will be greater than initial
 * time 0, so we can eliminate it
 * 
 * Approach
 * 
 * Input: dist = [3,2,4], speed = [5,3,2]
 * Output: 1
 * first reload at 0 -> 3/5 -> 0.6 eliminated [x,0.6,2]
 * second reload at 1 -> lost [x,0,1], second monster arrived at 0.6, which is
 * 0.4 unit faster than 1
 * 
 * Complexity
 * 
 * Time complexity: O(nlogn)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {

        double[] arr = new double[dist.length];
        for (int i = 0; i < dist.length; i++)
            arr[i] = (double) dist[i] / speed[i];

        Arrays.sort(arr);
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= i)
                break;
            ans++;
        }
        return ans;
    }
}