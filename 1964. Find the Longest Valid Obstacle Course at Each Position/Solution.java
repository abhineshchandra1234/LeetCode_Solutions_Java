/**
 * 1964. Find the Longest Valid Obstacle Course at Each Position
 * 
 * Intuition
 * the question says longest valid obstacle should be in same order, you must
 * include ith obstacle and ith obstacle will be>= last no in lis.
 * This problem is similar to 300. Longest Increasing Subsequence
 * We will maitain an longest valid obstacle throughout the answer
 * first char we will added to lis(longest increasing subsequence) without any
 * comparison.
 * From second no we will check largest or last no of lis<= new no
 * This no can be straightforward and exist at end or someplace in between lis
 * we will add new char at index l+1.
 * Rest of the lis will exist but we will consider only till l+1 which satisfy
 * all conditions.
 * Since lis is already sorted we are using binary search.
 * obstacles = [1,2,3,2]
 * i=0 , 1 will be added without any comaparison -> 1
 * i=1, 2 is greater than top of lis 1 at index 0 so it will be added at 0+1=1
 * index. No need of binary search here. -> 2
 * i=2, 3 is greater than top 2 and will be added at index 2. -> 3
 * i=3, 2 is not greater than top 3 and we must include 2 and satisfy other
 * conds, so we will do binary search to find no<=2 which we got at index 1, so
 * we will insert 2 at 1+1=2 index. -> 3
 * lis-1,2,2 res=1,2,3,3
 * 
 * Approach
 * For simplicity I have done binary serach at every index to update lis.
 * You can compare new no with top of lis, if doesnt satisfy the cond then you
 * can do binary search
 * 
 * Complexity
 * Time complexity:
 * O(nlogn), for doing binary search for each index
 * 
 * Space complexity:
 * 
 * O(n), for storing longest valid obstacle
 */
class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {

        int n = obstacles.length, length = 0, res[] = new int[n], lis[] = new int[n];
        for (int i = 0; i < n; i++) {
            int l = 0, r = length;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (lis[m] <= obstacles[i])
                    l = m + 1;
                else
                    r = m;
            }
            lis[l] = obstacles[i];
            res[i] = l + 1;
            if (length == l)
                length++;
        }
        return res;
    }
}