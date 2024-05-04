/**
 * 881. Boats to Save People
 * 
 * Intuition
 * Target
 * 
 * minimum no of boats to carry all people
 * 
 * Given
 * 
 * weight of people will be less than or equal to limit
 * 
 * Solution
 * 
 * We will solve this problem using two-ptrs
 * If it was just the count of boat we could have solved it by simple traversal
 * According to question we need minimum boats, so we will accomodate heaviest
 * and thinnest person, if that is not possible we will accomodate only heaviest
 * person as it will be less than or equal to limit.
 * 
 * Approach
 * 
 * sort the people array
 * use two ptrs approach, to accomodate the heaviest and thinnest person, if
 * that is possible update both ptrs
 * if above is not possible, then accomodate only heaviest person and update end
 * ptr
 * Increase boat count by 1 in each loop
 * If both ptr are equal we will need one boat, no matter it is greater or less
 * than limit, bcs only one person is left.
 * 
 * Complexity
 * 
 * Time complexity: O(nlogn)
 * 
 * Space complexity: O(1)
 * 
 */

class Solution {
    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);
        int start = 0, end = people.length - 1, count = 0;

        while (start <= end) {
            if (people[start] + people[end] <= limit) {
                start++;
                end--;
            } else
                end--;
            count++;
        }
        return count;
    }
}