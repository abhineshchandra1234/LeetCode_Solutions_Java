/**
 * 502. IPO
 * 
 * Intuition
 * 
 * we have been given n projects with n pure profits and n capital to start each
 * project
 * we have inital capital w, once we finish a project, its profit is added to
 * the total capital
 * you are given an integer k, we need to pick at most k projects, to maximize
 * the initial capital w, and return w.
 * One thing to note here is that no money is getting reduced from the final
 * capital w, to start new project or enough capital is checked.
 * 
 * Approach
 * 
 * we will create an entity of capital & profit, we will sort its list based on
 * capital
 * Then we will run a loop of length k, to select k max profits
 * Inside we will run another loop to traverse all entities once globally, as
 * profits are already stored for them
 * entities whose project we can start using existing capital, add its profit to
 * max heap
 * Pop the profit from max heap at the end of outer loop and add it to total
 * capital, ie we are choosing the max profit among all profits
 * Return the total capital at the end
 * 
 * Complexity
 * 
 * Time complexity: O(nlogn), sorting entity based on capital
 * 
 * Space complexity: O(n), storing entity or profits
 * 
 */
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int n = profits.length;

        int[][] entity = new int[n][2];

        for (int i = 0; i < n; i++) {
            entity[i][0] = capital[i];
            entity[i][1] = profits[i];
        }

        Arrays.sort(entity, ((a, b) -> a[0] - b[0]));

        PriorityQueue<Integer> maxProfit = new PriorityQueue<>((a, b) -> b - a);

        int i = 0, res = 0;
        while (k-- > 0) {
            while (i < n && entity[i][0] <= w) {
                maxProfit.add(entity[i][1]);
                i++;
            }

            // we do not have enough capital to continue
            if (maxProfit.isEmpty())
                break;

            w += maxProfit.poll();
        }

        return w;
    }
}