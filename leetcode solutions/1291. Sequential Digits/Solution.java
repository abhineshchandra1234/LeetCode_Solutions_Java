/**
 * 1291. Sequential Digits
 * 
 * 
 * Intuition
 * 
 * we will generate all possible sequential digits from 1 to 9 digit nos
 * we will start from generating sequential digit for 1 digit no then add them
 * to queue
 * Then we will pop prev level and generate next level and add them to queue
 * if the no falls under boundary add them to res otherwise break the loop and
 * return the res
 * 
 * Approach
 * 
 * sequential digits
 * 1, 2, 3, 4, 5, 6, 7, 8, 9 -> 9
 * 12, 23, 34, 45, 56, 67, 78, 89 -> 8
 * ...
 * 123456789 -> 1
 * nos ending with 9 is increasing with
 * each level so possible digits is decreasing
 * 
 * total sequential digits for 9 levels is n(n+1)/2 -> 45
 * 
 * 1234, 2345, 3456
 * 12345, 23456, 34567
 * notice all nos are invalid from 23456, so we will break the loop
 * 
 * Complexity
 * 
 * Time complexity: O(1), max O(45) for 9 levels
 * 
 * Space complexity: O(1), max O(45) for 9 levels
 * 
 */
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        Queue<Integer> q = new LinkedList();
        // first level
        for (int i = 1; i <= 9; i++)
            q.add(i);

        List<Integer> res = new ArrayList();
        while (!q.isEmpty()) {
            int f = q.poll();
            // inside boundary
            if (f <= high && f >= low)
                res.add(f);

            // next level outside boundary starts
            if (f > high)
                break;

            int num = f % 10;
            // next ending no will be 10 which is invalid
            // create next level
            if (num < 9)
                q.add(f * 10 + (num + 1));
        }

        return res;
    }
}