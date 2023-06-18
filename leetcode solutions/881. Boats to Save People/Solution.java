/**
 * 881. Boats to Save People
 * 
 * Intuition
 * We will try to accommodate the heaviest and thinnest person if that is not
 * possible we will accommodate only the heaviest person
 * 
 * Approach
 * sort the people array
 * use two ptrs approach, to accommodate the heaviest and thinnest person, if
 * is possible to update both ptrs
 * if the above is not possible, then accommodate only the heaviest person and
 * update the end
 * ptr
 * Increase boat count by 1 in each loop
 * If both ptr are equal we will need one boat, no matter if it is greater or
 * less
 * than the limit, BCS only one person is left.
 * 
 * Complexity
 * Time complexity: O(nlogn)
 * Space complexity: O(1)
 */

class Solution {
    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);
        int start = 0;
        int end = people.length - 1;
        int minBoat = 0;

        while (start <= end) {
            if (people[start] + people[end] <= limit) {
                start++;
                end--;
            } else {
                end--;
            }
            minBoat++;
        }
        return minBoat;
    }
}